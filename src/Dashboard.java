// package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu hotel, admin;
    JMenuItem reception, emp, room, driver;

    Dashboard() {

        setTitle("Dashboard");
        setLayout(null);
        setLocationRelativeTo(null);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(-200, -160, 1929, 1105);
        add(image);

        // ***************************************************** JLabel

        JLabel text = new JLabel("The TAJ Group Welcomes You");
        text.setBounds(700, 250, 800, 50);
        text.setFont(new Font("serif", Font.BOLD, 40));
        text.setForeground(Color.WHITE);
        image.add(text);

        // ***************************************************** JMenuBar & JMenu

        mb = new JMenuBar();
        mb.setBounds(200, 162, 1650, 30);
        image.add(mb);

        hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setBorder(BorderFactory.createEtchedBorder());
        hotel.setFont(new Font("DIALOG_INPUT", Font.BOLD, 12));
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        admin = new JMenu("ADMIN");
        admin.setBorder(BorderFactory.createEtchedBorder());
        admin.setFont(new Font("DIALOG_INPUT", Font.BOLD, 12));
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        // ***************************************************** JMenuItem

        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        emp = new JMenuItem("ADD EMPLOYEE");
        emp.addActionListener(this);
        admin.add(emp);
        
        room = new JMenuItem("ADD ROOM");
        room.addActionListener(this);
        admin.add(room);
        
        driver = new JMenuItem("ADD DRIVER");
        driver.addActionListener(this);
        admin.add(driver);

        // **********************************************************

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
    }

    public void actionPerformed(ActionEvent ae){

        // if(ae.getSource() == reception){
            
        // }
            if(ae.getSource() == emp){
                new add_Employee().setVisible(true);
            }else if (ae.getSource() == room){
                new add_Rooms().setVisible(true);
            } else if (ae.getSource() == driver){
                new add_Driver().setVisible(true);
            } else if (ae.getSource() == reception){
                new reception().setVisible(true);
            }


    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
