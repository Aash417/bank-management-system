package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;

    @SuppressWarnings("LeakingThisInConstructor")
    Withdrawl() {

        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Withdraw");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (5 * x);
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "Withdraw");
        // lable
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));

        l2 = new JLabel("TO WITHDRAW");
        l2.setFont(new Font("System", Font.BOLD, 35));

        l3 = new JLabel("Enter Pin");
        l3.setFont(new Font("System", Font.BOLD, 14));
        // textfeild
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        // button
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null);

        l3.setBounds(500, 10, 80, 30);
        add(l3);

        t2.setBounds(580, 10, 40, 30);
        add(t2);

        l1.setBounds(80, 150, 800, 60);
        add(l1);

        l2.setBounds(220, 210, 800, 60);
        add(l2);

        t1.setBounds(180, 300, 300, 50);
        add(t1);

        b1.setBounds(190, 380, 140, 50);
        add(b1);

        b2.setBounds(345, 380, 125, 50);
        add(b2);

        b3.setBounds(230, 550, 200, 50);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(650, 700);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void actionPerformed(ActionEvent ae) {

        try {
            String a = t1.getText();
            String b = t2.getText();

            if (ae.getSource() == b1) {

                if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Pin");
                } else {

                    if (t1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                    } else {

                        conn c1 = new conn();
                        ResultSet rs = c1.s.executeQuery(" select balance from bank where pin = ' " + b + " ' ");

                        if (rs.next()) {

                            double oldbal = rs.getDouble("balance");

                            double newbal = oldbal - Double.parseDouble(a);

                            String q1 = "update bank set balance = '" + newbal + "' where pin = '" + b + "' ";

                            c1.s.executeUpdate(q1);
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Rs. " + a + " Debited Successfully");

                    new Transactions().setVisible(true);
                    setVisible(false);
                }
            } else if (ae.getSource() == b2) {

                new Transactions().setVisible(true);
                setVisible(false);

            } else if (ae.getSource() == b3) {

                System.exit(0);

            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

    }

    public static void main(String[] args) {
        new Withdrawl().setVisible(true);
    }

}