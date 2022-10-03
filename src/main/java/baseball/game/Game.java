package baseball.game;

import baseball.common.BallStatus;
import baseball.common.Message;
import baseball.common.Validation;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;

public class Game {
    Computer computer = null;
    User user = null;
    Referee referee;
    Integer[] userNumbers = null;
    Integer[] computerNumbers = null;

    public void initGame() {
        this.computer = new Computer();
        this.user = new User();
        this.computerNumbers = computer.createRandomNumber();
        System.out.println(Arrays.toString(computerNumbers));
    }

    public void play() {
        initGame();
        do {
            System.out.print(Message.GAME_INPUT.getMessage());
            userInput();
        } while (!checkGameStatus(getRefereeResult()));
    }

    private HashMap<BallStatus, Integer> getRefereeResult() {
        referee = new Referee(this.computerNumbers, this.userNumbers);
        HashMap<BallStatus, Integer> gameScore = referee.getGameScore();
        referee.getGameScoreMessage(gameScore);
        return gameScore;
    }

    private void userInput() {
        String readInput = Console.readLine();
        validReadInput(readInput);
    }

    private void validReadInput(String readInput) {
        if (user.isReadInputValidate(readInput)) {
            this.userNumbers = user.convertReadInputToIntegerArray(readInput);
        }
    }

    private boolean checkGameStatus(HashMap<BallStatus, Integer> gameScore) {
        if (gameScore.getOrDefault(BallStatus.STRIKE, 0) == 3) {
            System.out.println(Message.GAME_COMPLETE.getMessage());
            return isGameRetry();
        }
        return false;
    }

    private boolean isGameRetry() {
        System.out.println(Message.GAME_END.getMessage());
        String retryGame = Console.readLine();
        isGameRetryValid(retryGame);
        if (retryGame.equals("1")) {
            initGame();
        }
        if (retryGame.equals("2")) {
            System.out.println(Message.GAME_OVER.getMessage());
            return true;
        }
        return false;
    }

    private void isGameRetryValid(String inputValue) throws IllegalArgumentException {
        if (!Validation.isLengthValidate(inputValue, 1)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER_ONE.getMessage());
        }
        if (!Validation.isNumbericValidate(inputValue)) {
            throw new IllegalArgumentException(Message.VALIDATION_NUMBER_ONE.getMessage());
        }
    }

}
