package baseball.common;

public enum Message {

    GAME_INPUT("숫자를 입력해 주세요. :"),
    GAME_COMPLETE("3개의 숫자를 모두 맞히셨습니다.! 게임종료"),
    GAME_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요."),
    GAME_OVER("게임 종료"),
    VALIDATION_NUMBER("3자리 숫자만 입력 가능합니다."),
    VALIDATION_DUPLICATION("중복된 숫자는 입력할 수 없습니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
