import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {

    JButton back;

    JTable table;

    Department(){

        setTitle("Department");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** JLabel

        JLabel RN = new JLabel("Department");
        RN.setBounds(250, 30, 200, 20);
        RN.setFont(new Font("Raleway", Font.BOLD, 15));
        add(RN);

        JLabel RN2 = new JLabel("Budget");
        RN2.setBounds(550, 30, 200, 20);
        RN2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(RN2);


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
        table.setBounds(135,120,600,400);
        table.setFont(new Font("Raleway",Font.PLAIN,15));
        add(table);

        try{

            String query1 = "SELECT * FROM department;";
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
        new Department();
    }
}
