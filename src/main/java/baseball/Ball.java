package baseball;

import java.util.Objects;

public class Ball {

    private int position;
    private BallNumber ballNumber;

    public Ball(int position, BallNumber ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if (ball.equals(this)){
            return BallStatus.STRIKE;
        }
        if (ball.equalBallNumber(this)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean equalBallNumber(Ball ball) {
        return this.ballNumber.equals(ball.ballNumber);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
