import hevs.utils.Input;
import hevs.graphics.FunGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private static int windowsizeWidth;
    private static int windowsizeHeight;
    public  int stateOfGraphic = 0;

    FunGraphics windows;
    public static direction nextDir = direction.RIGHT;

    public Interface(int height, int width) {
            windowsizeWidth = width*SNAKESIZE;
            windowsizeHeight = height*SNAKESIZE;

        windows = new FunGraphics(windowsizeHeight, windowsizeWidth);
        windows.setKeyManager(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == Settings.Up) {
                    nextDir = direction.UP;
                } else if (e.getKeyCode() == Settings.Down) {
                    nextDir = direction.DOWN;

                } else if (e.getKeyCode() == Settings.Left) {
                    nextDir = direction.LEFT;
                    // windows.drawFillRect(50, 50, 5, 5);
                } else if (e.getKeyCode() == Settings.Right) {
                    nextDir = direction.RIGHT;

                } else {
                    nextDir = direction.NOCHANGE;

                }
            else if(e.getKeyCode()==Settings.Left)
                {nextDir=direction.LEFT;
                //windows.drawFillRect(50, 50, 5, 5);
                }
            else if(e.getKeyCode()==Settings.Right)
                {nextDir=direction.RIGHT;
                //windows.drawFillRect(150, 50, 5, 5);
                }
            else
                {nextDir=direction.NOCHANGE;
                   
                }
        }});

        windows.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
              super.mouseClicked(e);
              MouseEvent event = e;
              int posx = event.getX();
              int posy = event.getY();
              System.out.println(posx);
              System.out.println(posy);
              if (stateOfGraphic==0){
              if (posx> windowsizeWidth/3 && posx<windowsizeWidth/3+ 0.75*20*5 && posy>windowsizeHeight/2-20*1.2 && posy<windowsizeHeight/2)
              {
                System.out.println("START");
                stateOfGraphic=1;

              }
              else if (posx>windowsizeWidth/3 && posx<windowsizeWidth/3+ 0.75*20*8 && posy>windowsizeHeight-10 - 20*1.2 && posy<windowsizeHeight - 10 ) 
              {
                  System.out.println("SETTINGS");
                  stateOfGraphic=2;
              }
              }
            if (stateOfGraphic==2)
            {
                if(posx > windowsizeWidth/3 && posx<windowsizeWidth/3 + 0.75*20*4 && posy>10 && posy<10+20*1.2)
                System.out.println("SETTINGS key up");            
            }
            }});

        
        /* Game snakeGame = new Game(height, width);
        while(true){
            
            snakeGame.play(Interface.nextDir);
            Interface.drawOnTerminal(snakeGame.getBoard());
        }  */

    }

    
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
     * 
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
    public void DrawStartMenuFG() {

        windows.clear();
        String start = "START";
        String settings = "SETTINGS";
        windows.drawString(windowsizeWidth/3, windowsizeHeight/2, start, Settings.font, 20);
        windows.drawString(windowsizeWidth/3, windowsizeHeight-10,  settings, Settings.font, 20);

       
            }
    
    public void DrawSettingsMenuFG() {

                windows.clear();
                String keyup = "Up : " + (char)Settings.Up ;
                windows.drawString(windowsizeWidth/3, 10, keyup, Settings.font, 20);
        
               
                    }
        }
 