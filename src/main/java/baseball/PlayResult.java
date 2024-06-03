package baseball;

public class PlayResult {

    private static final int GAME_OVER_COUNT_STRIKE = 3;
    private static final int NO_PRINT_SCORE_STD = 0;

    private int strike;
    private int ball;

    public PlayResult(){
        this.strike = 0;
        this.ball = 0;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void report(BallStatus status) {
        if (status.isStrike()){
            strike += 1;
        }
        if (status.isBall()){
            ball += 1;
        }
    }

    public boolean isGameOver() {
        return strike == GAME_OVER_COUNT_STRIKE;
    }

    public void printResult() {
        if (ball != NO_PRINT_SCORE_STD){
            System.out.print(ball + " 볼 ");
        }
        if (strike != NO_PRINT_SCORE_STD){
            System.out.print(strike + " 스트라이크 ");
        }
        if (strike == NO_PRINT_SCORE_STD && ball == NO_PRINT_SCORE_STD){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
