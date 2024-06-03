package baseball;

import java.util.Scanner;

public class BaseBallGame {

    private final Scanner scanner;
    private final BaseBallComputer baseBallComputer;
    private final BaseBallPlayer baseBallPlayer;
    private GameStatus gameStatus;

    public BaseBallGame(Scanner scanner, BaseBallComputer baseBallComputer, BaseBallPlayer baseBallPlayer) {
        this.scanner = scanner;
        this.baseBallComputer = baseBallComputer;
        this.baseBallPlayer = baseBallPlayer;
        this.gameStatus = GameStatus.START;
    }

    public void play(){

        while (gameStatus.isContinueGame()){
            excute();
            gameStatus = baseBallPlayer.requestGameStatus(scanner);
        }
        scanner.close();
    }

    private void excute(){
        Balls computerBalls = new Balls(baseBallComputer.generate3RandomValues());
        PlayResult playResult = new PlayResult();

        while(!playResult.isGameOver()) {
            Balls userBalls = new Balls(baseBallPlayer.request3Values(scanner));
            playResult = computerBalls.play(userBalls);
            playResult.printResult();
        }
        gameOverMessage();
    }

    private void gameOverMessage() {
        System.out.println("게임 종료");
    }

}
