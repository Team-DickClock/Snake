import java.util.concurrent.TimeUnit;
/**
 * Class for start game.
 * Manage and connect the different classes for make a real game.
 * @date 21/01/22
 * @version 1.0.1
 * @author Arnaud Ducrey, Julien Chevalley, Rémi Heredero
 * @arnauducrey
 * @JuliuChe
 * @Klagarge
 */
public class App {
    public static void main(String[] args) throws Exception {

        Game snakeGame = new Game(30,40); // Define a new game
        
        while (true) {

            // Draw the start menu
            snakeGame.interfaceGame.DrawStartMenuFG();
            while (!snakeGame.interfaceGame.startGame && !snakeGame.interfaceGame.goSettings) {
                TimeUnit.SECONDS.sleep(1);
            }

            if (snakeGame.interfaceGame.startGame) {
                snakeGame.interfaceGame.startGame = false;
                snakeGame.Initialization();
                while (snakeGame.isInProgress()) {
                
                // Drawing the game with FunGraphics or on terminal
                    snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Settings.head, Settings.snake, Settings.apple);
                    //Interface.drawOnTerminal(snakeGame.getBoard());
    
                // Play one round with FunGraphic or terminal inputs
                    snakeGame.play(Interface.nextDir);
                    //snakeGame.play(Interface.getDirectionTerminal());
    
                    TimeUnit.MILLISECONDS.sleep(Settings.level);
                }
                snakeGame.interfaceGame.putScoreOnFG(snakeGame.getScore());
                Interface.putScoreTerminal(snakeGame.getScore());
                TimeUnit.SECONDS.sleep(3);
            }

            if(snakeGame.interfaceGame.goSettings){
                // Place for code for settings management page
            }
        }
    }
}
