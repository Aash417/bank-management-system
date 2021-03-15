package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel l1;
    JButton b1, b2, b5, b6, b7;

    @SuppressWarnings("LeakingThisInConstructor")
    Transactions() {

        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("TRANSACTION");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3 * x);
        int w = z / y;
        String pad = "";

        pad = String.format("%" + w + "s", pad);
        setTitle(pad + "TRANSACTION");

        l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 38));

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);

        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);

        setLayout(null);

        l1.setBounds(100, 100, 700, 40);
        add(l1);

        b1.setBounds(40, 250, 300, 60);
        add(b1);

        b2.setBounds(440, 250, 300, 60);
        add(b2);

        b5.setBounds(40, 360, 300, 60);
        add(b5);

        b6.setBounds(440, 360, 300, 60);
        add(b6);

        b7.setBounds(240, 600, 300, 60);
        add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);

        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(790, 750);
        setLocation(300, 10);
        setVisible(true);

    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            new Deposit().setVisible(true);
            setVisible(false);

        } else if (ae.getSource() == b2) {

            new Withdrawl().setVisible(true);
            setVisible(false);

        } else if (ae.getSource() == b5) {

            new Pin().setVisible(true);
            setVisible(false);

        } else if (ae.getSource() == b6) {

            String pinn = JOptionPane.showInputDialog("Enter PIN");

            if (pinn == null) {
                JOptionPane.showInputDialog("Enter PIN First");
            } else {
                conn c1 = new conn();

                try {

                    ResultSet rs = c1.s.executeQuery(" SELECT balance FROM bank where pin  = '" + pinn + "' ");

                    if (rs.next()) {

                        String balance = rs.getString("balance");

                        JOptionPane.showMessageDialog(null, "Your Account Balance is " + balance);

                    } else {
                        JOptionPane.showMessageDialog(null, "Your Don't Have An Account  ");
                    }

                } catch (Exception e) {
                    System.out.println("Error :" + e);
                }
            }
        } else if (ae.getSource() == b7) {

            System.exit(0);

        }

    }

    public static void main(String[] args) {
        new Transactions().setVisible(true);
    }
}
