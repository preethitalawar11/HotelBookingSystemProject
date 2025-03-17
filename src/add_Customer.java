import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.sql.*;

public class add_Customer extends JFrame implements ActionListener {

    JTextField number_field, name_field, country_field, deposit_field;
    JRadioButton male, female, others, singleBR, doubleBR;
    JLabel time;
    JComboBox idBox;
    Choice room_all_Choice;
    JButton back, add_Customer;
    String Checkin;
    ButtonGroup bg1, bg2;

    add_Customer() {

        setTitle("Add Customer");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 35, 450, 450);
        add(image);

        // ***************************************************** JLabel

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(120, 30, 200, 20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel id = new JLabel("ID : ");
        id.setBounds(50, 80, 150, 20);
        id.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(id);

        JLabel num = new JLabel("Number : ");
        num.setBounds(50, 120, 150, 20);
        num.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(num);

        JLabel name = new JLabel("Name :");
        name.setBounds(50, 160, 150, 20);
        name.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(name);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(50, 200, 150, 20);
        gender.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(gender);

        JLabel country = new JLabel("Country :");
        country.setBounds(50, 240, 150, 20);
        country.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(country);

        JLabel bedType = new JLabel("Room Type");
        bedType.setBounds(50, 280, 180, 20);
        bedType.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(bedType);

        JLabel ar_RN = new JLabel("Allocated Room No :");
        ar_RN.setBounds(50, 320, 180, 20);
        ar_RN.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(ar_RN);

        JLabel checkin = new JLabel("Check-in :");
        checkin.setBounds(50, 360, 150, 20);
        checkin.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(checkin);

        JLabel deposit = new JLabel("Deposit :");
        deposit.setBounds(50, 400, 150, 20);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(deposit);

        // LocalDateTime currentDateTime = LocalDateTime.now();
        // // Define a custom formatter with the desired pattern
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE MMMM uuuu','
        // HH:mm:ss", Locale.ENGLISH);
        // // Format the date
        // String formattedDateTime = currentDateTime.format(formatter);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a custom formatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the date and time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        // DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern();
        Checkin = "" + formattedDateTime;
        time = new JLabel(formattedDateTime);
        time.setBounds(250, 360, 235, 20);
        time.setFont(new Font("Osward", Font.PLAIN, 14));
        add(time);

        // ********************************************************* JTextField

        number_field = new JTextField();
        number_field.setBounds(250, 120, 205, 25);
        number_field.setBorder(BorderFactory.createEtchedBorder());
        number_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(number_field);

        name_field = new JTextField();
        name_field.setBounds(250, 160, 205, 25);
        name_field.setBorder(BorderFactory.createEtchedBorder());
        name_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(name_field);

        country_field = new JTextField();
        country_field.setBounds(250, 240, 205, 25);
        country_field.setBorder(BorderFactory.createEtchedBorder());
        country_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(country_field);

        deposit_field = new JTextField();
        deposit_field.setBounds(250, 400, 205, 25);
        deposit_field.setBorder(BorderFactory.createEtchedBorder());
        deposit_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(deposit_field);

        // ********************************************************* Choice

        room_all_Choice = new Choice();
        room_all_Choice.setBounds(250, 320, 205, 25);
        room_all_Choice.setFont(new Font("Osward", Font.PLAIN, 13));
        // room_all_Choice.getSelectedItem();
        add(room_all_Choice);

        // try {
        // String query1 = "select RoomNum from add_room where Available = 'Available';
        // ";
        // Conn c = new Conn();

        // ResultSet rs = c.s.executeQuery(query1);
        // if (rs.next()) {
        // room_all_Choice.add(rs.getString("RoomNum"));
        // }

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // ********************************************************* JRadioButton

        male = new JRadioButton("Male");
        male.setBounds(250, 200, 60, 25);
        male.setFont(new Font("Osward", Font.BOLD, 13));
        // male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(313, 200, 70, 25);
        female.setFont(new Font("Osward", Font.BOLD, 13));
        // female.setBackground(Color.WHITE);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(390, 200, 70, 25);
        others.setFont(new Font("Osward", Font.BOLD, 13));
        // others.setBackground(Color.WHITE);
        add(others);

        bg1 = new ButtonGroup();
        bg1.add(male);
        bg1.add(female);
        bg1.add(others);

        singleBR = new JRadioButton("Single Bed");
        singleBR.setBounds(250, 280, 100, 25);
        singleBR.setFont(new Font("Osward", Font.BOLD, 13));
        // female.setBackground(Color.WHITE);
        singleBR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the existing items
                room_all_Choice.removeAll();

                // Fetch and add single bed room numbers
                try {
                    String query = "SELECT RoomNum FROM add_room WHERE Available = 'Available' AND bed_Type = 'Single Bed';";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        room_all_Choice.add(rs.getString("RoomNum"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(singleBR);

        doubleBR = new JRadioButton("Double Bed");
        doubleBR.setBounds(350, 280, 100, 25);
        doubleBR.setFont(new Font("Osward", Font.BOLD, 13));
        // others.setBackground(Color.WHITE);
        doubleBR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the existing items
                room_all_Choice.removeAll();

                // Fetch and add double bed room numbers
                try {
                    String query = "SELECT RoomNum FROM add_room WHERE Available = 'Available' AND bed_Type = 'Double Bed';";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);

                    while (rs.next()) {
                        room_all_Choice.add(rs.getString("RoomNum"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(doubleBR);

        bg2 = new ButtonGroup();
        bg2.add(singleBR);
        bg2.add(doubleBR);

        // ********************************************************* JRadioButton

        String idVal[] = { "Aadhar Card", "Passport", "Driving Liscence", "Voter ID Card", "Ration Card" };
        idBox = new JComboBox(idVal);
        idBox.setBounds(250, 80, 205, 25);
        idBox.setFont(new Font("Raleway", Font.PLAIN, 13));
        idBox.setSelectedItem(null);
        idBox.setBackground(Color.WHITE);
        idBox.setBorder(BorderFactory.createEmptyBorder());
        add(idBox);

        // ********************************************************* JButton

        back = new JButton("Back");
        back.setBounds(80, 470, 150, 30);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        add_Customer = new JButton("Add Customer");
        add_Customer.setBounds(275, 470, 150, 30);
        add_Customer.setFocusable(false);
        add_Customer.setFont(new Font("Osward", Font.BOLD, 14));
        add_Customer.setBorder(BorderFactory.createEmptyBorder());
        add_Customer.setForeground(new Color(0, 153, 76));
        add_Customer.setBackground(new Color(102, 255, 178));
        add_Customer.addActionListener(this);
        add(add_Customer);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new reception().setVisible(true);
        } else if (ae.getSource() == add_Customer) {

            String ID = (String) idBox.getSelectedItem();
            String Number = number_field.getText();
            String Name = name_field.getText();
            String gender = "";
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else {
                gender = "Others";
            }
            String Country = country_field.getText();
            String alRoomNum = room_all_Choice.getSelectedItem();

            String Deposit = deposit_field.getText();

            if (ID == null || ID.equals("")) {
                JOptionPane.showMessageDialog(null, "ID not Selected");
            } else if (Number.equals("")) {
                JOptionPane.showMessageDialog(null, "Number is Required");
            } else if (Name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (Country.equals("")) {
                JOptionPane.showMessageDialog(null, "Country is Required");
            } else if (alRoomNum.equals("")) {
                JOptionPane.showMessageDialog(null, "Room Number is not allocated");
            } else if (Deposit.equals("")) {
                JOptionPane.showMessageDialog(null, "Deposit Required");
            } else {

                Conn c = new Conn();

                String query2 = "INSERT INTO add_Customer VALUES ('"
                        + ID + "','" + Number + "','" + Name + "','" + gender + "','" + Country + "','" + alRoomNum
                        + "','" + Checkin + "','" + Deposit + "');";

                String query3 = "Update add_room set Available = 'Occupied' where RoomNum = '" + alRoomNum + "';";

                try {
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "Details added Successfully");

                    idBox.setSelectedItem(null);
                    number_field.setText("");
                    name_field.setText("");
                    male.setSelected(false);
                    female.setSelected(false);
                    others.setSelected(false);
                    country_field.setText("");
                    deposit_field.setText("");
                    bg2.clearSelection();
                    bg1.clearSelection();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static void main(String[] args) {
        new add_Customer();
    }
}
