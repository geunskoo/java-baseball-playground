package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int MAX_BALL_COUNT = 3;
    private List<Ball> balls;

    public Balls(List<Integer> balls) {
        mapBalls(balls);
    }

    public PlayResult play(Balls balls) {
        PlayResult playResult = new PlayResult();
        for (Ball ball : this.balls){
            BallStatus status = balls.play(ball);
            playResult.report(status);
        }
                
        return playResult;
    }

    public BallStatus play(Ball ball) {
        return this.balls.stream()
                .map(b -> b.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private void mapBalls(List<Integer> balls) {
        this.balls = new ArrayList<>();
        for (int i = 0; i < MAX_BALL_COUNT; i++) {
            this.balls.add(new Ball(i+1, new BallNumber(balls.get(i))));
        }
    }
}
