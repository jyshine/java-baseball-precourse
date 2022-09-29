package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 랜덤번호_생성() {
        // given
        Computer computer = new Computer();
        for (int i = 0; i < 100; i++) {
            // when
            Integer[] randomNumbers = computer.createRandomNumber();
            // then
            assertThat(randomNumbers[0]).isNotEqualTo(randomNumbers[1]).isNotEqualTo(randomNumbers[2]);
        }
    }

}