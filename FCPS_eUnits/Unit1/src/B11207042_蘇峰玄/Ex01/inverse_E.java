import edu.fcps.Digit;
 public class inverse_E extends Digit implements Runnable
{
    
    public inverse_E(int x, int y)
   {
      super(x, y);
   }
    public void display()
   {
      segment1_On();
      segment2_On();
      segment3_On();
      segment4_On();
      segment5_Off();
      segment6_Off();
      segment7_On();
   }
   public void run()
   {
      display();
   }
}