package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("위치만 다르면 BALL 이다.")
    void Ball_ShouldOnlyEqualBallNumber(){
        Ball com = new Ball(1, new BallNumber(1));
        Ball user = new Ball(2, new BallNumber(1));
        assertThat(com.play(user)).isEqualTo(BallStatus.BALL);
    }


    @Test
    @DisplayName("위치와 값 모두 다르면 NOTHING 이다.")
    void Nothing_ShouldNotEqualPositionAndBallNumber(){
        Ball com = new Ball(1, new BallNumber(1));
        Ball user = new Ball(2, new BallNumber(2));
        assertThat(com.play(user)).isEqualTo(BallStatus.NOTHING);
    }
}
