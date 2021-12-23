import hevs.graphics.FunGraphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Touches {
/**
 * This class demonstrate how to implement keyboard events
*  using the FunGraphics library.
 */

  int offset = 0;
  FunGraphics funGraphics;
  public Touches() {
    // Inits the graphic window
    funGraphics = new FunGraphics(640, 480);
    // Do something when a key has been pressed
    funGraphics.setKeyManager(new KeyAdapter() {
      // Will be called when a key has been pressed
      public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
          System.out.println("a pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
          offset++;
        }
      }
    });
    while(true)
    {
      funGraphics.clear();
      //draw our object
      funGraphics.drawRect(50+offset*2, 50+offset*2, 75, 75);
      //refresh the screen at 60 FPS
      funGraphics.syncGameLogic(60);
    }
  }
  public static void main(String[] args) {
    Touches d = new Touches();
  }
}

