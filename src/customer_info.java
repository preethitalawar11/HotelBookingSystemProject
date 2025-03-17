import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class customer_info extends JFrame implements ActionListener {

    JButton back;

    JTable table;

    customer_info(){

        setTitle("Customers Information");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** JLabel

        JLabel id = new JLabel("ID Type");
        id.setBounds(45, 40, 100, 20);
        id.setFont(new Font("Raleway", Font.BOLD, 13));
        add(id);

        JLabel num = new JLabel("ID Number");
        num.setBounds(145, 40, 100, 20);
        num.setFont(new Font("Raleway", Font.BOLD, 13));
        add(num);

        JLabel name = new JLabel("Name");
        name.setBounds(265, 40, 60, 20);
        name.setFont(new Font("Raleway", Font.BOLD, 13));
        add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(365, 40, 60, 20);
        gender.setFont(new Font("Raleway", Font.BOLD, 13));
        add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(475, 40, 60, 20);
        country.setFont(new Font("Raleway", Font.BOLD, 13));
        add(country);

        JLabel ra = new JLabel("Room Allocated");
        ra.setBounds(550, 40, 120, 20);
        ra.setFont(new Font("Raleway", Font.BOLD, 13));
        add(ra);

        JLabel checkin = new JLabel("Checkin");
        checkin.setBounds(685, 40, 70, 20);
        checkin.setFont(new Font("Raleway", Font.BOLD, 13));
        add(checkin);

        JLabel dep = new JLabel("Deposit");
        dep.setBounds(790, 40, 100, 20);
        dep.setFont(new Font("Raleway", Font.BOLD, 13));
        add(dep);

        // ***************************************************** JTable

        back = new JButton("Back");
        back.setBounds(700, 460, 120, 25);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255,255,255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        // ***************************************************** JTable

        table = new JTable();
        table.setBounds(20,100,850,500);
        add(table);

        try{

            String query1 = "SELECT * FROM add_Customer;";
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
        new customer_info();
    }
}
