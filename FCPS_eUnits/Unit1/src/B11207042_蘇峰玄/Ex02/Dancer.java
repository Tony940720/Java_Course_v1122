import edu.fcps.karel2.Robot;
import edu.fcps.karel2.Display;
 public class Dancer extends Robot implements Runnable
{
    public Dancer()
   {
      super(8, 8, Display.EAST, 0);
   }
   
   
   public void run()
   {
      for(int i = 0; i < 4; i++)
      {
         move();
         move();
         move();
         move();
         turnLeft();
         turnLeft();
         turnLeft();
      }
   }

}
