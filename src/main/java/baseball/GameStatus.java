package baseball;

import java.util.Arrays;

public enum GameStatus {
    START(1), END(0);

    private int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static GameStatus findByValue(int resumeFlag) {
        GameStatus gameStatus = Arrays.stream(values())
                .filter(s -> s.value == resumeFlag)
                .findFirst()
                .orElse(GameStatus.END);
        return gameStatus;
    }

    public boolean isContinueGame() {
        return this != GameStatus.END;
    }
}
