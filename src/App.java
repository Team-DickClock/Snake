public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            Game snakeGame = new Game(10,20);
            while (snakeGame.isInProgress()) {
                Interface.drawOnTerminal(snakeGame.getBoard());
                snakeGame.play(Interface.getDirectionTerminal());
            }
            Interface.putScoreTerminal(snakeGame.getScore());
        }
    }
}