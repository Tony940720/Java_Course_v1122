import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
 public class Carry extends Robot implements Runnable
{

    public Carry()
   {
      super(1, 1, Display.EAST, Display.INFINITY);
   }
      
   public void run()
   {
      int[] counter = new int[20];
      for(int i = 0;i < counter.length;i++)
      {
         while(nextToABeeper())
         {
            pickBeeper();
            counter[i]++;
         }
         if(i > 0){
            for(int j = 0;j < counter[i-1];j++)
            {
               putBeeper();
            }
         }
         move();
      }

      turnLeft();
      move();
      turnLeft();
      
      for(int i = 20;i > 0;i--)
      {
         while(nextToABeeper())
         {
            pickBeeper();
         }
         if(i < 19){
            for(int j = 0;j < counter[i-1];j++)
            {
               putBeeper();
            }
         }
         move();
      }

   }

      
}