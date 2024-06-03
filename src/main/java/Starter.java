public class Starter {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(new BaseBallComputer(), new BaseBallPlayer(), new GameScoreCalculator());
        baseBallGame.play();
    }
}
