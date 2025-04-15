package Lab04;
import javax.swing.JFrame;
import edu.fcps.Bucket;

public class Driver04b
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
         Bucket four = new Bucket(4);
         Bucket three = new Bucket(3);
         
         five.fill(); //5(5) 4(0) 3(0)
         five.pourInto(four); //5(1) 4(4) 3(0)
         four.spill(); // 5(1) 4(0) 3(0)
         five.pourInto(three); //5(0) 4(0) 3(1)
         four.fill(); //5(0) 4(4) 3(1)
         five.fill(); //5(5) 4(4) 3(1)
         three.spill(); //5(5) 4(4) 3(0)
         four.spill(); //5(5) 4(0) 3(0)
         five.pourInto(three); //5(2) 4(0) 3(3)
         three.spill(); //5(2) 4(0) 3(0)
         five.pourInto(three); //5(0) 4(0) 3(2)
         five.fill(); //5(5) 4(0) 3(2)
         four.fill(); //5(5) 4(4) 3(2)
         three.fill(); //5(5) 4(4) 3(3)
         three.spill(); //5(5) 4(4) 3(0)
         four.pourInto(three); //5(5) 4(1) 3(3)
         four.spill(); //5(5) 4(0) 3(3)
         five.spill();//5(0) 4(0) 3(3)
         five.fill();//5(5) 4(0) 3(3)
         three.spill(); //5(5) 4(0) 3(0)
         five.pourInto(three); //5(2) 4(0) 3(3)
         three.spill(); //5(2) 4(0) 3(0)
         four.fill(); //5(2) 4(4) 3(0)
         five.spill(); //5(0) 4(0) 3(0)         
      }

}