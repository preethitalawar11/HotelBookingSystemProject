// package package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loginH extends JFrame implements ActionListener{

    JLabel username, password;
    JTextField usr;
    JPasswordField pass;
    JButton login, cancel;

    loginH() {

        setTitle("Login");
        setLayout(null);
        setLocationRelativeTo(null);
        setBounds(180, 180, 900, 580);
        setMaximizedBounds(getBounds());
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        // ***************************************************** JLabel

        username = new JLabel("Username");
        username.setBounds(100, 100, 150, 30);
        username.setFont(new Font("Raleway", Font.BOLD, 20));
        add(username);

        password = new JLabel("Password");
        password.setBounds(100, 200, 150, 30);
        password.setFont(new Font("Raleway", Font.BOLD, 20));
        add(password);

        // ***************************************************** JTextField

        usr = new JTextField();
        usr.setFont(new Font("Raleway",Font.PLAIN,19));
        usr.setBorder(BorderFactory.createEtchedBorder());
        usr.setBounds(300, 100, 200, 35);
        add(usr);

        // ***************************************************** JPasswordField

        pass = new JPasswordField();
        pass.setFont(new Font("Raleway",Font.PLAIN,25));
        pass.setBorder(BorderFactory.createEtchedBorder());
        pass.setBounds(300, 200, 200, 35);
        pass.setEchoChar('*');
        add(pass);

        // ***************************************************** JButton

        login = new JButton("Login");
        login.setFocusable(false);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setForeground(new Color(0, 153, 76));
        login.setBackground(new Color(102, 255, 178));
        login.setFont(new Font("Raleway",Font.BOLD,20));
        login.setBounds(100,350,180,35);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setForeground(new Color(255,255,255));
        cancel.setBackground(new Color(255, 102, 102));
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(320,350,180,35);
        cancel.addActionListener(this);
        add(cancel);

        // ***************************************************** ImageIcon

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/log.png"));
        Image i2 = i.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,90, 300,300);
        add(image);

        // **********************************************************

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == login){
            String user = usr.getText();
            String passw = pass.getText();

            try{

                Conn c = new Conn();

                String query = "SELECT * from login where username = '" + user + "' AND password = '" + passw + "';";
                
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }

        if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new loginH();
    }
}
