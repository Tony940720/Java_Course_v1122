   import edu.fcps.karel2.Robot;
   import edu.fcps.karel2.Display;
   import javax.swing.JOptionPane;

    public class Lab10
   {
       public static void main(String[] args) 
      {
         String filename = JOptionPane.showInputDialog("What robot world?");
         Display.openWorld("../maps/"+filename+".map");
         Display.setSize(10, 10);
         Display.setSpeed(10);
         
         
         Athlete Lisa = new Athlete(1, 1, Display.NORTH, Display.INFINITY);
         
         while(!Lisa.nextToABeeper())
         {
            
            while(Lisa.rightIsClear())
            {
               Lisa.turnRight();
               if(!Lisa.nextToABeeper())
                  Lisa.move();
            }
            if(!Lisa.frontIsClear())
            {
               Lisa.turnLeft();
               
            }
            else if(!Lisa.nextToABeeper())
               Lisa.move();
         }
      }
   }