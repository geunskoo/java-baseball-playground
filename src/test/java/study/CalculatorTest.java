package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.Calculator;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("공백으로 구분된 사칙연산 혹은 숫자 이외의 값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = {
        "1 + a / 3",
        "+ 5 - 2",
        "3 3 + 4",
        "10 / / 2",
        "5 *"
    })
    void inputValues_ShouldThrowExceptionForInvalidInputs(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> calculator.run());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 2",
            "3 - 2 + 4",
            "10 / 2 * 5",
            "5 * 3 + 2 - 1"
    })
    @DisplayName("유효한 입력 값에 대해 예외가 발생하지 않는다.")
    void inputValues_ShouldNotThrowExceptionForValidInputs(String inputData) {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        calculator.run();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2=3",
            "3 - 2 + 4=5",
            "10 / 2 * 5=25",
            "5 * 3 + 2 - 1=16",
            "5 + 3 * 2 - 1=15"}, delimiter = '=')
    @DisplayName("계산기는 옳바른 계산 결과가 나와야한다.")
    void calculator_ShouldBeCorrect(String input, Double expected){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Double result = calculator.run();
        assertThat(result).isEqualTo(expected);
    }

}
