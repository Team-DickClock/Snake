import java.util.concurrent.TimeUnit;

/**
 * Class for start game.
 * Manage and connect the different classes for make a real game.
 * @author Arnaud Ducrey, Julien Chevalley, Rémi Heredero
 * @arnauducrey
 * @JuliuChe
 * @Klagarge
 */
public class App {
    public static void main(String[] args) throws Exception {
    
            Game snakeGame = new Game(30,30);
        while(true){
            if ( snakeGame.interfaceGame.stateOfGraphic==0) {
                snakeGame.interfaceGame.DrawStartMenuFG() ;
            }
            System.out.println("Ce que je veux" + snakeGame.interfaceGame.stateOfGraphic);
            if ( snakeGame.interfaceGame.stateOfGraphic==2) {
                snakeGame.interfaceGame.DrawSettingsMenuFG() ;
            }
        }
            /* while (snakeGame.isInProgress() ) {
                //Interface.drawOnTerminal(snakeGame.getBoard());
                //snakeGame.play(Interface.getDirectionFunGraphics());
                //snakeGame.play(Interface.getDirectionTerminal());
                if ( snakeGame.interfaceGame.stateOfGraphic==1){
                snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Settings.head, Settings.snake, Settings.apple);;
                snakeGame.play(Interface.nextDir);
                }
                //snakeGame.play(Interface.getDirectionTerminal());

                TimeUnit.MILLISECONDS.sleep(Settings.level);

            } */
            //snakeGame.interfaceGame.stateOfGraphic = 0;
        

            //Interface.putScoreTerminal(snakeGame.getScore()); 
    
        //Interface inter = new Interface(640, 480);
/*
        Game snakeGame = new Game(30, 30);
        while (snakeGame.isInProgress()) {
            // Affichage du jeu sur la fenêtre graphique
            snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Color.BLACK, Color.BLACK, Color.BLACK);
            // lecture des touches du clavier
            snakeGame.play(Interface.nextDir);
            // Gestion de la vitesse de déplacement du serpent
            TimeUnit.MILLISECONDS.sleep(Settings.level);
        }
*/
    }
}
