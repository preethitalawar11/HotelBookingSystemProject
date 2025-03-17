// package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class add_Employee extends JFrame implements ActionListener {

    JTextField name_field, age_field, salary_field, phone_field, email_field, aadhar_field;
    JRadioButton male, female, others;
    JComboBox job_box;
    JButton submit, back;

    add_Employee() {

        setTitle("Add Employee");
        setLayout(null);
        setLocationRelativeTo(null);

        // *********************************************************** ImageIcon

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, -50, 700, 600);
        add(image);

        // *********************************************************** JLabel

        // n = name, a = age, g = gender, j = job, s = salary, p = phone, e = email, aa
        // = aadhar

        JLabel n = new JLabel("NAME: ");
        n.setBounds(50, 30, 100, 30);
        n.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(n);

        JLabel a = new JLabel("AGE: ");
        a.setBounds(50, 80, 100, 30);
        a.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(a);

        JLabel g = new JLabel("GENDER: ");
        g.setBounds(50, 130, 100, 30);
        g.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(g);

        JLabel j = new JLabel("JOB: ");
        j.setBounds(50, 180, 100, 30);
        j.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(j);

        JLabel s = new JLabel("SALARY: ");
        s.setBounds(50, 230, 100, 30);
        s.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(s);

        JLabel p = new JLabel("PHONE NO: ");
        p.setBounds(50, 280, 150, 30);
        p.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(p);

        JLabel e = new JLabel("EMAIL: ");
        e.setBounds(50, 330, 100, 30);
        e.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(e);

        JLabel aa = new JLabel("AADHAR NO: ");
        aa.setBounds(50, 380, 150, 30);
        aa.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(aa);

        // ************************************************************** JTextField

        name_field = new JTextField();
        name_field.setBounds(170, 33, 200, 25);
        name_field.setBorder(BorderFactory.createEtchedBorder());
        name_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(name_field);

        age_field = new JTextField();
        age_field.setBounds(170, 83, 200, 25);
        age_field.setBorder(BorderFactory.createEtchedBorder());
        age_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(age_field);

        salary_field = new JTextField();
        salary_field.setBounds(170, 233, 200, 25);
        salary_field.setBorder(BorderFactory.createEtchedBorder());
        salary_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(salary_field);

        phone_field = new JTextField();
        phone_field.setBounds(170, 283, 200, 25);
        phone_field.setBorder(BorderFactory.createEtchedBorder());
        phone_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(phone_field);

        email_field = new JTextField();
        email_field.setBounds(170, 333, 200, 25);
        email_field.setBorder(BorderFactory.createEtchedBorder());
        email_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(email_field);

        aadhar_field = new JTextField();
        aadhar_field.setBounds(170, 383, 200, 25);
        aadhar_field.setBorder(BorderFactory.createEtchedBorder());
        aadhar_field.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(aadhar_field);

        // *********************************************************** JRadioButton

        male = new JRadioButton("Male");
        male.setBounds(170, 130, 60, 30);
        male.setFont(new Font("Osward", Font.BOLD, 13));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(230, 130, 70, 30);
        female.setFont(new Font("Osward", Font.BOLD, 13));
        female.setBackground(Color.WHITE);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(305, 130, 70, 30);
        others.setFont(new Font("Osward", Font.BOLD, 13));
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(others);

        // *********************************************************** JButton

        submit = new JButton("Submit");
        submit.setBounds(170, 430, 200, 25);
        submit.setFocusable(false);
        submit.setFont(new Font("Osward", Font.BOLD, 15));
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setForeground(new Color(0, 153, 76));
        submit.setBackground(new Color(102, 255, 178));
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(170, 465, 200, 25);
        back.setFocusable(false);
        back.setFont(new Font("Osward", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255,255,255));
        back.setBackground(new Color(255, 102, 102));
        back.addActionListener(this);
        add(back);

        // *********************************************************** JComboBox

        String valjob[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs",
                "Waiter/Waitress", "Manager", "Accountant" };
        job_box = new JComboBox(valjob);
        job_box.setBounds(170, 180, 200, 25);
        job_box.setFont(new Font("Raleway", Font.PLAIN, 13));
        job_box.setSelectedItem(null);
        job_box.setBackground(Color.WHITE);
        job_box.setBorder(BorderFactory.createEmptyBorder());
        add(job_box);

        // **************************************************************

        // pack();
        setVisible(true);
        // setExtendedState(MAXIMIZED_BOTH);
        setBounds(270, 180, 1000, 550);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String name = name_field.getText();
            String age = age_field.getText();
            String salary = salary_field.getText();
            String phone = phone_field.getText();
            String email = email_field.getText();
            String aadhar = aadhar_field.getText();

            String gender = null;
            if (male.isSelected()) {
                gender = "male";
            } else if (female.isSelected()) {
                gender = "female";
            } else if (others.isSelected()) {
                gender = "others";
            } else {
                gender = "";
            }

            String job = "";
            job = (String) job_box.getSelectedItem();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (age.equals("")) {
                JOptionPane.showMessageDialog(null, "Age is Required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            } else if (job == null || job.equals("")) {
                JOptionPane.showMessageDialog(null, "Job is Required");
            } else if (salary.equals("")) {
                JOptionPane.showMessageDialog(null, "Salary is Required");
            } else if (phone.length() < 10 || phone.length() > 10) {
                JOptionPane.showMessageDialog(null, "Phone Number is incorrect");
            } else if (phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Phone Number is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email Id is Required");
            } else if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            } else {
                String query1 = "insert into employee values ('" + name + "','" + age + "','" + gender + " ','" + job
                        + "','"
                        + salary + "','" + phone + "','" + email + "','" + aadhar + "');";

                Conn c = new Conn();
                try {
                    c.s.executeUpdate(query1);
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Dashboard().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new add_Employee();
    }
}
