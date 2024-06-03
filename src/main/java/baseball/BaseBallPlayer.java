package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseBallPlayer {
    public List<Integer> request3Values(Scanner scanner) {
        playerInputGuideMessage();
        String s = scanner.nextLine();
        return Arrays.stream(s.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void playerInputGuideMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public GameStatus requestGameStatus(Scanner scanner) {
        playerGameResumeMessage();
        String resumeFlag = scanner.nextLine();
        return GameStatus.findByValue(Integer.parseInt(resumeFlag));
    }

    private void playerGameResumeMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
