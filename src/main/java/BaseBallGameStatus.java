import java.util.Arrays;

public enum BaseBallGameStatus {
    PLAY(1), TERMINATE(2), END(3);

    private final int value;

    BaseBallGameStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BaseBallGameStatus fromValue(int value) {
        return Arrays.stream(values())
                .filter(b -> b.getValue() == value)
                .findFirst()
                .get();
    }
}