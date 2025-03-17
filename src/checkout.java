import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class checkout extends JFrame implements ActionListener, ItemListener {

    JButton back, checkout_But;
    Choice id_Choice;
    JLabel roomNumVal, checkinVal, checkoutVal, TotalamtVal;
    String checkoutTime;

    LocalDateTime currentDateTime = LocalDateTime.now();
    // Define a custom formatter with the desired pattern
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Format the date and time using the formatter
    String formattedDateTime = currentDateTime.format(formatter);

    checkout() {

        setTitle("Reception");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 500, 500);
        add(image);

        // ***************************************************** JLabel

        JLabel text = new JLabel("Check Out");
        text.setBounds(150, 40, 150, 20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel cus_id = new JLabel("Customer ID :");
        cus_id.setBounds(30, 120, 150, 20);
        cus_id.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(cus_id);

        JLabel roomNum = new JLabel("Room Number :");
        roomNum.setBounds(30, 170, 150, 20);
        roomNum.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(roomNum);

        JLabel Checkin = new JLabel("Checkin Time :");
        Checkin.setBounds(30, 220, 150, 20);
        Checkin.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(Checkin);

        JLabel checkout = new JLabel("Checkout Time :");
        checkout.setBounds(30, 270, 150, 20);
        checkout.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(checkout);

        JLabel ta = new JLabel("Total Amount Paid :");
        ta.setBounds(30, 320, 150, 20);
        ta.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(ta);

        // ********************************************************* JLabelVal

        roomNumVal = new JLabel();
        roomNumVal.setBounds(180, 170, 190, 20);
        roomNumVal.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(roomNumVal);

        checkinVal = new JLabel();
        checkinVal.setBounds(180, 220, 210, 20);
        checkinVal.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(checkinVal);

        checkoutVal = new JLabel();
        checkoutVal.setBounds(180, 270, 210, 20);
        checkoutVal.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(checkoutVal);

        TotalamtVal = new JLabel();
        TotalamtVal.setBounds(180, 320, 190, 20);
        TotalamtVal.setFont(new Font("Raleway", Font.PLAIN, 15));
        add(TotalamtVal);

        // ********************************************************* Choice

        id_Choice = new Choice();
        id_Choice.setBounds(180, 120, 190, 25);
        id_Choice.setFont(new Font("Osward", Font.PLAIN, 13));
        id_Choice.addItemListener((ItemListener) this);
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

        // ********************************************************* JButton

        back = new JButton("Back");
        back.setBounds(40, 420, 120, 30);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        checkout_But = new JButton("Checkout");
        checkout_But.setBounds(215, 420, 120, 30);
        checkout_But.setFocusable(false);
        checkout_But.setFont(new Font("Osward", Font.BOLD, 14));
        checkout_But.setBorder(BorderFactory.createEmptyBorder());
        checkout_But.setForeground(new Color(0, 153, 76));
        checkout_But.setBackground(new Color(102, 255, 178));
        checkout_But.addActionListener(this);
        add(checkout_But);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == id_Choice && ie.getStateChange() == ItemEvent.SELECTED) {

            String selectedID = id_Choice.getSelectedItem();

            try {

                Conn c = new Conn();
                String query = "Select* from add_Customer where number = '" + selectedID + "';";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    roomNumVal.setText(rs.getString("room_allocated"));
                    checkinVal.setText(rs.getString("checkin"));
                    TotalamtVal.setText(rs.getString("deposit"));

                    // ********************************************************* JCheckOutTime

                    // DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern();
                    checkoutTime = "" + formattedDateTime;

                    checkoutVal.setText(checkoutTime);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
            new reception().setVisible(true);
        } else if (ae.getSource() == checkout_But) {

            String rn = roomNumVal.getText();
            String query2 = "Delete from add_Customer where number = '" + id_Choice.getSelectedItem() + "';";
            String query3 = "Update add_room set Available = 'Available' where RoomNum = '" + rn + "';";
            String query4 = "Select * from add_room where RoomNum = '" + rn + "';";
            String query5 = "Select * from add_Customer where number = '" + id_Choice.getSelectedItem() + "';";
            String query6 = "Update add_room set Cleaning_Status = 'Dirty' where RoomNum = '" + rn + "';";

            long amt_paid;
            String s1 = checkinVal.getText();
            LocalDateTime checkinDateTime = LocalDateTime.parse(s1, formatter);

            long daysDifference = ChronoUnit.DAYS.between(checkinDateTime, currentDateTime);
            System.out.println(daysDifference);

            try {

                long price1;
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query5);
                if (rs1.next()) {
                    amt_paid = Long.parseLong(rs1.getString("deposit"));

                    ResultSet rs2 = c.s.executeQuery(query4);
                    if (rs2.next()) {
                        price1 = Long.parseLong(rs2.getString("price"));
                        if(daysDifference == 0){
                            daysDifference =1;
                        }
                        long remainingAmt = (daysDifference * price1) - amt_paid;
                        System.out.println(daysDifference);
                        System.out.println(price1);
                        System.out.println(amt_paid);
                        System.out.println(remainingAmt);
                        if (remainingAmt > 0) {
                            JOptionPane.showMessageDialog(null, "Checkout failed " + remainingAmt + " is pending");
                        } else {

                            try {
                                c.s.executeUpdate(query2);
                                c.s.executeUpdate(query3);
                                c.s.executeUpdate(query6);

                                JOptionPane.showMessageDialog(null, "Checkout Successfull");
                                setVisible(false);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new checkout();
    }
}
