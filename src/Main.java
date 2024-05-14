import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        JPanel panel = new JPanel();

        int t = 0;


        frame.getContentPane();
        panel.setLayout(null);


        //background color
        Color color = new Color(136,180,80);
        panel.setBackground(color);


        JLabel label = new JLabel("<html><font color='white'>Find the cow!</font></html>");
        label.setFont(new Font("SansSerif",Font.BOLD,18));
        label.setBounds(161,10,150,50);


        JLabel cLoc = new JLabel("Cow location");
        cLoc.setBounds(40,40,150,50);

        JLabel mLoc = new JLabel("Mouse location");
        mLoc.setBounds(40,60,150,50);



        ImageIcon cow = new ImageIcon("Images/cow.png");
        cow.setImage(cow.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        JLabel picLabel = new JLabel(cow);
        picLabel.setBounds(200,400,50,50);

        ImageIcon grass = new ImageIcon("Images/grass.png");
        grass.setImage(grass.getImage().getScaledInstance(60,50, Image.SCALE_DEFAULT));
        JLabel grassL = new JLabel(grass);
        grassL.setBounds(100,300,60,50);


        ImageIcon g2 = new ImageIcon("Images/g2.png");
        grass.setImage(g2.getImage().getScaledInstance(60,50, Image.SCALE_DEFAULT));
        JLabel g2L = new JLabel(g2);
        grassL.setBounds(400,100,60,50);

        JButton button = new JButton("Start");
        button.setBounds(210,70,40,15);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int)(Math.random()*500);
                int y = (int)(Math.random()*500);
                cLoc.setText(x+" ,"+y);
                picLabel.setBounds(x,y,60,50);
                picLabel.setVisible(false);
                button.setVisible(false);
            }
        });


        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {

                int xM = e.getX();
                int yM = e.getY();
                int x = picLabel.getX();
                int y = picLabel.getY();
                mLoc.setText(xM + ", " +yM);
                if((xM>(x-100) && xM<(x+100)) && (yM>(y-100) && yM<(y+100))) {
                    Toolkit.getDefaultToolkit().beep();
                }
                if((xM>x && xM<(x+50)) && (yM>y && yM<(y+40))){

                    picLabel.setVisible(true);
                    button.setVisible(true);
                }


            }

        });






        panel.add(button);
        panel.add(label);
        panel.add(picLabel);
        panel.add(grassL);
        panel.add(g2L);
        panel.add(mLoc);
        panel.add(cLoc);


        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setVisible(true);

    }
}