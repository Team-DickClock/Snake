import hevs.utils.Input;
import hevs.graphics.FunGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface {

    // Define a new type for direction
    public static enum direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NOCHANGE
    };

    FunGraphics windows;
    private direction nextDir = direction.NOCHANGE;

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

        FunGraphics windows = new FunGraphics(width, height);
        windows.setKeyManager(new KeyAdapter(){public void keyPressed(KeyEvent e) {
            
                if(e.getKeyCode()==Settings.Up)
                    nextDir=direction.UP;
                else if (e.getKeyCode()==Settings.Down)
                    nextDir=direction.DOWN;
                else if(e.getKeyCode()==Settings.Left)
                    nextDir=direction.LEFT;
                else if(e.getKeyCode()==Settings.Right)
                    nextDir=direction.RIGHT;
                else
                    nextDir=direction.NOCHANGE;
            }

        });
    }

    public direction getDirectionFunGraphics() {
        // Here is for the code for return the direction with the method on FunGraphic
        return direction.NOCHANGE;
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
}
