import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class managerInfo extends JFrame implements ActionListener {

    JButton back;

    JTable table;

    managerInfo(){

        setTitle("All Employee Information");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** JLabel

        JLabel name = new JLabel("Name");
        name.setBounds(50, 40, 40, 20);
        name.setFont(new Font("Raleway", Font.BOLD, 13));
        add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165, 40, 50, 20);
        age.setFont(new Font("Raleway", Font.BOLD, 13));
        add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(260, 40, 60, 20);
        gender.setFont(new Font("Raleway", Font.BOLD, 13));
        add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(375, 40, 60, 20);
        job.setFont(new Font("Raleway", Font.BOLD, 13));
        add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(475, 40, 60, 20);
        salary.setFont(new Font("Raleway", Font.BOLD, 13));
        add(salary);

        JLabel pn = new JLabel("Phone No");
        pn.setBounds(570, 40, 80, 20);
        pn.setFont(new Font("Raleway", Font.BOLD, 13));
        add(pn);

        JLabel email = new JLabel("Email Id");
        email.setBounds(685, 40, 70, 20);
        email.setFont(new Font("Raleway", Font.BOLD, 13));
        add(email);

        JLabel AN = new JLabel("Aadhar Number");
        AN.setBounds(770, 40, 100, 20);
        AN.setFont(new Font("Raleway", Font.BOLD, 13));
        add(AN);

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
        table.setBounds(20,100,850,800);
        add(table);

        try{

            String query1 = "SELECT * FROM employee where job = 'Manager';";
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
        new managerInfo();
    }
}
