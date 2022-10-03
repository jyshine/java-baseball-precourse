package baseball.game;

import baseball.common.BallStatus;
import baseball.common.Message;
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

    public void initGame(){
        this.computer = new Computer();
        this.user = new User();
        this.computerNumbers = computer.createRandomNumber();
        System.out.println(Arrays.toString(computerNumbers));
    }

    public void play() {
        initGame();

        while(true) {
            System.out.print(Message.GAME_INPUT.getMessage());

            String readInput = Console.readLine();

            if (user.isReadInputValidate(readInput)) {
                userNumbers = user.convertReadInputToIntegerArray(readInput);
            }
            referee = new Referee(computerNumbers, userNumbers);

            HashMap<BallStatus, Integer> gameScore = referee.getGameScore();
            System.out.println(referee.convertGameScoreMessage(gameScore));

            if (gameScore.getOrDefault(BallStatus.STRIKE,0) == 3){
                System.out.println(Message.GAME_COMPLETE.getMessage());

                System.out.println(Message.GAME_END.getMessage());
                String retryGame = Console.readLine();


                if (retryGame.equals("1")){
                    initGame();
                }

                if (retryGame.equals("2")){
                    System.out.println(Message.GAME_OVER.getMessage());
                    break;
                }
            }


        }


    }

}
