import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class BaseBallGameTest {

    private BaseBallComputer baseBallComputer = new BaseBallComputer();

    @Test
    @DisplayName("컴퓨터는 서로 다른 0과 9사이 3개의 랜덤 숫자를 생성해야한다.")
    public void baseBallComputer_ShouldGenerateThreeRandomNumber(){
        List<Integer> numberList = baseBallComputer.generateComputerNumberList();
        Set<Integer> distinctNumberList = new HashSet<>(numberList);
        assertThat(distinctNumberList.size()).isEqualTo(3);
        distinctNumberList.forEach(randNum -> assertThat(randNum).isBetween(0,9));
    }
}
