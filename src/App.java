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
        Game snakeGame = new Game(10, 20);
        Interface interf = new Interface(640,480);
        /* while (true) {
            while (snakeGame.isInProgress()) {
                Interface winGame = new Interface(640, 480);
                Interface.drawOnTerminal(snakeGame.getBoard());
                // snakeGame.play(Interface.getDirectionFunGraphics());
                snakeGame.play(Interface.nextDir);
                
                  Pour indice, voilà une façon propre selon moi de faire la direction avec
                  FunGraphics:
                  snakeGame.play(snakeGame.interfaceGame.getDirectionFunGraphics());
                 
                for (double i = 0.0; i < 10000000000.0; i++) {

                }
            }
            Interface.putScoreTerminal(snakeGame.getScore()); */
        }
    }
