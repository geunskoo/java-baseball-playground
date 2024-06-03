package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {

    @Test
    @DisplayName("3 Strike 이면 게임이 종료된다.")
    public void Strike3_ShouldBeGameOver(){
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = answers.play(userBalls);

        assertThat(playResult.isGameOver()).isTrue();
    }
}
