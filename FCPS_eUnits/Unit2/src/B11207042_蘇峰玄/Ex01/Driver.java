package Ex01;
import javax.swing.*;
public class Driver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Ex01");
      frame.setSize(600,400);
      frame.setLocation(100,50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel());
      frame.setVisible(true);
   }
}