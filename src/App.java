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

        Game snakeGame = new Game(30, 30);
        while (snakeGame.isInProgress()) {
            // Affichage du jeu sur la fenetre graphique
            snakeGame.interfaceGame.drawOnFG(snakeGame.getBoard(), Color.BLACK, Color.BLACK, Color.BLACK);
            // lecture des touches du clavier
            snakeGame.play(Interface.nextDir);
            // Gestion de la vitesse de döplacement du serpent
            TimeUnit.MILLISECONDS.sleep(Settings.level);
        }
    }
}
