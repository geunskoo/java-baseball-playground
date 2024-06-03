import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseBallPlayer {

    public List<Integer> requestNumber(Scanner scanner){
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = scanner.nextLine();
        return Arrays.stream(inputValue.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }
}
