import edu.fcps.Digit;
 public class inverse_four extends Digit implements Runnable
{
    
    public inverse_four(int x, int y)
   {
      super(x, y);
   }
    public void display()
   {
      segment1_Off();
      segment2_On();
      segment3_Off();
      segment4_Off();
      segment5_On();
      segment6_On();
      segment7_On();
   }
   public void run()
   {
      display();
   }
}