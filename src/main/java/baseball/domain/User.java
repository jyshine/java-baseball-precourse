package baseball.domain;

import baseball.common.Message;
import java.util.HashSet;
import java.util.Set;

public class User {

    public boolean isReadInputValidate(String inputValue) throws IllegalArgumentException {
        if (!isLengthValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER.getMessage());
        }
        if (!isNumbericValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER.getMessage());
        }
        if (!isDupsValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_DUPLICATION.getMessage());
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
