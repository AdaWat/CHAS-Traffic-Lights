import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class Lights extends JComponent {
    private int state = 1;      // there are 4 states: (red), (red & amber), (green), (amber)

    @Override
    protected void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D.Double back = new Rectangle2D.Double(50, 50, 100, 260);
        g2d.setColor(new Color(10, 10, 10));
        g2d.fill(back);

        Rectangle2D.Double pole = new Rectangle2D.Double(80, 310, 40, 90);
        g2d.setColor(new Color(150, 150, 150));
        g2d.fill(pole);

        Ellipse2D.Double c1 = new Ellipse2D.Double(70, 70, 60, 60);
        if (state == 1 || state == 2) {g2d.setColor(Color.RED);} else {g2d.setColor(Color.DARK_GRAY);}
        g2d.fill(c1);

        Ellipse2D.Double c2 = new Ellipse2D.Double(70, 150, 60, 60);
        if (state == 2 || state == 4) {g2d.setColor(Color.ORANGE);} else {g2d.setColor(Color.DARK_GRAY);}
        g2d.fill(c2);

        Ellipse2D.Double c3 = new Ellipse2D.Double(70, 230, 60, 60);
        if (state == 3) {g2d.setColor(Color.GREEN);} else {g2d.setColor(Color.DARK_GRAY);}
        g2d.fill(c3);
    }

    public void change() throws InterruptedException {
        if (state < 4) {
            state++;
        } else {
            state = 1;
        }

        if (state % 2 == 0) {
            Thread.sleep(10000);    // stay on red or green for 10s
        } else {
            Thread.sleep(4000);     // stay on amber for 4s
        }

        repaint();
    }
}
