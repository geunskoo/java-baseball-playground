package study.calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    private final Pattern VALIDATE_INPUT_PATTERN = Pattern.compile("(\\d+ [-+*/] \\d+)( [-+*/] \\d+)*");

    public Double run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String cmd = scanner.nextLine();

            if (!isValidateInput(cmd)) {
                throw new IllegalArgumentException("계산기에 잘못된 값이 입력되었습니다.");
            }

            return calculate(cmd);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("예상치 못한 오류가 발생했습니다.");
        }
    }

    private double calculate(String cmd){
        String[] values = cmd.split(" ");

        double result = Double.parseDouble(values[0]);
        for (int i=1; i < values.length-1; i+=2){
            switch (values[i]) {
                case "+":
                    result += Double.parseDouble(values[i + 1]);
                    break;
                case "-":
                    result -= Double.parseDouble(values[i + 1]);
                    break;
                case "*":
                    result *= Double.parseDouble(values[i + 1]);
                    break;
                case "/":
                    result /= Double.parseDouble(values[i + 1]);
                    break;
            }
        }
        return result;
    }

    private boolean isValidateInput(String cmd){
        return VALIDATE_INPUT_PATTERN.matcher(cmd).matches();
    }
}
