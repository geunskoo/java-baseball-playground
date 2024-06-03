package baseball;

import java.util.Objects;

public class BallNumber {

    private final int MIN_NO = 1;
    private final int MAX_NO = 9;

    private int no;

    public BallNumber(int no) {
        this.no = no;
    }

    public boolean isValidate() {
        return this.no >= MIN_NO && this.no <= MAX_NO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return MIN_NO == that.MIN_NO && MAX_NO == that.MAX_NO && no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_NO, MAX_NO, no);
    }
}
