package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    public Integer[] createRandomNumber() {
        Integer[] randomNumberArray = new Integer[3];
        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() <3){
            int randomNumber = pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }

        return randomNumbers.toArray(randomNumberArray);
    }
}
