import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
 
public class BouncingBall extends JPanel {
 

  private int width;
  private int height;
 
  private float radius = 30; 
  private float diameter = radius * 2;
 
  private float X = radius + 50;
  private float Y = radius + 20;
 
  private float dx = 1;
  private float dy = 1;
 
  public BouncingBall() {
 
    Thread thread = new Thread() {
        public void run() {
            while (true) {
            
                //jelenlegi képernyőméret lekérdezése
                width = getWidth();
                height = getHeight();
                
                X = X + dx ;
                Y = Y + dy;
                
                //Ha az X tengely nem éri el a képernyő jobb szélét, lépjünk lefelé egyet, ellenkező esetben fordítsuk meg az irányt
                if (X - radius < 0) {
                    dx = -dx; 
                    X = radius; 
                } else if (X + radius > width) {
                    dx = -dx;
                    X = width - radius;
                }
                
                //Ha az Y tengely nem éri el a képernyő alját, lépjünk lefelé egyet, ellenkező esetben fordítsuk meg az irányt.
                if (Y - radius < 0) {
                    dy = -dy;
                    Y = radius;
                } else if (Y + radius > height) {
                    dy = -dy;
                    Y = height - radius;
                }
                repaint();
                
                //sleep() segítségével állíthatjuk be a sebességet
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }
    
            }
        }
    };
    thread.start();
  }
 
    //  labda tulajdonságainak megadása. Jelen esetben kerek forma, zöld színnel.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
    }
  // A feladatban szereplő alapértelmezett teljes képernyőméret megadása a frame.setExtendedState(JFrame.MAXIMIZED_BOTH) 
  // segítségével történik. 
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pattogó labda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setContentPane(new BouncingBall());
        frame.setVisible(true);
    }
}