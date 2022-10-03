package baseball.common;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public static boolean isNumbericValidate(String inputValue) {
        return inputValue.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public static boolean isLengthValidate(String userInput, int length) {
        return userInput.length() == length;
    }

    public static boolean isDupsValidate(String userInput) {
        Set<Character> inputNumber = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            inputNumber.add(userInput.charAt(i));
        }
        return inputNumber.size() == 3;
    }
}
