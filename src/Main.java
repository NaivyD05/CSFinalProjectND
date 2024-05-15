import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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




        frame.getContentPane();
        panel.setLayout(null);




        //background color
        Color color = new Color(136,180,80);
        panel.setBackground(color);




        JLabel label = new JLabel("<html><font color='white'>Where's cow!</font></html>");
        label.setFont(new Font("SansSerif",Font.BOLD,18));
        label.setBounds(161,10,150,50);




        JLabel cLoc = new JLabel("Cow location");
        cLoc.setBounds(18,30,150,50);
        cLoc.setVisible(false);




        JLabel mLoc = new JLabel("Mouse location");
        mLoc.setBounds(18,50,150,50);
        mLoc.setVisible(false);






        ImageIcon cow = new ImageIcon("Images/cow.png");
        cow.setImage(cow.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        JLabel picLabel = new JLabel(cow);
        picLabel.setBounds(200,120,50,50);


        ImageIcon grass = new ImageIcon("Images/grass.png");
        grass.setImage(grass.getImage().getScaledInstance(60,50, Image.SCALE_DEFAULT));
        JLabel grassL = new JLabel(grass);
        grassL.setBounds(280,380,60,50);


        JLabel g = new JLabel(grass);
        g.setBounds(74,200,60,50);


        JLabel g2 = new JLabel(grass);
        g2.setBounds(350,190,60,50);


        JLabel g3 = new JLabel(grass);
        g3.setBounds(70,400,60,50);




        JButton button = new JButton("Start");
        button.setBounds(210,70,40,15);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int)(Math.random()*501);
                int y = (int)(Math.random()*400+90);
                cLoc.setText("Cow: "+x+" ,"+y);
                picLabel.setBounds(x,y,60,50);
                picLabel.setVisible(false);
                button.setVisible(false);
            }
        });


        JButton hint = new JButton("¯\\_(ツ)_/¯");
        hint.setBounds(18,25,70,17);
        hint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cLoc.setVisible(true);
                mLoc.setVisible(true);


            }
        });




        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {


                int xM = e.getX();
                int yM = e.getY();
                int x = picLabel.getX();
                int y = picLabel.getY();
                mLoc.setText("You: "+xM + ", " +yM);


                if((xM>x-100 && xM<(x+100)) && (yM>y-100 && yM<(y+40))){
                  //  Toolkit.getDefaultToolkit().beep();
                    try{
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("cow-moo1.wav"));

                        Clip moo = AudioSystem.getClip();
                        moo.open(audioInputStream);
                        moo.start();
                        System.out.println("try worked");
                        //Thread.sleep(moo.getMicrosecondLength()/100);

//                        moo.close();
//                        audioInputStream.close();
                    } catch (Exception i){
                        i.printStackTrace();
                    }






                }




                if((xM>=x && xM<=(x+50)) && (yM>=y && yM<=(y+50))){
                    picLabel.setVisible(true);
                    button.setVisible(true);
                    mLoc.setVisible(false);
                    cLoc.setVisible(false);
                }




            }


        });










        panel.add(button);
        panel.add(hint);
        panel.add(label);
        panel.add(picLabel);
        panel.add(grassL);
        panel.add(g);
        panel.add(g2);
        panel.add(g3);
        panel.add(mLoc);
        panel.add(cLoc);




        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        frame.add(panel);
        frame.setVisible(true);






    }
}

