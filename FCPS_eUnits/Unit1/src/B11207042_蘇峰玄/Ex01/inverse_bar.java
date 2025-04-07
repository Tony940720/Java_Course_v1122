import edu.fcps.Digit;
 public class inverse_bar extends Digit implements Runnable
{
    
   public inverse_bar(int x, int y)
   {
      super(x, y);
   }
   public void display()
   {
      segment1_Off();
      segment2_Off();
      segment3_Off();
      segment4_Off();
      segment5_Off();
      segment6_Off();
      segment7_On();
   }
   public void run()
   {
      display();
   }

   
}