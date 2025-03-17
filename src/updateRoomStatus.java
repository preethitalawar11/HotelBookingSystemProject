import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class updateRoomStatus extends JFrame implements ActionListener {

    Choice id_Choice;
    JTextField roomNo_field, aval_field, cs_field;
    JButton check, update, back;

    updateRoomStatus() {

        setTitle("Update Status");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 125, 400, 250);
        add(image);

        // ***************************************************** JLabel

        JLabel text = new JLabel("Update Room Status");
        text.setBounds(125, 30, 200, 20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel cusId = new JLabel("Customer ID");
        cusId.setBounds(30, 100, 150, 20);
        cusId.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(cusId);

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(30, 160, 200, 20);
        roomNo.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(roomNo);

        JLabel aval = new JLabel("Availability");
        aval.setBounds(30, 220, 200, 20);
        aval.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(aval);

        JLabel cs = new JLabel("Cleaning Status");
        cs.setBounds(30, 280, 200, 20);
        cs.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(cs);

        // ****************************************************** JTextField

        id_Choice = new Choice();
        id_Choice = new Choice();
        id_Choice.setBounds(200, 100, 205, 25);
        id_Choice.setFont(new Font("Osward", Font.PLAIN, 13));
        // id_Choice.add("");
        add(id_Choice);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM add_Customer;");
            while (rs.next()) {
                id_Choice.add(rs.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ****************************************************** JTextField

        roomNo_field = new JTextField();
        roomNo_field.setBounds(200, 160, 205, 25);
        roomNo_field.setBorder(BorderFactory.createEtchedBorder());
        roomNo_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(roomNo_field);

        aval_field = new JTextField();
        aval_field.setBounds(200, 220, 205, 25);
        aval_field.setBorder(BorderFactory.createEtchedBorder());
        aval_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(aval_field);

        cs_field = new JTextField();
        cs_field.setBounds(200, 280, 205, 25);
        cs_field.setBorder(BorderFactory.createEtchedBorder());
        cs_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(cs_field);

        // ****************************************************** JButton

        back = new JButton("Back");
        back.setBounds(50, 400, 100, 30);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        check = new JButton("Check");
        check.setBounds(175, 400, 100, 30);
        check.setFocusable(false);
        check.setFont(new Font("Osward", Font.BOLD, 15));
        check.setBorder(BorderFactory.createEmptyBorder());
        check.setForeground(new Color(255, 255, 255));
        check.setBackground(new Color(102, 178, 255));
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(300, 400, 100, 30);
        update.setFocusable(false);
        update.setFont(new Font("Osward", Font.BOLD, 14));
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setForeground(new Color(0, 153, 76));
        update.setBackground(new Color(102, 255, 178));
        update.addActionListener(this);
        add(update);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new reception().setVisible(true);
        } else if (ae.getSource() == check) {

            String cusIDString = id_Choice.getSelectedItem();
            String room_Number;

            try {
                String query1 = "Select room_allocated from add_Customer where number = '" + cusIDString + "';";
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query1);

                if (rs1.next()) {

                    room_Number = rs1.getString("room_allocated");
                    roomNo_field.setText(room_Number);
                    String query2 = "Select * from add_room where RoomNum = '" + room_Number + "';";
                    ResultSet rs2 = c.s.executeQuery(query2);
                    if (rs2.next()) {
                        aval_field.setText(rs2.getString("Available"));
                        cs_field.setText(rs2.getString("Cleaning_Status"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            String avalString = aval_field.getText();
            String csString = cs_field.getText();

            String cusIDString = id_Choice.getSelectedItem();
            String room_Number;

            try {
                String query1 = "Select room_allocated from add_Customer where number = '" + cusIDString + "';";
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query1);

                if (rs1.next()) {

                    room_Number = rs1.getString("room_allocated");
                    roomNo_field.setText(room_Number);
                    System.out.println("Enter update area");
                    String query2 = "UPDATE add_room set Available = '" + avalString + "' where RoomNum = '" + room_Number
                            + "';";
                    String query3 = "UPDATE add_room set Cleaning_Status = '" + csString + "' where RoomNum = '"
                            + room_Number + "';";
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Data update Successfully");
                    setVisible(false);
                    new reception().setVisible(true);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new updateRoomStatus();
    }
}
