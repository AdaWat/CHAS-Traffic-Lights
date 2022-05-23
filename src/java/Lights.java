import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class Lights extends JComponent {
    private int state = 1;      // there are 4 states: (red), (red & amber), (green), (amber)
    private float[] dist = {0.3f, 1.0f};

    @Override
    protected void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);   // make circles look smooth

        Rectangle2D.Double back = new Rectangle2D.Double(50, 50, 100, 260);
        GradientPaint grad1 = new GradientPaint(50, 50, new Color(10, 10, 10), 150, 50, new Color(60, 60, 60));
        g2d.setPaint(grad1);
        g2d.fill(back);

        Rectangle2D.Double pole = new Rectangle2D.Double(80, 310, 40, 90);
        GradientPaint grad2 = new GradientPaint(80, 310, new Color(50, 50, 50), 120, 310, new Color(150, 150, 150));
        g2d.setPaint(grad2);
        g2d.fill(pole);

        Ellipse2D.Double c1 = new Ellipse2D.Double(70, 70, 60, 60);
        Color[] c1cols = {new Color(255, 150, 150), Color.RED};
        if (state == 1 || state == 2) {
            RadialGradientPaint g1 = new RadialGradientPaint(new Point2D.Float(100, 100), 30, dist, c1cols);
            g2d.setPaint(g1);
        } else {
            g2d.setColor(Color.DARK_GRAY);
        }
        g2d.fill(c1);

        Ellipse2D.Double c2 = new Ellipse2D.Double(70, 150, 60, 60);
        Color[] c2cols = {new Color(255, 250, 120), Color.ORANGE};
        if (state == 2 || state == 4) {
            RadialGradientPaint g2 = new RadialGradientPaint(new Point2D.Float(100, 180), 30, dist, c2cols);
            g2d.setPaint(g2);
        } else {
            g2d.setColor(Color.DARK_GRAY);
        }
        g2d.fill(c2);

        Ellipse2D.Double c3 = new Ellipse2D.Double(70, 230, 60, 60);
        Color[] c3cols = {new Color(150, 255, 150), Color.GREEN};
        if (state == 3) {
            RadialGradientPaint g3 = new RadialGradientPaint(new Point2D.Float(100, 260), 30, dist, c3cols);
            g2d.setPaint(g3);
        } else {
            g2d.setColor(Color.DARK_GRAY);
        }

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
