import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {

    JButton back;

    JTable table;

    Room(){

        setTitle("Rooms");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(440, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 35, 450, 450);
        add(image);

        // ***************************************************** JLabel

        JLabel RN = new JLabel("Room");
        RN.setBounds(35, 30, 40, 20);
        RN.setFont(new Font("Raleway", Font.BOLD, 13));
        add(RN);

        JLabel RN2 = new JLabel("Number");
        RN2.setBounds(35, 45, 50, 20);
        RN2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(RN2);

        JLabel ava = new JLabel("Avalibility");
        ava.setBounds(105, 30, 60, 20);
        ava.setFont(new Font("Raleway", Font.BOLD, 13));
        add(ava);

        JLabel cs = new JLabel("Cleaning");
        cs.setBounds(190, 30, 60, 20);
        cs.setFont(new Font("Raleway", Font.BOLD, 13));
        add(cs);

        JLabel cs2 = new JLabel("Status");
        cs2.setBounds(190, 45, 60, 20);
        cs2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(cs2);

        JLabel pc = new JLabel("Price");
        pc.setBounds(280, 30, 40, 20);
        pc.setFont(new Font("Raleway", Font.BOLD, 13));
        add(pc);

        JLabel BT = new JLabel("Bed Type");
        BT.setBounds(350, 30, 70, 20);
        BT.setFont(new Font("Raleway", Font.BOLD, 13));
        add(BT);

        // ***************************************************** JTable

        back = new JButton("Back");
        back.setBounds(300, 460, 120, 25);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255,255,255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        // ***************************************************** JTable

        table = new JTable();
        table.setBounds(20,80,400,400);
        add(table);

        try{

            String query1 = "SELECT * FROM add_room;";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        // **************************************************************

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
