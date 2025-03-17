import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class add_Driver extends JFrame implements ActionListener {

    JLabel cancel_png;
    JComboBox gender_Box, available_Box;
    JButton cancel, addDriver;
    JTextField name_field, age_field, cc_field, cm_field, location_field;

    add_Driver() {

        setTitle("Add Room");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(320, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 120, 500, 330);
        add(image);

        // ***************************************************** JLabel

        JLabel add_Drivers = new JLabel("Add Drivers");
        add_Drivers.setBounds(140, 30, 150, 20);
        add_Drivers.setFont(new Font("Raleway", Font.BOLD, 18));
        add(add_Drivers);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 150, 20);
        name.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(50, 150, 150, 20);
        age.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 200, 150, 20);
        gender.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(gender);

        JLabel cc = new JLabel("Car Company");
        cc.setBounds(50, 250, 150, 20);
        cc.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(cc);

        JLabel Car_M = new JLabel("Car Model");
        Car_M.setBounds(50, 300, 150, 20);
        Car_M.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(Car_M);

        JLabel avl = new JLabel("Available");
        avl.setBounds(50, 350, 150, 20);
        avl.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(avl);

        JLabel loc = new JLabel("Location");
        loc.setBounds(50, 400, 150, 20);
        loc.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(loc);

        // ********************************************************* JTextField

        name_field = new JTextField();
        name_field.setBounds(200, 100, 150, 25);
        name_field.setBorder(BorderFactory.createEtchedBorder());
        name_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(name_field);

        age_field = new JTextField();
        age_field.setBounds(200, 150, 150, 25);
        age_field.setBorder(BorderFactory.createEtchedBorder());
        age_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(age_field);

        cc_field = new JTextField();
        cc_field.setBounds(200, 250, 150, 25);
        cc_field.setBorder(BorderFactory.createEtchedBorder());
        cc_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(cc_field);

        cm_field = new JTextField();
        cm_field.setBounds(200, 300, 150, 25);
        cm_field.setBorder(BorderFactory.createEtchedBorder());
        cm_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(cm_field);

        location_field = new JTextField();
        location_field.setBounds(200, 400, 150, 25);
        location_field.setBorder(BorderFactory.createEtchedBorder());
        location_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(location_field);

        // ********************************************************* JComboBox

        String arr1[] = { "Male", "Female", "Others" };
        gender_Box = new JComboBox(arr1);
        gender_Box.setBounds(200, 200, 150, 25);
        gender_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        gender_Box.setSelectedItem(null);
        gender_Box.setBackground(Color.WHITE);
        gender_Box.setBorder(BorderFactory.createEmptyBorder());
        add(gender_Box);

        String arr2[] = { "Available", "Occupied" };
        available_Box = new JComboBox(arr2);
        available_Box.setBounds(200, 350, 150, 25);
        available_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        available_Box.setSelectedItem(null);
        available_Box.setBackground(Color.WHITE);
        available_Box.setBorder(BorderFactory.createEmptyBorder());
        add(available_Box);

        // ********************************************************** JButton

        cancel = new JButton("Cancel");
        cancel.setBounds(50, 460, 120, 30);
        cancel.setFocusable(false);
        cancel.setBorder(BorderFactory.createEtchedBorder());
        cancel.setFont(new Font("Osward", Font.BOLD, 15));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        addDriver = new JButton("Add Driver");
        addDriver.setBounds(230, 460, 120, 30);
        addDriver.setFocusable(false);
        addDriver.setBorder(BorderFactory.createEtchedBorder());
        addDriver.setFont(new Font("Osward", Font.BOLD, 15));
        addDriver.setForeground(Color.WHITE);
        addDriver.setBackground(Color.BLACK);
        addDriver.addActionListener(this);
        add(addDriver);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cancel) {

            setVisible(false);

        } else if (ae.getSource() == addDriver) {

            String name = name_field.getText();
            String age = age_field.getText();
            String gender = (String) gender_Box.getSelectedItem();
            String car_comp = cc_field.getText();
            String car_model = cm_field.getText();
            String availibility = (String) available_Box.getSelectedItem();
            String location = location_field.getText();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Age is Required");
            } else if (gender == null || gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is not selected");
            } else if (car_comp.equals("")) {
                JOptionPane.showMessageDialog(null, "Car Company is Required");
            } else if (car_model.equals("")) {
                JOptionPane.showMessageDialog(null, "Car Model is Required");
            } else if (availibility == null || availibility.equals("")) {
                JOptionPane.showMessageDialog(null, "Availability is not selected");
            } else if (location.equals("")) {
                JOptionPane.showMessageDialog(null, "Location is Required");
            } else {

                Conn c = new Conn();
                String query1 = "insert into add_driver values ('" + name + "','" + age + "','" + gender + "','"
                        + car_comp + "','" + car_model + "','" + availibility
                        + "','" + location + "');";

                try{

                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                    name_field.setText("");
                    age_field.setText("");
                    gender_Box.setSelectedItem(null);
                    cc_field.setText("");
                    cm_field.setText("");
                    available_Box.setSelectedItem(null);
                    location_field.setText("");

                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        }

    }

    public static void main(String[] args) {
        new add_Driver();
    }
}
