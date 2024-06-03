package baseball;

import java.util.Scanner;

public class StartPoint {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(
                new Scanner(System.in),
                new BaseBallComputer(),
                new BaseBallPlayer()
        );
        baseBallGame.play();
    }
}
