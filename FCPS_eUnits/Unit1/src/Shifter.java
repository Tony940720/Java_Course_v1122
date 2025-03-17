	//Name______________________________ Date_____________
   import edu.fcps.karel2.Display;
   import edu.fcps.karel2.Robot;
   public class Shifter extends Robot implements Runnable, Workable
   {
      private int myBeepers;
      public Shifter(int y)
      {
         super(1, y, Display.EAST, 0);
      
      }
      
   	public void workCorner()
      {
         if(nextToABeeper())
         {
            pickBeeper();
         }
      }
      public void moveOneBlock()
      {
         move();
      }
      public void turnToTheRight()
      {
         turnLeft();
         turnLeft();
         turnLeft();
      }
      public void turnToTheNorth()
      {
         while(!facingNorth())
         {
            turnLeft();
         }
      }
      public void run()
      {
         int[] counter = new int[10];
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
      
      }
 
   }