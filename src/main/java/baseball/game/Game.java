package baseball.game;

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
            System.out.println("숫자를 입력해 주세요.");

            String readInput = Console.readLine();

            if (user.isReadInputValidate(readInput)) {
                userNumbers = user.convertReadInputToIntegerArray(readInput);
            }
            referee = new Referee(computerNumbers, userNumbers);

            HashMap<String, Integer> gameScore = referee.getGameScore();
            System.out.println(referee.convertGameScoreMessage(gameScore));

            if (gameScore.getOrDefault("strike",0) == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
                String retryGame = Console.readLine();


                if (retryGame.equals("1")){
                    initGame();
                }

                if (retryGame.equals("2")){
                    break;
                }
            }


        }


    }

}
