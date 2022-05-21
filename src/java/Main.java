import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        int w = 210;
        int h = 400;

        JFrame frame = new JFrame("Traffic Lights");
        Lights lights = new Lights();

        ActionListener lightChanger = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    lights.change();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer(100, lightChanger);
        timer.setRepeats(true);
        timer.start();

        frame.add(lights);
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}
