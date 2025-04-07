import edu.fcps.Digit;
 public class inverse_S extends Digit implements Runnable
{
    
    public inverse_S(int x, int y)
   {
      super(x, y);
   }
    public void display()
   {
      segment1_On();
      segment2_On();
      segment3_Off();
      segment4_On();
      segment5_On();
      segment6_Off();
      segment7_On();
   }
   public void run()
   {
      display();
   }
}