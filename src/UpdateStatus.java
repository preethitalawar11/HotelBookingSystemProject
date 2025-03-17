import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateStatus extends JFrame implements ActionListener {

    JTextField rn_field, name_field, ckTime_field, stay_field, amt_field, pdamt_field, addAmt_field;
    Choice id_Choice;
    JLabel add_amt;
    JButton back, update, search;

    UpdateStatus() {

        setTitle("Update Status");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update2.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 85, 350, 350);
        add(image);

        // ***************************************************** JLabel

        JLabel text = new JLabel("Update Status");
        text.setBounds(150, 30, 200, 20);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel id = new JLabel(" Customer ID : ");
        id.setBounds(50, 80, 150, 20);
        id.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(id);

        JLabel Stay = new JLabel("Stay Day :");
        Stay.setBounds(50, 130, 150, 20);
        Stay.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(Stay);

        JLabel num = new JLabel("Room Number : ");
        num.setBounds(50, 180, 150, 20);
        num.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(num);

        JLabel name = new JLabel("Name :");
        name.setBounds(50, 230, 150, 20);
        name.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(name);

        JLabel c_Time = new JLabel("Checkin Time :");
        c_Time.setBounds(50, 280, 150, 20);
        c_Time.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(c_Time);

        JLabel Amt_paid = new JLabel("Total Amount Paid :");
        Amt_paid.setBounds(50, 330, 150, 20);
        Amt_paid.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(Amt_paid);

        JLabel pd_amt = new JLabel("Pending Amount :");
        pd_amt.setBounds(50, 380, 180, 20);
        pd_amt.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(pd_amt);

        // ****************************************************** JTextField

        stay_field = new JTextField();
        stay_field.setBounds(250, 130, 205, 25);
        stay_field.setBorder(BorderFactory.createEtchedBorder());
        stay_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(stay_field);

        rn_field = new JTextField();
        rn_field.setBounds(250, 180, 205, 25);
        rn_field.setBorder(BorderFactory.createEtchedBorder());
        rn_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(rn_field);

        name_field = new JTextField();
        name_field.setBounds(250, 230, 205, 25);
        name_field.setBorder(BorderFactory.createEtchedBorder());
        name_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(name_field);

        ckTime_field = new JTextField();
        ckTime_field.setBounds(250, 280, 205, 25);
        ckTime_field.setBorder(BorderFactory.createEtchedBorder());
        ckTime_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(ckTime_field);

        amt_field = new JTextField();
        amt_field.setBounds(250, 330, 205, 25);
        amt_field.setBorder(BorderFactory.createEtchedBorder());
        amt_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(amt_field);

        pdamt_field = new JTextField();
        pdamt_field.setBounds(250, 380, 205, 25);
        pdamt_field.setBorder(BorderFactory.createEtchedBorder());
        pdamt_field.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(pdamt_field);

        // ****************************************************** Choice

        id_Choice = new Choice();
        id_Choice.setBounds(250, 80, 205, 25);
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

        // ****************************************************** JButton

        back = new JButton("Back");
        back.setBounds(50, 490, 120, 30);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        search = new JButton("Search");
        search.setBounds(200, 490, 120, 30);
        search.setFocusable(false);
        search.setFont(new Font("Osward", Font.BOLD, 15));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setForeground(new Color(255, 255, 255));
        search.setBackground(new Color(102, 178, 255));
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(350, 490, 120, 30);
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
        } else if (ae.getSource() == search) {

            String idString = id_Choice.getSelectedItem();

            String query2 = "SELECT* FROM add_Customer WHERE number = '" + idString + "';";
            try {

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query2);

                if (rs.next()) {

                    rn_field.setText(rs.getString("room_allocated"));
                    name_field.setText(rs.getString("name"));
                    ckTime_field.setText(rs.getString("checkin"));
                    amt_field.setText(rs.getString("deposit"));
                    int pending_amount, stayd;
                    stayd = Integer.parseInt(stay_field.getText());
                    int paid_amount = Integer.parseInt(amt_field.getText());
                    String query3 = "SELECT price FROM  add_room where RoomNum = '" + rn_field.getText() + "';";
                    ResultSet rs2 = c.s.executeQuery(query3);
                    if (rs2.next()) {
                        int price = Integer.parseInt(rs2.getString("price"));
                        pending_amount = (stayd * price) - paid_amount;

                        pdamt_field.setText(Integer.toString(pending_amount));

                        if (pending_amount > 0) {

                            System.out.println("entering condition");

                            add_amt = new JLabel("Additional Amount :");
                            add_amt.setBounds(50, 430, 180, 20);
                            add_amt.setFont(new Font("Raleway", Font.PLAIN, 17));
                            // add_amt.setVisible(true);
                            add(add_amt);

                            addAmt_field = new JTextField();
                            addAmt_field.setBounds(250, 430, 205, 25);
                            addAmt_field.setBorder(BorderFactory.createEtchedBorder());
                            addAmt_field.setFont(new Font("Raleway", Font.PLAIN, 13));
                            // addAmt_field.setVisible(true);
                            add(addAmt_field);

                            revalidate();
                            repaint();

                            // // Add a new component to a container
                            // container.add(newComponent);

                            // // Trigger layout recalculation
                            // container.revalidate();

                            // // Request repainting to reflect the changes
                            // container.repaint();

                        }

                    }

                } else {

                    System.out.println("No input Found");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            int new_add_amt;
            String idString = id_Choice.getSelectedItem();
            new_add_amt = Integer.parseInt(addAmt_field.getText());
            int new_total_amount = new_add_amt + Integer.parseInt(amt_field.getText());
            String Query1 = "update add_Customer set deposit = '" + new_total_amount + "' where number = '"
                    + idString + "';";
            // System.out.println(new_add_amt);
            try {

                Conn c = new Conn();
                c.s.executeUpdate(Query1);

                String Query2 = "SELECT deposit FROM add_customer WHERE number = '" + idString
                        + "';";
                ResultSet rs3 = c.s.executeQuery(Query2);
                if (rs3.next()) {
                    amt_field.setText(rs3.getString("deposit"));
                }

                int pending_amount, stayd;
                stayd = Integer.parseInt(stay_field.getText());
                int paid_amount = Integer.parseInt(amt_field.getText());
                String query3 = "SELECT price FROM  add_room where RoomNum = '" + rn_field.getText() + "';";
                ResultSet rs4 = c.s.executeQuery(query3);

                System.out.println("Entering rs4 area");

                if (rs4.next()) {
                    int price = Integer.parseInt(rs4.getString("price"));
                    pending_amount = (stayd * price) - paid_amount;
                    pdamt_field.setText(Integer.toString(pending_amount));

                    JOptionPane.showMessageDialog(null, "Money added Successfully");

                    if (pending_amount > 0) {
                        addAmt_field.setText("");
                    } else {
                        addAmt_field.setVisible(false);
                        add_amt.setVisible(false);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            // revalidate();
            // repaint();
        }
    }

    public static void main(String[] args) {
        new UpdateStatus();
    }
}
