package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlayResultTest {

    @Test
    @DisplayName("게임 결과 집계는 3스트라이크를 올바르게 가지고 있어야한다.")
    void GameResult_ShouldContain3Strike(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        PlayResult playResult = answers.play(userBalls);
        Assertions.assertThat(playResult.getBall()).isEqualTo(0);
        Assertions.assertThat(playResult.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 결과 집계는 2볼 1스트라이크를 올바르게 가지고 있어야한다.")
    void GameResult_ShouldContain2Ball1Strike(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(2, 1, 3));

        PlayResult playResult = answers.play(userBalls);
        Assertions.assertThat(playResult.getBall()).isEqualTo(2);
        Assertions.assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 결과 집계는 3볼을 올바르게 가지고 있어야한다.")
    void GameResult_ShouldContain3Ball(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(3, 1, 2));

        PlayResult playResult = answers.play(userBalls);
        Assertions.assertThat(playResult.getBall()).isEqualTo(3);
        Assertions.assertThat(playResult.getStrike()).isEqualTo(0);
    }
}