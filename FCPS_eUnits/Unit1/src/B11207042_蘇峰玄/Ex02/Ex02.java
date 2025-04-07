
import edu.fcps.karel2.Display;

public class Ex02
{
    public static void main(String[] args) 
   {
      
      Display.openWorld("C:/Users/tony9/Dropbox/PC/Documents/GitHub/Java_Course_v1122/FCPS_eUnits/Unit1/maps/Ex02.map");
      Display.setSize(20, 20);
      Display.setSpeed(10);

      Thread t1 = new Thread( new Carry() );
      Thread t2 = new Thread( new Dancer() );
      t1.start();
      t2.start();
    }
}