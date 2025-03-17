import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame implements ActionListener {

    JButton CF_but, rooms_but, dept_but, all_Emp_but, cust_but, manag_but, checkout_but, US_but, URS_but,
            pickupService_but, searchRoom_but, logout_but;

    reception() {

        setTitle("Reception");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(330, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);

        // ***************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(470, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 470, 500);
        add(image);

        // ***************************************************** JButton

        CF_but = new JButton("New Customer Form");
        CF_but.setBounds(90, 10, 200, 25);
        CF_but.setFocusable(false);
        CF_but.setFont(new Font("Osward", Font.BOLD, 15));
        CF_but.setBorder(BorderFactory.createEmptyBorder());
        CF_but.setForeground(new Color(0, 153, 76));
        CF_but.setBackground(new Color(102, 255, 178));
        CF_but.addActionListener(this);
        add(CF_but);

        rooms_but = new JButton("Rooms");
        rooms_but.setBounds(90, 50, 200, 25);
        rooms_but.setFocusable(false);
        rooms_but.setFont(new Font("Osward", Font.BOLD, 15));
        rooms_but.setBorder(BorderFactory.createEmptyBorder());
        rooms_but.setForeground(new Color(0, 153, 76));
        rooms_but.setBackground(new Color(102, 255, 178));
        rooms_but.addActionListener(this);
        add(rooms_but);

        dept_but = new JButton("Department");
        dept_but.setBounds(90, 90, 200, 25);
        dept_but.setFocusable(false);
        dept_but.setFont(new Font("Osward", Font.BOLD, 15));
        dept_but.setBorder(BorderFactory.createEmptyBorder());
        dept_but.setForeground(new Color(0, 153, 76));
        dept_but.setBackground(new Color(102, 255, 178));
        dept_but.addActionListener(this);
        add(dept_but);

        all_Emp_but = new JButton("All Employees");
        all_Emp_but.setBounds(90, 130, 200, 25);
        all_Emp_but.setFocusable(false);
        all_Emp_but.setFont(new Font("Osward", Font.BOLD, 15));
        all_Emp_but.setBorder(BorderFactory.createEmptyBorder());
        all_Emp_but.setForeground(new Color(0, 153, 76));
        all_Emp_but.setBackground(new Color(102, 255, 178));
        all_Emp_but.addActionListener(this);
        add(all_Emp_but);

        cust_but = new JButton("Customer Info");
        cust_but.setBounds(90, 170, 200, 25);
        cust_but.setFocusable(false);
        cust_but.setFont(new Font("Osward", Font.BOLD, 15));
        cust_but.setBorder(BorderFactory.createEmptyBorder());
        cust_but.setForeground(new Color(0, 153, 76));
        cust_but.setBackground(new Color(102, 255, 178));
        cust_but.addActionListener(this);
        add(cust_but);

        manag_but = new JButton("Manager Info");
        manag_but.setBounds(90, 210, 200, 25);
        manag_but.setFocusable(false);
        manag_but.setFont(new Font("Osward", Font.BOLD, 15));
        manag_but.setBorder(BorderFactory.createEmptyBorder());
        manag_but.setForeground(new Color(0, 153, 76));
        manag_but.setBackground(new Color(102, 255, 178));
        manag_but.addActionListener(this);
        add(manag_but);

        checkout_but = new JButton("Checkout");
        checkout_but.setBounds(90, 250, 200, 25);
        checkout_but.setFocusable(false);
        checkout_but.setFont(new Font("Osward", Font.BOLD, 15));
        checkout_but.setBorder(BorderFactory.createEmptyBorder());
        checkout_but.setForeground(new Color(0, 153, 76));
        checkout_but.setBackground(new Color(102, 255, 178));
        checkout_but.addActionListener(this);
        add(checkout_but);

        US_but = new JButton("Update Status");
        US_but.setBounds(90, 290, 200, 25);
        US_but.setFocusable(false);
        US_but.setFont(new Font("Osward", Font.BOLD, 15));
        US_but.setBorder(BorderFactory.createEmptyBorder());
        US_but.setForeground(new Color(0, 153, 76));
        US_but.setBackground(new Color(102, 255, 178));
        US_but.addActionListener(this);
        add(US_but);

        URS_but = new JButton("Update Room Status");
        URS_but.setBounds(90, 330, 200, 25);
        URS_but.setFocusable(false);
        URS_but.setFont(new Font("Osward", Font.BOLD, 15));
        URS_but.setBorder(BorderFactory.createEmptyBorder());
        URS_but.setForeground(new Color(0, 153, 76));
        URS_but.setBackground(new Color(102, 255, 178));
        URS_but.addActionListener(this);
        add(URS_but);

        pickupService_but = new JButton("Pickup Service");
        pickupService_but.setBounds(90, 370, 200, 25);
        pickupService_but.setFocusable(false);
        pickupService_but.setFont(new Font("Osward", Font.BOLD, 15));
        pickupService_but.setBorder(BorderFactory.createEmptyBorder());
        pickupService_but.setForeground(new Color(0, 153, 76));
        pickupService_but.setBackground(new Color(102, 255, 178));
        pickupService_but.addActionListener(this);
        add(pickupService_but);

        searchRoom_but = new JButton("Search Room");
        searchRoom_but.setBounds(90, 410, 200, 25);
        searchRoom_but.setFocusable(false);
        searchRoom_but.setFont(new Font("Osward", Font.BOLD, 15));
        searchRoom_but.setBorder(BorderFactory.createEmptyBorder());
        searchRoom_but.setForeground(new Color(0, 153, 76));
        searchRoom_but.setBackground(new Color(102, 255, 178));
        searchRoom_but.addActionListener(this);
        add(searchRoom_but);

        logout_but = new JButton("Logout");
        logout_but.setBounds(90, 450, 200, 25);
        logout_but.setFocusable(false);
        logout_but.setFont(new Font("Osward", Font.BOLD, 15));
        logout_but.setBorder(BorderFactory.createEmptyBorder());
        logout_but.setForeground(new Color(255, 255, 255));
        logout_but.setBackground(new Color(255, 102, 102));
        logout_but.addActionListener(this);
        add(logout_but);

        // **********************************************************

        // pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        // 
        if (ae.getSource() == logout_but) {
            setVisible(false); // Hide the current window
            // Close the "dashboard" window
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof Dashboard) {
                    window.dispose(); // Close the "dashboard" window
                    break;
                }
            }
            new loginH().setVisible(true); // Show the login window
        } else if (ae.getSource() == CF_but) {
            setVisible(false);
            new add_Customer().setVisible(true);
        } else if (ae.getSource() == rooms_but) {
            setVisible(false);
            new Room().setVisible(true);
        } else if (ae.getSource() == dept_but) {
            setVisible(false);
            new Department().setVisible(true);
        } else if (ae.getSource() == all_Emp_but) {
            setVisible(false);
            new all_Employees().setVisible(true);
        } else if (ae.getSource() == cust_but) {
            setVisible(false);
            new customer_info().setVisible(true);
        } else if (ae.getSource() == manag_but) {
            setVisible(false);
            new managerInfo().setVisible(true);
        } else if (ae.getSource() == US_but) {
            setVisible(false);
            new UpdateStatus();
        } else if (ae.getSource() == URS_but) {
            setVisible(false);
            new updateRoomStatus().setVisible(true);
        } else if (ae.getSource() == searchRoom_but) {
            setVisible(false);
            new search_Room().setVisible(true);
        } else if (ae.getSource() == pickupService_but) {
            setVisible(false);
            new pickupService().setVisible(true);
        } else if (ae.getSource() == checkout_but){
            setVisible(false);
            new checkout().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new reception();
    }
}
