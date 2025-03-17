import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class search_Room extends JFrame implements ActionListener {

    JComboBox RBT_Box;
    JCheckBox od_aval;
    JTable table;
    JButton submit, Back;

    search_Room() {

        setTitle("Add Employee");
        setLayout(null);
        setLocationRelativeTo(null);

        // ******************************************************* JLabel

        JLabel text = new JLabel("Search For Room");
        text.setBounds(420, 20, 200, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JLabel RBT = new JLabel("Room Bed Type");
        RBT.setBounds(50, 90, 200, 30);
        RBT.setFont(new Font("Osward", Font.BOLD, 13));
        add(RBT);

        JLabel RN = new JLabel("<html><u>Room Number</u></html>");
        RN.setBounds(100, 155, 100, 20);
        RN.setFont(new Font("Ariel", Font.BOLD, 13));
        add(RN);

        JLabel ava = new JLabel("<html><u>Availability</u></html>");
        ava.setBounds(290, 155, 100, 20);
        ava.setFont(new Font("Raleway", Font.BOLD, 13));
        add(ava);

        JLabel cs = new JLabel("<html><u>Cleaning Status</u></html>");
        cs.setBounds(450, 155, 150, 20);
        cs.setFont(new Font("Raleway", Font.BOLD, 13));
        add(cs);

        JLabel pc = new JLabel("<html><u>Price</u></html>");
        pc.setBounds(660, 155, 40, 20);
        pc.setFont(new Font("Raleway", Font.BOLD, 13));
        add(pc);

        JLabel BT = new JLabel("<html><u>Bed Type</u><html>");
        BT.setBounds(830, 155, 70, 20);
        BT.setFont(new Font("Raleway", Font.BOLD, 13));
        add(BT);

        // ******************************************************* JComboBox

        String rbt_Val[] = { "Single Bed", "Double Bed" };
        RBT_Box = new JComboBox(rbt_Val);
        RBT_Box.setBounds(170, 95, 150, 22);
        RBT_Box.setFont(new Font("Raleway", Font.PLAIN, 13));
        RBT_Box.setSelectedItem(null);
        RBT_Box.setBackground(Color.WHITE);
        RBT_Box.setBorder(BorderFactory.createEmptyBorder());
        RBT_Box.addActionListener(this);
        add(RBT_Box);

        // ******************************************************* JComboBox

        od_aval = new JCheckBox("Only Display Available");
        od_aval.setBounds(700, 95, 200, 22);
        od_aval.setFont(new Font("Raleway", Font.BOLD, 13));
        od_aval.setBackground(Color.WHITE);
        // od_aval.setBorder(BorderFactory.createEmptyBorder());
        add(od_aval);

        // ******************************************************* JButton

        Back = new JButton("Back");
        Back.setBounds(800, 430, 150, 30);
        Back.setFocusable(false);
        Back.setFont(new Font("Osward", Font.BOLD, 15));
        Back.setBorder(BorderFactory.createEmptyBorder());
        // Back.setForeground(new Color(255, 255, 255));
        Back.setBackground(new Color(255, 102, 102));
        Back.addActionListener(this);
        add(Back);

        // submit = new JButton("Submit");
        // submit.setBounds(550, 430, 150, 30);
        // submit.setFocusable(false);
        // submit.setFont(new Font("Osward", Font.BOLD, 14));
        // submit.setBorder(BorderFactory.createEmptyBorder());
        // submit.setForeground(new Color(0, 153, 76));
        // submit.setBackground(new Color(102, 255, 178));
        // submit.addActionListener(this);
        // add(submit);

        // ******************************************************* JComboBox

        table = new JTable();
        table.setBounds(50, 190, 900, 400);
        table.setFont(new Font("Raleway", Font.PLAIN, 13));
        add(table);

        // try {

        // String query = "Select * from add_room order by RoomNum ASC;";
        // Conn c = new Conn();
        // ResultSet rs = c.s.executeQuery(query);
        // table.setModel(DbUtils.resultSetToTableModel(rs));

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // **************************************************************

        setVisible(true);
        // setExtendedState(MAXIMIZED_BOTH);
        setBounds(140, 180, 1000, 550);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Back) {
            setVisible(false);
            new reception().setVisible(true);
        }

        else if (ae.getSource() == RBT_Box || od_aval.isSelected()) {
            // If the submit button or JComboBox is selected

            String bd_T = (String) RBT_Box.getSelectedItem();

            try {
                String query;
                if (od_aval.isSelected()) {
                    query = "SELECT * FROM add_room WHERE bed_Type = '" + bd_T
                            + "' AND Available = 'Available' ORDER BY RoomNum ASC;";
                } else {
                    query = "SELECT * FROM add_room WHERE bed_Type = '" + bd_T + "' ORDER BY RoomNum ASC;";
                }

                System.out.println("SQL Query: " + query);

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

    }

    public static void main(String[] args) {
        new search_Room();
    }
}
