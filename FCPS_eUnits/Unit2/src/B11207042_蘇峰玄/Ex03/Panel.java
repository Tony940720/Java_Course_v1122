import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Panel extends JPanel {
    private static final int FRAME = 400;
    private static final Color BACKGROUND = new Color(204, 204, 204);

    private int score;
    private BufferedImage myImage;
    private Graphics myBuffer;
    private Ball ball;
    private Polkadot pd;
    private Timer t;

    private boolean mouseDown = false;
    private int mouseX, mouseY;
    private double clickDistance = 0;   // 與畫面中心距離

    // ------------------------------------------------------------------
    public Panel() {
        myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
        myBuffer = myImage.getGraphics();
        myBuffer.setColor(BACKGROUND);
        myBuffer.setFont(new Font("serif", Font.PLAIN, 20));
        myBuffer.fillRect(0, 0, FRAME, FRAME);

        int xPos = (int) (Math.random() * (FRAME - 100) + 50);
        int yPos = (int) (Math.random() * (FRAME - 100) + 50);
        int xDot = (int) (Math.random() * (FRAME - 40) + 20);
        int yDot = (int) (Math.random() * (FRAME - 40) + 20);

        ball = new Ball(xPos, yPos, 10, Color.BLACK);
        pd = new Polkadot(xDot, yDot, 20, Color.RED);

        // 一個物件同時負責 MouseListener + MouseMotionListener
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        t = new Timer(5, new Listener());
        t.start();
    }

    // ------------------------------------------------------------------
    private class Mouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            mouseDown = true;                        // ★
            mouseX = e.getX();                       // ★
            mouseY = e.getY();                       // ★
            // ★ 計算與畫面中心 (FRAME/2, FRAME/2) 的距離
            clickDistance = distance(mouseX, mouseY, FRAME / 2.0, FRAME / 2.0);

            // 保留原本三種點擊功能 -------------------------------
            if (e.isMetaDown()) {                    // 右鍵
                ball.setX(mouseX);
                ball.setY(mouseY);
            } else if (e.isShiftDown()) {            // Shift
                ball.setdx(Math.random() * 12 - 6);
                ball.setdy(Math.random() * 12 - 6);
            } else {                                 // 左鍵
                pd.setX(mouseX);
                pd.setY(mouseY);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseDown = false;                       // ★ 放開滑鼠，恢復自走
        }

        @Override
        public void mouseDragged(MouseEvent e) {     // ★ 持續更新滑鼠座標
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    // ------------------------------------------------------------------
    public void paintComponent(Graphics g) {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

    // ------------------------------------------------------------------
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myBuffer.setColor(BACKGROUND);
            myBuffer.fillRect(0, 0, FRAME, FRAME);

            // ★ 若正在按住滑鼠，黑球跟隨滑鼠；否則照原邏輯自走
            if (mouseDown) {
                ball.setX(mouseX - ball.getRadius()); // 讓滑鼠座標落在球中心
                ball.setY(mouseY - ball.getRadius());
            } else {
                ball.move(FRAME, FRAME);
            }
            ball.draw(myBuffer);

            pd.draw(myBuffer);
            collide(ball, pd);

            // ----------- 分數 & 距離 文字 -------------------
            myBuffer.setColor(Color.BLUE);
            myBuffer.drawString("Score: " + score, 50, 50);
            

            repaint();
        }
    }

    // ------------------------------------------------------------------
    private void collide(Ball b, Polkadot pd) {
        double d = distance(b.getX(), b.getY(), pd.getX(), pd.getY());
        if (d <= (b.getRadius() + pd.getRadius())) {
            score++;
            pd.jump(FRAME, FRAME);
            pd.draw(myBuffer);
        }
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
