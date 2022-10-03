package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.common.BallStatus;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {
    Referee referee = null;


    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,1", "2,1"})
    void 스트라이크(int index, int count) {
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {4, 2, 5};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addStrike(index);
        HashMap<BallStatus, Integer> numberResult = referee.getNumberResult();
        assertEquals(numberResult.getOrDefault(BallStatus.STRIKE, 0), count);

    }

    @Test
    void 스트라이크_전체() {
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {4, 2, 5};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addStrike(0);
        referee.addStrike(1);
        referee.addStrike(2);

        assertEquals(referee.getNumberResult().getOrDefault(BallStatus.STRIKE, 0), 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,0"})
    void 볼(int index, int count){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {4, 5, 6};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addBall(index);
        assertEquals(referee.getNumberResult().getOrDefault(BallStatus.BALL, 0), count);

    }

    @Test
    void 볼_전체() {
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {5, 4, 2};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addBall(0);
        referee.addBall(1);
        referee.addBall(2);

        assertEquals(referee.getNumberResult().getOrDefault(BallStatus.BALL, 0), 3);
    }

    @Test
    void 낫싱(){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {1, 3, 6};
        referee = new Referee(computerNumbers, userNumbers);
        referee.addNothing(0);
        referee.addNothing(1);
        referee.addNothing(2);

        assertEquals(referee.getNumberResult().getOrDefault(BallStatus.NOTHING, 0), 3);
    }

    @Test
    void 심판_판정(){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {6, 2, 4};
        referee = new Referee(computerNumbers, userNumbers);
        referee.getGameScore();
        HashMap<BallStatus, Integer> numberResult = referee.getNumberResult();

        assertEquals(numberResult.get(BallStatus.STRIKE),1);
        assertEquals(numberResult.get(BallStatus.BALL),1);
        assertEquals(numberResult.get(BallStatus.NOTHING),1);
    }


}