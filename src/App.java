import java.awt.Color;

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
            Game snakeGame = new Game(50,50);
            while (snakeGame.isInProgress()) {
                Interface.drawOnTerminal(snakeGame.getBoard());
                snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Color.BLACK, Color.BLACK, Color.BLACK);;
                //snakeGame.play(Interface.nextDir);
                snakeGame.play(Interface.getDirectionTerminal());

                /**
                 * Pour indice, voilà une façon propre selon moi de faire la direction avec FunGraphics:
                 * snakeGame.play(snakeGame.interfaceGame.getDirectionFunGraphics());
                 */
            }
            Interface.putScoreTerminal(snakeGame.getScore());
    }
}