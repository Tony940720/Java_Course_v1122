import edu.fcps.karel2.Display;

public class Pirate extends Athlete
{
    public Pirate()
   {
      super(1, 1, Display.EAST, 0);
   }
    public void approachPile()
   {
      while(!nextToABeeper())
         move();
   }
   public int numOfBeepersInPile()
   {
      int nums = 0;
      while(nextToABeeper())
      {
         pickBeeper();
         nums++;
      }
      return nums;
   }
    public void turnAppropriately(int beepers)
   {
      if(beepers == 1)
         turnLeft();
      else if(beepers == 2)
         turnAround();
      else if(beepers == 3)
         turnRight();
   }
}      