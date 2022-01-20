import hevs.utils.Input;
import hevs.graphics.FunGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface {

    // Define a new type for direction
/*     public static enum direction {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        NOCHANGE
    }; */

    FunGraphics windows;
     static int nextDir = 'D';
     static int previousDir = 'D';
     static int up = 'W';
     static int down = 'S';
     static int right = 'D';
     static int left = 'A';

    /**
     * Ask for next direction on terminal and get this one.
     * 
     * @return The direction (type direction on this class)
     */
    public static int getDirectionTerminal() {
        System.out.println("Entrez la prochaine direction:"); // Ask on terminal for next direction
        char dir = Input.readChar(); // get a char for choose the direction

        // choose the direction with the input key char
        switch (dir) {
            case 'w':
                // if w is pressed, send direction UP
                //return direction.UP;
                return up;
            case 'd':
                // if d is pressed, send direction RIGHT
                //return direction.RIGHT;
                return right;
            case 's':
                // if s is pressed, send direction DOWN
                //return direction.DOWN;
                return down;
            case 'a':
                // if a is pressed, send direction LEFT
                //return direction.LEFT;
                return left;

            default:
                //return direction.NOCHANGE;
                return up;

        }
    }

    public Interface(int height, int width) {

        FunGraphics windows = new FunGraphics(width, height);
        windows.setKeyManager(new KeyAdapter(){public void keyPressed(KeyEvent e) {
            
                if(e.getKeyCode()==Settings.Up)
                    nextDir=up;
                else if (e.getKeyCode()==Settings.Down)
                    nextDir=down;
                else if(e.getKeyCode()==Settings.Left)
                    nextDir=left;
                else if(e.getKeyCode()==Settings.Right)
                    nextDir=right;
            }

        });

    }

    public static int getDirectionFunGraphics() {
        // Here is for the code for return the direction with the method on FunGraphic
        if(nextDir == up){
            return up;
        }
        if(nextDir == down){
            System.out.println("YOUPI JA?I GAGNE ------------------------------------------------------------------------- ");
            return down;
            
        }
        if(nextDir == left){
            return left;
        }
        if(nextDir == right){
            return right;
        }

        //return direction.NOCHANGE; 
        return nextDir;
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
