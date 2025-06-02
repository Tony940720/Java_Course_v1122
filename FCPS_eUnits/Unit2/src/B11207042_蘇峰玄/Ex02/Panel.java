import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
 public class Panel extends JPanel implements KeyListener 
{
   private static final int WIDTH = 395, HEIGHT = 391; //constants
   private static final Color BACKGROUND = new Color(204, 204, 204);

   private int xPos, yPos, dir; //fields
   private ImageIcon[] myArray;
   private BufferedImage myImage;
   private Graphics myBuffer;
    public Panel()
   {
      myImage =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myArray = new ImageIcon[4];
      myArray[0] = new ImageIcon("karele.gif");   //east
      myArray[1] = new ImageIcon("kareln.gif");   //north
      myArray[2] = new ImageIcon("karelw.gif");   //west
      myArray[3] = new ImageIcon("karels.gif");   //south
      dir = 0;     //start facing east
      xPos = 4;    //starting xPos
      yPos = HEIGHT - 4 - myArray[dir].getImage().getHeight(null); //starting yPos
      Timer t = new Timer(1, new Listener());
      t.start();
      
      setFocusable(true);
      requestFocusInWindow();
      addKeyListener(this);
   }
    public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
    private class Listener implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
      {
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, WIDTH, HEIGHT);
         myBuffer.setColor(Color.red);
         for(int x = 17; x < WIDTH; x += 30) //vertical lines
         {
            myBuffer.drawLine(x, 0, x, 391);
         }
         for(int y = 9; y < HEIGHT; y += 30) //horizontal lines
         {
            myBuffer.drawLine(0, y, 395, y);
         }

         myBuffer.drawImage(myArray[dir].getImage(), xPos, yPos, null);
         
         repaint();
      }
   }
   
   @Override
    public void keyPressed(KeyEvent e) {
        int step = 30;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                dir = 2; // west
                if (xPos - step >= 4)
                    xPos -= step;
                else System.out.println("Warning: Left boundary reached");
                break;
            case KeyEvent.VK_RIGHT:
                dir = 0; // east
                if (xPos + step <= 390)
                    xPos += step;
                else System.out.println("Warning: Right boundary reached");
                break;
            case KeyEvent.VK_UP:
                dir = 1; // north
                if (yPos - step >= -5)
                    yPos -= step;
                else System.out.println("Warning: Upper limit reached");
                break;
            case KeyEvent.VK_DOWN:
                dir = 3; // south
                if (yPos + step <= 380)
                    yPos += step;
                else System.out.println("Warning: Lower boundary reached");
                break;
            case KeyEvent.VK_SPACE:
                dir = 0; // north
                xPos = 5;    //starting xPos
                yPos = HEIGHT - 3 - myArray[dir].getImage().getHeight(null);
                System.out.println("Reset to start");
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}