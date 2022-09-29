package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split(){
        // given
        String testValue = "1";
        // when
        List<String> split = Arrays.asList(testValue.split(","));
        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");

    }

    @Test
    void substring(){
        // given
        String testValue = "(1,2)";
        // when
        String substring = testValue.substring(1, 4);
        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        // given
        String testValue = "abc";
        // when
        Throwable thrown = catchThrowable(() -> testValue.charAt(3));
        // then
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("range: 3");


    }
}
