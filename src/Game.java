public class Game {
    final int NUMBEROFFRUIT = 1;
    private boolean inProgress;
    private int[][] board;
    private Snake snake;

    /**
     * Create a game with a specific size of board
     * It include the snake at the beginning
     * @param height height of the board
     * @param width width of the board
     */
    public Game(int height, int width){
        // define the game is on progress
        this.inProgress = true;

        // create a board for the game
        this.board = new int[height][width];

        // Initialization the board with only 0
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[0].length; x++) {
                this.board[y][x] = 0;
            }
        }

        // create and place the snake in the board
        this.snake = new Snake(3, height/2, 3, board);
        this.board = this.snake.placeSnake(board);

    }

    public boolean isInProgress(){
        return this.inProgress;
    }

    public void play(Interface.direction dir){
        
        //
        int headX = snake.getHead(board)[0];
        int headY = snake.getHead(board)[1];

        switch (dir) {
            case UP:
                headY--;
                break;
            case LEFT:
                headX--;
                break;
            case DOWN:
                headY++;
                break;
            case RIGHT:
                headX++;
                break;
            default:
                break;
        }

        if(headY < board.length && headX < board[0].length && headX*headY >= 0){
            if(board[headY][headX]>0){
                this.inProgress = false;
            } else {
                if (Fruit.isFruit(board[headY][headX])) {
                    snake.growUp(Fruit.eatFruit(board[headY][headX]));
                }
                
                board = snake.placeSnake(board, returnPositionXY(headX, headY));
    
                // Create a Fruit if not enough fruit(s) exist
                if (Fruit.getNumberOfFruit() < NUMBEROFFRUIT) {
                    board = Fruit.createFruit(board);
                }
            }
        } else {
            this.inProgress = false;
        }

        if(!this.inProgress){
            Fruit.reset();
        }
    }

    public int getScore(){
        return snake.getScore();
    }

    public int[][] getBoard(){
        return board;
    }

    /**
     * Get position of a value in current board
     * @param board the current board of game
     * @param val value to be tested
     * @return the position of the value [0] is X and [1] is Y. 
     * return null if the value isn't found
     */
    public static int[] positionInBoard(int[][] board, int val){
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if(board[y][x] == val){
                    return returnPositionXY(x, y);
                }
            }
        }
        return null;
    }

    /**
     * returns positionXY in the form in[2] with the integers X and Y as parameters
     * @param posX integer for position in X
     * @param posY integer for position in Y
     * @return the position of the value [0] is X and [1] is Y. 
     */
    public static int[] returnPositionXY(int posX, int posY) {
        int[] positionXY = new int[2];
        positionXY[0] = posX;
        positionXY[1] = posY;
        return positionXY;
    }
}
