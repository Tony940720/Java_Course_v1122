package Lab13;
import javax.swing.*;
public class Driver13
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lab13");
      frame.setSize(700,500);
      frame.setLocation(0,0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ProjectPanel());
      frame.setVisible(true);
   }
}