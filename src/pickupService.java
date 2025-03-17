import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class pickupService extends JFrame implements ActionListener {

    JTable table;
    Choice car_choice;
    JButton back, submit;

    pickupService() {

        setTitle("All Employee Information");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** JLabel

        JLabel text = new JLabel("Pickup Service");
        text.setBounds(375, 40, 200, 20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel carType = new JLabel("Type of Car:");
        carType.setBounds(50, 100, 100, 20);
        carType.setFont(new Font("Airel", Font.PLAIN, 13));
        add(carType);

        JLabel name = new JLabel("<html><u>Name</u></html>");
        name.setBounds(65, 150, 60, 20);
        name.setFont(new Font("Raleway", Font.BOLD, 13));
        add(name);

        JLabel age = new JLabel("<html><u>Age</u></html>");
        age.setBounds(190, 150, 60, 20);
        age.setFont(new Font("Raleway", Font.BOLD, 13));
        add(age);

        JLabel gender = new JLabel("<html><u>Gender</u></html>");
        gender.setBounds(300, 150, 60, 20);
        gender.setFont(new Font("Raleway", Font.BOLD, 13));
        add(gender);

        JLabel company = new JLabel("<html><u>Company</u></html>");
        company.setBounds(410, 150, 60, 20);
        company.setFont(new Font("Raleway", Font.BOLD, 13));
        add(company);

        JLabel brand = new JLabel("<html><u>Brand</u></html>");
        brand.setBounds(540, 150, 60, 20);
        brand.setFont(new Font("Raleway", Font.BOLD, 13));
        add(brand);

        JLabel availability = new JLabel("<html><u>Availability</u></html>");
        availability.setBounds(650, 150, 80, 20);
        availability.setFont(new Font("Raleway", Font.BOLD, 13));
        add(availability);

        JLabel loc = new JLabel("<html><u>Location</u></html>");
        loc.setBounds(780, 150, 80, 20);
        loc.setFont(new Font("Raleway", Font.BOLD, 13));
        add(loc);

        // ***************************************************** JLabel

        car_choice = new Choice();
        car_choice.setBounds(200, 100, 100, 20);
        add(car_choice);

        try {

            String quer1 = "Select * from add_driver;";
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery(quer1);
            while (rs1.next()) {
                car_choice.add(rs1.getString("car_Company"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ***************************************************** JButton
        back = new JButton("Back");
        back.setBounds(280, 450, 120, 30);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        submit = new JButton("Search");
        submit.setBounds(500, 450, 120, 30);
        submit.setFocusable(false);
        submit.setFont(new Font("Osward", Font.BOLD, 15));
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setForeground(new Color(0, 153, 76));
        submit.setBackground(new Color(102, 255, 178));
        submit.addActionListener(this);
        add(submit);
  
        // ***************************************************** JTable

        table = new JTable();
        table.setBounds(20, 200, 850, 250);
        add(table);

        // try{

        // String query1 = "SELECT * FROM add_driver;";
        // Conn c = new Conn();
        // ResultSet rs = c.s.executeQuery(query1);
        // table.setModel(DbUtils.resultSetToTableModel(rs));

        // }catch(Exception e){
        // e.printStackTrace();
        // }

        // **************************************************************

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {

            setVisible(false);
            new reception().setVisible(true);

        } else if (ae.getSource() == submit) {

            String s = car_choice.getSelectedItem();
            String query2 = "select * from add_driver where car_Company = '" + s + "';";

            try {

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query2);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new pickupService();
    }
}
