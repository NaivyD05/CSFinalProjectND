import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel(){


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(250,250,20,20);

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
        //avoids infinite recursion
        repaint();
    }
}
