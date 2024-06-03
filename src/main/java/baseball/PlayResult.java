package baseball;

public class PlayResult {

    private static final int GAME_OVER_COUNT_STRIKE = 3;

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
}
