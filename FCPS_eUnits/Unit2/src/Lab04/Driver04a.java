package Lab04;
import javax.swing.JFrame;
import edu.fcps.Bucket;

public class Driver04a
{
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Buckets");
         frame.setSize(600,400);
         frame.setLocation(100,100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new BucketPanel());
         frame.setVisible(true);
         Bucket.setSpeed(5);
         Bucket.useTotal(true);
         Bucket five = new Bucket(5);
         Bucket three = new Bucket(3);
         
         three.fill(); //3(3)
         three.pourInto(five); //5(3) 3(0)
         three.fill(); // 5(3) 3(3)
         three.pourInto(five); //5(5) 3(1)
         five.spill(); //5(0) 3(1)
         five.fill(); //5(5) 3(1)
         three.spill(); //5(5) 3(0)
         five.pourInto(three); //5(2) 3(3)
         three.spill(); //5(2) 3(0)
         five.pourInto(three); //5(0) 3(2)
         five.fill(); //5(5) 3(2)
         five.pourInto(three); //5(4) 3(3)
         three.spill(); //5(4) 3(0)
         three.fill(); //5(5) 3(0)
         five.fill(); //5(5) 3(3)
      }

}