package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GameResultTest {

    @Test
    @DisplayName("게임 결과 집계는 3볼을 올바르게 가지고 있어야한다.")
    void GameResult_ShouldContain3Ball(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(3, 1, 2));

        GameResult gameResult = answers.calculateScore(userBalls);
        Assertions.assertThat(gameResult.getBall()).isEqualTo(3);
        Assertions.assertThat(gameResult.getStrike()).isEqualTo(0);
    }
}
