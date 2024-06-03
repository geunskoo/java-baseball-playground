package baseball;

public class Ball {

    private int position;
    private BallNumber ballNumber;

    public Ball(int position, BallNumber ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if (ballNumber.equals(ball.ballNumber) && position != ball.position){
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }


}
