import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import hevs.graphics.FunGraphics;

public class MouseDemo {

  FunGraphics fg = new FunGraphics(300, 300);

  MouseDemo(){

    fg.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        MouseEvent event = e;
        int posx = event.getX();
        int posy = event.getY();
        fg.drawFilledCircle(posx, posy, 5);
      }
    });
  }
  
  public static void main(String[] args) {
    new MouseDemo();
  }
}