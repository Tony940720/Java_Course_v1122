import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;


public class Lab00 {


	public static void main(String[] args) {
		

		Display.openWorld("../maps/maze9.map");
      Display.setSize(10,10);
      Display.setSpeed(5);
      
		Robot karel = new Knight();
      Knight lan= (Knight) karel;
      lan.retreat();
         //karel.turnRight();
     	}

}
