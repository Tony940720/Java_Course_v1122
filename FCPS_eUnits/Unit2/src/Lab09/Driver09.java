package Lab09;
import edu.fcps.Turtle;
import java.awt.Color;
import javax.swing.*;
public class Driver09
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Lab09");
      frame.setSize(400,400);
      frame.setLocation(100,50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new TurtlePanel());
      frame.setVisible(true);
      Turtle.clear(Color.white);
         
   	TwisistyTurtle rotatetriangle = new TwisistyTurtle(1);
   	TwisistyTurtle rotate = new TwisistyTurtle(100.0, 250.0, 90.0, 2);
      TwisistyTurtle rotatesquare = new TwisistyTurtle(500, 350.0, 90, 3);

	   rotatetriangle.drawShape();
	   rotate.drawShape();
	   rotatesquare.drawShape();

   
   }
}