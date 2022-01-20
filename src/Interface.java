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

    public final static int SNAKESIZE = 10;

    FunGraphics windows;
    static direction nextDir = direction.RIGHT;

    /**
     * Ask for next direction on terminal and get this one.
     * 
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

    public Interface(int height, int width) {

        windows = new FunGraphics(width*SNAKESIZE, height*SNAKESIZE);
        windows.setKeyManager(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == Settings.Up)
                    nextDir = direction.UP;
                else if (e.getKeyCode() == Settings.Down)
                    nextDir = direction.DOWN;
                else if (e.getKeyCode() == Settings.Left)
                    nextDir = direction.LEFT;
                else if (e.getKeyCode() == Settings.Right)
                    nextDir = direction.RIGHT;
                else
                    nextDir = direction.NOCHANGE;
            }

        });

    }

    public static direction getDirectionFunGraphics() {
        // Here is for the code for return the direction with the method on FunGraphic
        if (nextDir == direction.UP) {
            return direction.UP;
        }
        if (nextDir == direction.DOWN) {
            System.out.println(
                    "YOUPI JA?I GAGNE ------------------------------------------------------------------------- ");
            return direction.DOWN;

        }
        if (nextDir == direction.LEFT) {
            return direction.LEFT;
        }
        if (nextDir == direction.RIGHT) {
            return direction.RIGHT;
        }

        return direction.NOCHANGE;
        // return nextDir;
    }

    /**
     * Put the score on terminal (should be used at the end of the game)
     * 
     * @param score The score to be put on terminal
     */
    public static void putScoreTerminal(int score) {
        System.out.println("Your score is: " + score);
    }

    /**
     * Draw the board of the game on terminal
     * 
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
     * Draw the board with some color settings for the differents part of the sanke 
     * @param board
     * @param head
     * @param snake
     * @param apple
     */
    public void drawOnFG(int[][] board, Color head, Color snake, Color apple) {
        windows.clear();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == Fruit.VALUEFORAPPLE) {
                    windows.setColor(apple);
                    windows.drawFillRect(j * SNAKESIZE, i * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }
                if (board[i][j] > 0) {
                    windows.setColor(snake);
                    windows.drawFillRect(j * SNAKESIZE, i * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }
                if (board[i][j] == 1) {
                    windows.setColor(head);
                    windows.drawFillRect(j * SNAKESIZE, i * SNAKESIZE, SNAKESIZE, SNAKESIZE);
                }
            }
        }
    }
}
