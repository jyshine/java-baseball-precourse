package baseball.domain;

import baseball.common.BallStatus;
import baseball.common.Message;
import java.util.Arrays;
import java.util.HashMap;

public class Referee {

    private final Integer[] computerNumbers;
    private final Integer[] userNumbers;
    private final HashMap<BallStatus, Integer> numberResult = new HashMap<>();

    public Referee(Integer[] computerNumbers, Integer[] userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    public HashMap<BallStatus, Integer> getNumberResult() {
        return numberResult;
    }

    public void addStrike(int index) {
        if (computerNumbers[index].equals(userNumbers[index])) {
            this.numberResult.put(BallStatus.STRIKE, numberResult.getOrDefault(BallStatus.STRIKE, 0) + 1);
        }
    }


    public void addBall(int index) {
        if (!computerNumbers[index].equals(userNumbers[index])
                && Arrays.asList(computerNumbers).contains(userNumbers[index])) {
            this.numberResult.put(BallStatus.BALL, numberResult.getOrDefault(BallStatus.BALL, 0) + 1);
        }
    }

    public void addNothing(int index) {
        if (!Arrays.asList(computerNumbers).contains(userNumbers[index])) {
            this.numberResult.put(BallStatus.NOTHING, numberResult.getOrDefault(BallStatus.NOTHING, 0) + 1);
        }
    }

    public HashMap<BallStatus, Integer> getGameScore() {
        for (int i = 0; i < userNumbers.length; i++) {
            addStrike(i);
            addBall(i);
            addNothing(i);
        }

        return this.numberResult;
    }

    public String convertGameScoreMessage(HashMap<BallStatus, Integer> numberResult) {
        StringBuilder sb = new StringBuilder();
        for (BallStatus key : numberResult.keySet()) {
            getMessage(numberResult, sb, key);
        }
        return sb.toString();

    }

    private void getMessage(HashMap<BallStatus, Integer> numberResult, StringBuilder sb, BallStatus key) {
        if (key.equals(BallStatus.NOTHING) && numberResult.get(key) == 3) {
            sb.append(key.getStatus());
        }

        if (!key.equals(BallStatus.NOTHING)) {
            sb.append(numberResult.get(key));
            sb.append(key.getStatus());
        }
    }
}
