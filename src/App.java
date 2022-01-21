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
    
            Game snakeGame = new Game(30,30);
            snakeGame.interfaceGame.DrawStartMenuFG() ;

            while (snakeGame.isInProgress()) {
                //Interface.drawOnTerminal(snakeGame.getBoard());
                //snakeGame.play(Interface.getDirectionFunGraphics());
                //snakeGame.play(Interface.getDirectionTerminal());
                snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Settings.head, Settings.snake, Settings.apple);;
                snakeGame.play(Interface.nextDir);
                //snakeGame.play(Interface.getDirectionTerminal());

                TimeUnit.MILLISECONDS.sleep(Settings.level);
            }
            Interface.putScoreTerminal(snakeGame.getScore());
    
        //Interface inter = new Interface(640, 480);

    }
}
