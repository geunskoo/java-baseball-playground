package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallNumberTest {

    @Test
    @DisplayName("BallNumber는 1과 9사이 숫자이다.")
    void BallNumber_ShouldBe1To9(){
        assertThat(new BallNumber(1).isValidate()).isTrue();
        assertThat(new BallNumber(9).isValidate()).isTrue();
        assertThat(new BallNumber(0).isValidate()).isFalse();
        assertThat(new BallNumber(10).isValidate()).isFalse();
    }
}
