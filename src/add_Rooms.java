import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class add_Rooms extends JFrame implements ActionListener {

    JTextField room_field, price_field;
    JComboBox available_Box, Cleaning_Box, BedType_Box;
    JButton cancel, addRoom;

    add_Rooms() {

        setTitle("Add Room");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(320, 180, 900, 500);
        setMaximizedBounds(getBounds());
        setResizable(false);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        // Image i2 = i1.getImage().getScaledInstance(450, 310, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 60, 500, 330);
        // image.setBounds(350,20,600,400);
        add(image);

        // ***************************************************** JLabel

        JLabel add_Rooms = new JLabel("Add Rooms");
        add_Rooms.setBounds(140, 20, 150, 20);
        add_Rooms.setFont(new Font("Raleway", Font.BOLD, 18));
        add(add_Rooms);

        JLabel room_no = new JLabel("Room Number");
        room_no.setBounds(50, 100, 150, 20);
        room_no.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(room_no);

        JLabel available = new JLabel("Available");
        available.setBounds(50, 150, 150, 20);
        available.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(available);

        JLabel cs = new JLabel("Cleaning Status");
        cs.setBounds(50, 200, 150, 20);
        cs.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(cs);

        JLabel price = new JLabel("Price");
        price.setBounds(50, 250, 150, 20);
        price.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(price);

        JLabel bd_T = new JLabel("Bed Type");
        bd_T.setBounds(50, 300, 150, 20);
        bd_T.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(bd_T);

        // ********************************************************* JTextField

        room_field = new JTextField();
        room_field.setBounds(200, 100, 150, 25);
        room_field.setBorder(BorderFactory.createEtchedBorder());
        room_field.setFont(new Font("Raleway", Font.PLAIN,13));
        add(room_field);

        price_field = new JTextField();
        price_field.setBounds(200, 250, 150, 25);
        price_field.setBorder(BorderFactory.createEtchedBorder());
        price_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(price_field);

        // ********************************************************* JComboBox

        String arr1[] = { "Available", "Occupied" };
        available_Box = new JComboBox(arr1);
        available_Box.setBounds(200, 150, 150, 25);
        available_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        available_Box.setSelectedItem(null);
        available_Box.setBackground(Color.WHITE);
        available_Box.setBorder(BorderFactory.createEmptyBorder());
        add(available_Box);

        String arr2[] = { "Clean", "Dirty" };
        Cleaning_Box = new JComboBox(arr2);
        Cleaning_Box.setBounds(200, 200, 150, 25);
        Cleaning_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        Cleaning_Box.setSelectedItem(null);
        Cleaning_Box.setBackground(Color.WHITE);
        Cleaning_Box.setBorder(BorderFactory.createEmptyBorder());
        add(Cleaning_Box);

        String arr3[] = { "Single Bed", "Double Bed" };
        BedType_Box = new JComboBox(arr3);
        BedType_Box.setBounds(200, 300, 150, 25);
        BedType_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        BedType_Box.setSelectedItem(null);
        BedType_Box.setBackground(Color.WHITE);
        BedType_Box.setBorder(BorderFactory.createEmptyBorder());
        add(BedType_Box);

        // ********************************************************** JButton

        cancel = new JButton("Cancel");
        cancel.setBounds(50, 370, 120, 30);
        cancel.setFocusable(false);
        cancel.setBorder(BorderFactory.createEtchedBorder());
        cancel.setFont(new Font("Osward", Font.BOLD, 15));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        addRoom = new JButton("Add Room");
        addRoom.setBounds(230, 370, 120, 30);
        addRoom.setFocusable(false);
        addRoom.setBorder(BorderFactory.createEtchedBorder());
        addRoom.setFont(new Font("Osward", Font.BOLD, 15));
        addRoom.setForeground(Color.WHITE);
        addRoom.setBackground(Color.BLACK);
        addRoom.addActionListener(this);
        add(addRoom);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == cancel) {

            setVisible(false);

        } else if (ae.getSource() == addRoom) {

            String room_num = room_field.getText();
            String price = price_field.getText();
            String aval = (String) available_Box.getSelectedItem();
            String clean = (String) Cleaning_Box.getSelectedItem();
            String bed_Type = (String) BedType_Box.getSelectedItem();

            if (room_num.equals("")) {
                JOptionPane.showMessageDialog(null, "Room Number is Not allocated");
            } else if (aval == null || aval.equals("")) {
                JOptionPane.showMessageDialog(null, "Availability is not selected");
            } else if (clean == null || clean.equals("")) {
                JOptionPane.showMessageDialog(null, "Cleaning status is not selected");
            } else if (price.equals("")) {
                JOptionPane.showMessageDialog(null, "Price required");
            } else if (bed_Type == null || bed_Type.equals("")) {
                JOptionPane.showMessageDialog(null, "BedType is not selected");
            } else {

                Conn c = new Conn();
                String query1 = "insert into add_room values ('" + room_num + "','" + aval + "','" + clean + "','"
                        + price
                        + "','" + bed_Type + "');";

                try {
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "NEw Room Added Successfully");
                    room_field.setText("");
                    price_field.setText("");
                    available_Box.setSelectedItem(null);
                    Cleaning_Box.setSelectedItem(null);
                    BedType_Box.setSelectedItem(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new add_Rooms();
    }
}
