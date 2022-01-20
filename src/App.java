/**
 * Class for start game.
 * Manage and connect the different classes for make a real game.
 * 
 * @author Arnaud Ducrey, Julien Chevalley, Rémi Heredero
 * @arnauducrey
 * @JuliuChe
 * @Klagarge
 */
public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            Game snakeGame = new Game(10,20);
            while (snakeGame.isInProgress()) {
                Interface.drawOnTerminal(snakeGame.getBoard());
                snakeGame.play(Interface.getDirectionTerminal());
                /**
                 * Pour indice, voilà une façon propre selon moi de faire la direction avec FunGraphics:
                 * snakeGame.play(snakeGame.interfaceGame.getDirectionFunGraphics());
                 */
            }
            Interface.putScoreTerminal(snakeGame.getScore());
        }
    }
}