package baseball.domain;

import java.util.Arrays;
import java.util.HashMap;

public class Referee {

    private final Integer[] computerNumbers;
    private final Integer[] userNumbers;
    private final HashMap<String, Integer> numberResult = new HashMap<>();

    public Referee(Integer[] computerNumbers, Integer[] userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    public HashMap<String, Integer> getNumberResult() {
        return numberResult;
    }

    public void addStrike(int index) {
        if (computerNumbers[index].equals(userNumbers[index])) {
            numberResult.put("strike", numberResult.getOrDefault("strike", 0) + 1);
        }
    }


    public void addBall(int index) {
        if (!computerNumbers[index].equals(userNumbers[index])
                && Arrays.asList(computerNumbers).contains(userNumbers[index])) {
            numberResult.put("ball", numberResult.getOrDefault("ball", 0) + 1);
        }
    }

    public void addNothing(int index) {
        if (!Arrays.asList(computerNumbers).contains(userNumbers[index])) {
            numberResult.put("nothing", numberResult.getOrDefault("nothing", 0) + 1);
        }
    }

    public void getGameScore() {
        for (int i = 0; i < userNumbers.length; i++) {
            addStrike(i);
            addBall(i);
            addNothing(i);
        }
    }
}
