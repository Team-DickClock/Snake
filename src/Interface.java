import hevs.utils.Input;

public class Interface {
    public static enum direction {UP, RIGHT, DOWN, LEFT};

    /**
     * Ask for next direction on terminal and get this one.
     * @return The direction (type direction on this class)
     */
    public static direction getDirectionTerminal(){
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
                return null;
        }
    }

    public static direction getDirectionFunGraphics() {
        // Here is for the code with key detect with the method on FunGraphic
        return null;
    }

    public static void putScoreTerminal(int score){
        System.out.println("Your score is: " + score);
    }

    public static void drawOnTerminal(int[][] board){
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println("");
        }
    }
}
