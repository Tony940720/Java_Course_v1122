  	//Torbert, e-mail: smtorbert@fcps.edu
	//version 4.16.2003

   import edu.fcps.karel2.Robot;
   import edu.fcps.karel2.Display;
   import javax.swing.JOptionPane;

    public class Lab09
   {
       public static void main(String[] args) 
      {
         String filename = JOptionPane.showInputDialog("What robot world?");
         Display.openWorld("../maps/"+filename+".map");
         Display.setSize(10, 10);
         Display.setSpeed(10);
         
         
         Athlete Lisa = new Athlete(1, 1, Display.EAST, 0);
         
         int[] counter = new int[10];
         for(int i = 0;i < counter.length;i++)
         {
            while(Lisa.nextToABeeper())
            {
               Lisa.pickBeeper();
               counter[i]++;
            }
            if(i > 0){
               for(int j = 0;j < counter[i-1];j++)
               {
                  Lisa.putBeeper();
               }
            }
            Lisa.move();
         }
      }
   }