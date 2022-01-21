import java.awt.Color;
import java.util.concurrent.TimeUnit;

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
            Game snakeGame = new Game(10,20);
            while (snakeGame.isInProgress()) {
                Interface.drawOnTerminal(snakeGame.getBoard());
                //snakeGame.play(Interface.getDirectionFunGraphics());
                snakeGame.play(Interface.getDirectionTerminal());
                snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Color.BLACK, Color.BLACK, Color.BLACK);;
                //snakeGame.play(Interface.nextDir);
                //snakeGame.play(Interface.getDirectionTerminal());

                /**
                 * Pour indice, voilà une façon propre selon moi de faire la direction avec FunGraphics:
                 * snakeGame.play(snakeGame.interfaceGame.getDirectionFunGraphics());
                 */
                TimeUnit.SECONDS.sleep(1);
            }
            Interface.putScoreTerminal(snakeGame.getScore());
    }
}