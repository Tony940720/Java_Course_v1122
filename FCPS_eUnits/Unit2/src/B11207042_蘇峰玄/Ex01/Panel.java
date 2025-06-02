package Ex01;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Panel extends JPanel {

    public void paintComponent(Graphics g) {
         Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // red
        g2.setColor(Color.RED);
        g2.fillRect(0, 0, 600, 400);
   
        // blue
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, 300, 200);
   
   
        // triangle
        g2.setColor(Color.WHITE);
   
        int midX = 150;
        int midY = 100;

       
        double h = 75;
        
        double halfAngleRad = Math.toRadians(15);

       
        double halfBase = h * Math.tan(halfAngleRad);
          
        int topX = midX;
        int topY = (int)(midY - h);

        
        int leftX = (int)(midX - halfBase);
        int rightX = (int)(midX + halfBase);
        int baseY = midY;

          
        Polygon triangle = new Polygon();
      triangle.addPoint(topX,  topY);
      triangle.addPoint(leftX, baseY);
      triangle.addPoint(rightX, baseY);
      
      g2.fillPolygon(triangle);
      
      double pivotX = midX;  // 底邊中點
      double pivotY = baseY;
      for (int i = 0; i < 12; i++) {
         g2.rotate(Math.toRadians(30), pivotX, pivotY);
         
         g2.fillPolygon(triangle);
      }
    
      g2.setColor(Color.BLUE);
       int radiusInner = 85/2; 
       g2.fillOval(midX - radiusInner, midY - radiusInner, 2 * radiusInner, 2 * radiusInner);
       g2.setColor(Color.WHITE);
       radiusInner = 75/2; 
       g2.fillOval(midX - radiusInner, midY - radiusInner, 2 * radiusInner, 2 * radiusInner);
    }
}