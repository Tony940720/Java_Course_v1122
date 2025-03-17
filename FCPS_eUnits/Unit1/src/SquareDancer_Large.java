
public class SquareDancer_Large extends Dancer
{
   public SquareDancer_Large(int x, int y, int dir, int beep)
   {
      super(x, y, dir, beep);
   }
   
  
   public void danceStep()
   {
      for(int i = 0; i < 4; i++)
      {
         move();
         move();
         move();
         move();
         turnLeft();
      }
   }
}
