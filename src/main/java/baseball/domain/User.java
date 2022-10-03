package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

    public boolean isReadInputValidate(String inputValue) throws IllegalArgumentException {
        if (!isLengthValidate(inputValue)) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
        if (!isNumbericValidate(inputValue)) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
        if (!isDupsValidate(inputValue)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
        return true;
    }

    public boolean isNumbericValidate(String inputValue) {
        return inputValue.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean isLengthValidate(String userInput) {
        return userInput.length() == 3;
    }

    public boolean isDupsValidate(String userInput) {
        Set<Character> inputNumber = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            inputNumber.add(userInput.charAt(i));
        }
        return inputNumber.size() == 3;
    }

    public Integer[] convertReadInputToIntegerArray(String readInput) {
        Integer[] inputNumbers = new Integer[readInput.length()];

        for(int i=0; i< readInput.length(); i++){
            inputNumbers[i] = Character.getNumericValue(readInput.charAt(i));
        }
        return inputNumbers;
    }
}
