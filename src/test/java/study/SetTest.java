package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항1
    @Test
    @DisplayName("집합 크기 확인")
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항2
    @Test
    @DisplayName("집합 요소 확인1")
    void setElementsTest(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("집합 요소 확인1 개선")
    @ValueSource(ints = {1, 2, 3})
    void setElementsTest2(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    // 요구사항3
    @ParameterizedTest
    @DisplayName("집합 요소 확인2")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setElementsTest3(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
