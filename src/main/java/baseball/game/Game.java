package baseball.game;

import baseball.domain.Computer;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public String readInput() {
        return Console.readLine();
    }
    public void play() {
        Computer computer = new Computer();
        User user = new User();
        Integer[] computerNumbers = computer.createRandomNumber();
        System.out.println("숫자를 입력해 주세요.");
        String readInput = readInput();

        boolean readInputValidate = user.isReadInputValidate(readInput);
        if (readInputValidate) {
            Integer[] userNumbers = user.convertReadInputToIntegerArray(readInput);
        }




    }
}
