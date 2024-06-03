import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame{

    private final BaseBallComputer baseBallComputer;
    private final BaseBallPlayer baseBallPlayer;
    private final GameScoreCalculator gameScoreCalculator;
    private final Scanner scanner;
    private BaseBallGameStatus gameStatus;

    public BaseBallGame(BaseBallComputer baseBallComputer, BaseBallPlayer baseBallPlayer, GameScoreCalculator gameScoreCalculator) {
        this.baseBallComputer = baseBallComputer;
        this.baseBallPlayer = baseBallPlayer;
        this.gameScoreCalculator = gameScoreCalculator;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (gameStatus != BaseBallGameStatus.TERMINATE){
            excute();
            continuePlayChecker();
        }
        scanner.close();
    }

    private void continuePlayChecker() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int flag = scanner.nextInt();
        gameStatus = BaseBallGameStatus.fromValue(flag);
    }

    private void excute(){
        gameStatus = BaseBallGameStatus.PLAY;
        List<Integer> computerNumberList = baseBallComputer.generateComputerNumberList();

        Scanner scanner = new Scanner(System.in);
        while (gameStatus != BaseBallGameStatus.END){
            List<Integer> playerNumberList = baseBallPlayer.requestNumber(scanner);
            GameScore gameScore = gameScoreCalculator.calculateScore(computerNumberList, playerNumberList);
            printScore(gameScore);
            gameStatus = gameScoreChecker(gameScore);
        }
    }

    private BaseBallGameStatus gameScoreChecker(GameScore gameScore) {
        if (gameScore.getStrike() == 3){
            return BaseBallGameStatus.END;
        }
        return BaseBallGameStatus.PLAY;
    }


    private void printScore(GameScore gameScore){
        int strike = gameScore.getStrike();
        int ball = gameScore.getBall();

        if (ball != 0){
            System.out.print(ball +  " 볼 ");
        }
        if (strike != 0){
            System.out.print(strike + " 스트라이크 ");
        }
        if (strike == 0 && ball == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }

}
