import java.awt.Color;

/**
 * Just a class for keep all settings in same place
 */
public class Settings {

    // Values for listener of keys
    public static int up = 'W';
    public static int down = 'S';
    public static int right = 'D';
    public static int left = 'A';
    public static int space = ' ';
    public static int parameter = 'P';

    // Color for drawing different parts of snake and the background
    public static Color head = Color.BLACK;
    public static Color snake = Color.BLACK;
    public static Color apple = Color.RED;
    public static Color font = Color.BLACK;
    public static Color background = Color.WHITE;


    public static int level = 150; // hard is 50, medium is 100, easy is 150

}
