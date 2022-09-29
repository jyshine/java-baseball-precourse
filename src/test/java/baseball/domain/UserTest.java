package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserTest {


    @ParameterizedTest
    @CsvSource(value = {"123,true", "112,true", "4,false", "5,false", "54444,false"})
    void 사용자_입력_번호_유효성_자릿수(String userInput, boolean result) {
        User user = new User();

        // when
        boolean isLengthValidate = user.isLengthValidate(userInput);

        assertEquals(result, isLengthValidate);

    }

    @ParameterizedTest
    @CsvSource(value = {"123,true", "112,true", "ㄹㄹㄹ,false", "aaaa,false", " 1m2,false"})
    void 사용자_입력_번호_유효성_숫자(String userInput, boolean result) {
        User user = new User();

        // when
        boolean isNumbericValidate = user.isNumbericValidate(userInput);

        // then
        assertEquals(result, isNumbericValidate);

    }

    @ParameterizedTest
    @CsvSource(value = {"123,true", "112,false", "333,false", "534,true", " 111,false"})
    void 사용자_입력_번호_유효성_중복(String userInput, boolean result) {
        User user = new User();

        // when
        boolean isDupsValidate = user.isDupsValidate(userInput);

        // then
        assertEquals(result, isDupsValidate);

    }

    @Test
    void 사용자_입력_유효성() {
        // given
        User user = new User();
        // when then
        assertThatThrownBy(() -> {
            user.isReadInputValidate("112");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자");

        assertThatThrownBy(() -> {
            user.isReadInputValidate("1122");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리");

        assertThatThrownBy(() -> {
            user.isReadInputValidate("ㄲㄲㄱ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리");
    }

}