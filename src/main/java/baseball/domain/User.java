package baseball.domain;

import baseball.common.Message;
import baseball.common.Validation;

public class User {

    public boolean isReadInputValidate(String inputValue) throws IllegalArgumentException {
        if (!Validation.isLengthValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER.getMessage());
        }
        if (!Validation.isNumbericValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER.getMessage());
        }
        if (!Validation.isDupsValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_DUPLICATION.getMessage());
        }
        return true;
    }

    public Integer[] convertReadInputToIntegerArray(String readInput) {
        Integer[] inputNumbers = new Integer[readInput.length()];

        for(int i=0; i< readInput.length(); i++){
            inputNumbers[i] = Character.getNumericValue(readInput.charAt(i));
        }
        return inputNumbers;
    }
}
