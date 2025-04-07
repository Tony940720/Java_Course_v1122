
import edu.fcps.karel2.Display;

public class Ex03
{
    public static void main(String[] args) 
   {
      
      Display.openWorld("C:/Users/tony9/Dropbox/PC/Documents/GitHub/Java_Course_v1122/FCPS_eUnits/Unit1/maps/Ex03.map");
      Display.setSize(10, 10);
      Display.setSpeed(10);

      Athlete Lisa = new Athlete(8, 1, Display.WEST, Display.INFINITY);
      for(int i = 0; i < 10; i++)
      {
         goStraight(Lisa, 0);
         if(i < 9)
         {
            if(i % 2 == 0)
               LeftUp(Lisa);
            else if(i % 2 == 1)
               RightUp(Lisa);
         }
      }
      
      Lisa.turnAround();
      
      for(int i = 0; i < 10; i++)
      {
         goStraight(Lisa, 1);
         if(i < 9)
         {
            if(i % 2 == 0)
               LeftDown(Lisa);
            else if(i % 2 == 1)
               RightDown(Lisa);
         }
      }

    }
    
   public static void goStraight(Athlete arg, int k)	
   { 
      while(arg.frontIsClear())
      {
         if(k == 0)
            arg.putBeeper();
         else 
            arg.pickBeeper();
         arg.move();
      }
      if(k == 0)
         arg.putBeeper();
       else 
            arg.pickBeeper();
   }

   public static void LeftUp(Athlete arg)	
   { 
      arg.turnAround();
      while(!arg.leftIsClear())
      {
         arg.move();
      }
      arg.turnLeft();
      arg.move();
      arg.turnLeft();
      while(arg.frontIsClear())
      {
         arg.move();
      }
      arg.turnAround();
   }
   
   public static void RightUp(Athlete arg)	
   { 
      arg.turnAround();
      while(!arg.rightIsClear())
         arg.move();
      arg.turnRight();
      arg.move();
      arg.turnRight();
      while(arg.frontIsClear())
         arg.move();
      arg.turnAround();
   }
   
   public static void RightDown(Athlete arg)	
   { 
      arg.turnAround();
      while(!arg.leftIsClear())
      {
         arg.move();
      }
      arg.turnLeft();
      arg.move();
      arg.turnLeft();
      while(arg.frontIsClear())
      {
         arg.move();
      }
      arg.turnAround();
   }
   
   public static void LeftDown(Athlete arg)	
   { 
      arg.turnAround();
      while(!arg.rightIsClear())
         arg.move();
      arg.turnRight();
      arg.move();
      arg.turnRight();
      while(arg.frontIsClear())
         arg.move();
      arg.turnAround();
   }



}