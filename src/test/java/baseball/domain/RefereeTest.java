package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.common.BallStatus;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
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
        assertEquals(numberResult.getOrDefault("strike", 0), count);

    }

    @Test
    void 스트라이크_전체() {
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {4, 2, 5};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addStrike(0);
        referee.addStrike(1);
        referee.addStrike(2);

        assertEquals(referee.getNumberResult().getOrDefault("strike", 0), 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,0"})
    void 볼(int index, int count){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {4, 5, 6};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addBall(index);
        assertEquals(referee.getNumberResult().getOrDefault("ball", 0), count);

    }

    @Test
    void 볼_전체() {
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {5, 4, 2};
        referee = new Referee(computerNumbers, userNumbers);

        referee.addBall(0);
        referee.addBall(1);
        referee.addBall(2);

        assertEquals(referee.getNumberResult().getOrDefault("ball", 0), 3);
    }

    @Test
    void 낫싱(){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {1, 3, 6};
        referee = new Referee(computerNumbers, userNumbers);
        referee.addNothing(0);
        referee.addNothing(1);
        referee.addNothing(2);

        assertEquals(referee.getNumberResult().getOrDefault("nothing", 0), 3);
    }

    @Test
    void 심판_판정(){
        Integer[] computerNumbers = {4, 2, 5};
        Integer[] userNumbers = {6, 2, 4};
        referee = new Referee(computerNumbers, userNumbers);
        referee.getGameScore();
        HashMap<BallStatus, Integer> numberResult = referee.getNumberResult();

        assertEquals(numberResult.get("strike"),1);
        assertEquals(numberResult.get("ball"),1);
        assertEquals(numberResult.get("nothing"),1);
    }


}