package Lab09;
import edu.fcps.Turtle;
import java.awt.Color;
public class TwisistyTurtle extends Turtle
{
   private double mySize;
   private Color myColor;
   private int myMode;
   public TwisistyTurtle(int mode)
   {
      super();
      myMode = mode;
      mySize = 30;
   }
   public TwisistyTurtle(double x, double y, double heading, int mode)
   {
      super(x, y, heading);
      myMode = mode;
      mySize = 30;
   }
   public void setSize(double n)
   {
      mySize = n;
   }
   
   private void rotatetriangle() //starts and ends at center facing north
   {    
      for(int i = 5; i <= 400; i+=10)
      {
         forward(i);
         turnLeft(123);
      }
   }
   
   private void rotate() //starts at top of stem facing south, ends at bottom
   {
      for(int i = 0; i <= 150; i+=2)
      {
         forward(i);
         turnLeft(30);
      }   }
   
   private void rotatesquare() //starts at top of stem facing south, ends at bottom
   {
      super.setColor(Color.red);
      for(int i = 25; i <= 150; i+=5)
      {
         forward(i);
         turnLeft(45);
         forward(i);
         turnLeft(90);
         forward(i);
         turnLeft(90);
         forward(i);
         turnLeft(90);
      }   
   }
   
   public void drawShape()
   {
      switch(myMode)
      {
         case 1:
            super.setColor(Color.orange);
            rotatetriangle();
            break;
         case 2:
            super.setColor(Color.black);
            rotate();
            break;
         case 3:
            super.setColor(Color.orange);
            rotatesquare();
            break;
         default:
            break;
      }
   }
}