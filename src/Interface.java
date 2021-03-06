import hevs.utils.Input;
import hevs.graphics.FunGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Interface {

    // Define a new type for direction
    public static enum direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NOCHANGE
    };

    public final static int SNAKESIZE = 10; // size of a square of snake in pixel
    private static int windowWidth; // Width of the window in pixel
    private static int windowHeight; // Height of the window in pixel
    public static direction nextDir = direction.NOCHANGE; // Define nextDirection

    public FunGraphics window; // Define a window for FunGraphics
    public boolean startGame = false; 
    public boolean goSettings = false;

    /**
     * Create an interface (window) with specific height and width
     * Add listener for keys
     * @param height height of the game board
     * @param width width of game board
     */
    public Interface(int height, int width) {
            windowWidth = width*SNAKESIZE;
            windowHeight = height*SNAKESIZE;

        window = new FunGraphics(windowHeight, windowWidth);
        window.setKeyManager(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Settings.up) {
                    nextDir = direction.UP;
                }
                if (e.getKeyCode() == Settings.down) {
                    nextDir = direction.DOWN;
                }
                if (e.getKeyCode() == Settings.left) {
                    nextDir = direction.LEFT;
                }
                if (e.getKeyCode() == Settings.right) {
                    nextDir = direction.RIGHT;
                }
                if (e.getKeyCode() == Settings.space){
                    startGame = true;
                }
                if (e.getKeyCode() == Settings.parameter){
                    goSettings = true;
                }
                
            }
        });
    }

    
    /**
     * Ask for next direction on terminal and get this one.
     * @return The direction (type direction on this class)
     */
    public static direction getDirectionTerminal() {
        System.out.println("Entrez la prochaine direction:"); // Ask on terminal for next direction
        char dir = Input.readChar(); // get a char for choose the direction

        // choose the direction with the input key char
        switch (dir) {
            case 'w':
                // if w is pressed, send direction UP
                return direction.UP;
            case 'd':
                // if d is pressed, send direction RIGHT
                return direction.RIGHT;
            case 's':
                // if s is pressed, send direction DOWN
                return direction.DOWN;
            case 'a':
                // if a is pressed, send direction LEFT
                return direction.LEFT;

            default:
                return direction.NOCHANGE;

        }
    }

    /**
     * Put the score on terminal (should be used at the end of the game)
     * @param score The score to be put on terminal
     */
    public static void putScoreTerminal(int score) {
        System.out.println("Your score is: " + score);
    }

    /**
     * Draw the board of the game on terminal
     * @param board the current board to be drawing
     */
    public static void drawOnTerminal(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Draw the board with some color settings for the different part of the snake
     * @param board the initial board
     * @param head Color for the head of snake
     * @param snake Color for the body of the snake
     * @param apple Color for the apple
     */
    public void drawOnFG(int[][] board, Color head, Color snake, Color apple) {

        //Clear the window
        window.clear();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {

                //Draw apple
                if (board[y][x] == Fruit.VALUEFORAPPLE) {
                    window.setColor(apple);
                    window.drawFillRect(x * SNAKESIZE, y * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }

                // Draw body of snake
                if (board[y][x] > 1) {
                    window.setColor(snake);
                    window.drawFillRect(x * SNAKESIZE, y * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }

                // Draw head of snake
                if (board[y][x] == 1) {
                    window.setColor(head);
                    window.drawFillRect(x * SNAKESIZE, y * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }
            }
        }
    }

    /**
     * Put the score with FunGraphics (should be used at the end of the game)
     * @param score The score to be put
     */
    public void putScoreOnFG(int score){
        window.clear();
        window.drawString(20, 40, "Your score is: " + score, Settings.font, 20);
    }

    /**
     * Draw the start menu with FunGraphics
     */
    public void DrawStartMenuFG() {
        window.clear();
        int size = 20;

        String start = "START: Press \"space\"";
        window.drawString(20, 20+size, start, Settings.font, size);
        
        //String settings = "SETTINGS: press \"p\"";
        //window.drawString(20, 20+3*size, settings, Settings.font, size);
    }
    
    public void DrawSettingsMenuFG() {
        window.clear();
        // code for setting menu
    }
}