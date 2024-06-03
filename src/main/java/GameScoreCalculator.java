import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameScoreCalculator {

    public GameScore calculateScore(List<Integer> computerNumberList, List<Integer> playerNumberList) {

        List<Integer> differenceCheckList = new ArrayList<>();
        for (int i=0; i< computerNumberList.size(); i++){
            differenceCheckList.add(computerNumberList.get(i) - playerNumberList.get(i));
        }
        List<Integer> strikeCheckList = new ArrayList<>(computerNumberList);
        strikeCheckList.retainAll(playerNumberList);
        int strike = Collections.frequency(differenceCheckList, 0);
        int ball = strikeCheckList.size() - strike;

        return new GameScore(strike, ball);
    }
}
