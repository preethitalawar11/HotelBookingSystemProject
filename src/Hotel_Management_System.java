// package package1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Hotel_Management_System extends JFrame implements ActionListener{

    JButton next;

    Hotel_Management_System() {

        setTitle("Home");
        setLayout(null);
        setLocationRelativeTo(null);

        // **********************************************************

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1280, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-325,-160,1929,1110);
        add(image);

        // ************************************************************* JLabel

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setFont(new Font("serif",Font.BOLD,55));
        text.setForeground(Color.WHITE);
        // text.setFont(new Font("serif",Font.BOLD,40));
        // text.setBounds(370,820,700,50);
        text.setBounds(520,550,900,50);
        image.add(text);

        // ************************************************************* JButton

        next = new JButton("Next");
        next.setFocusable(false);
        next.setBounds(1400,820,120,40);
        next.setBorder(BorderFactory.createEtchedBorder());
        next.setFont(new Font("serif",Font.BOLD,20));
        // next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        image.add(next);

        // **********************************************************

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(600);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(600);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            setVisible(false);
            new loginH().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Hotel_Management_System();
    }
}
