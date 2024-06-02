import java.util.*;

public class BaseBallComputer {

    private static final int PLAY_BALL_NUMBER = 3;

    public List<Integer> generateComputerNumberList(){
        Set<Integer> computerNumberList = new HashSet<>();
        Random random = new Random();

        while (PLAY_BALL_NUMBER != computerNumberList.size()){
            computerNumberList.add(random.nextInt(10));
        }

        return new ArrayList<>(computerNumberList);
    }
}
