import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {

    private BaseBallComputer baseBallComputer;
    private GameScoreCalculator gameScoreCalculator;

    @BeforeEach
    public void setUp(){
        this.baseBallComputer = new BaseBallComputer();
        this.gameScoreCalculator = new GameScoreCalculator();
    }

    @Test
    @DisplayName("컴퓨터는 서로 다른 0과 9사이 3개의 랜덤 숫자를 생성해야한다.")
    public void baseBallComputer_ShouldGenerateThreeRandomNumber(){
        List<Integer> numberList = baseBallComputer.generateComputerNumberList();
        Set<Integer> distinctNumberList = new HashSet<>(numberList);
        assertThat(distinctNumberList.size()).isEqualTo(3);
        distinctNumberList.forEach(randNum -> assertThat(randNum).isBetween(0,9));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "123:123:3:0",
            "123:124:2:0",
            "123:145:1:0",
            "123:312:0:3",
            "123:214:0:2",
            "123:345:0:1",
            "123:132:1:2"
    }, delimiter = ':')
    @DisplayName("BaseBallGame은 스코어를 올바르게 계산하고, 3스트라이크 시 종료, 그 외의 경우 계속 진행된다.")
    public void gameScoreCalculator_ShouldCalculateScoreCorrect(String computer, String player, int expectedStrike, int expectedBall){
        List<Integer> computerNumberList = Arrays.stream(computer.split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerNumberList = Arrays.stream(player.split("")).map(Integer::parseInt).collect(Collectors.toList());
        GameScore gameScore = gameScoreCalculator.calculateScore(computerNumberList, playerNumberList);

        assertThat(gameScore.getStrike()).isEqualTo(expectedStrike);
        assertThat(gameScore.getBall()).isEqualTo(expectedBall);
    }

}
