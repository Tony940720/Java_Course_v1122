import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class Knight extends Athlete {
    // 一個有四個參數的建構子
    public Knight()
   {
      super(1, 1, Display.EAST, Display.INFINITY);
   }


    public void turnLeft() {
        move();
    }

    public void turnRight() {
        move();
        move();
    }

    public void retreat() {
        turnLeft();
        turnLeft();
        turnLeft();
        turnLeft();
        turnLeft();
    }
}