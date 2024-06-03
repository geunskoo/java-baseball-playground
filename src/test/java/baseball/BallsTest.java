package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    @DisplayName("정답볼 전체와 위치와 값 모두 일치하면 STRIKE 이다.")
    void Strike_ShouldEqualPositionAndBallNumber(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, new BallNumber(1));
        assertThat(answers.play(ball)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("정답볼 전체와 위치만 다르면 BALL 이다.")
    void Ball_ShouldOnlyEqualBallNumber(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(2, new BallNumber(3));
        assertThat(answers.play(ball)).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("정답볼 전체와 위치와 값 모두 다르면 NOTHING 이다.")
    void Nothing_ShouldNotEqualPositionAndBallNumber(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, new BallNumber(0));
        assertThat(answers.play(ball)).isEqualTo(BallStatus.NOTHING);
    }
}
