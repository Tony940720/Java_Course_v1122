   import edu.fcps.Digit;
    public class Night extends Digit
   {
       
       public Night(int x, int y)
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
         segment6_On();
         segment7_On();
      }
      
   }