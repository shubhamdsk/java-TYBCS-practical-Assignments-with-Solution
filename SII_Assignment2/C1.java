//SET C
// a) Create a java application to store city names and their STD codes using an
// appropriate collection. The GUI should allow the following operations:
// i. Add a new city and its code (No duplicates)
// ii. Remove a city from the collection
// iii. Search for a city name and display the code

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class C1 extends JFrame implements ActionListener {
    JTextField txtname, txtstd;
    JButton btnadd, btnupdate, btnsearch;
    JPanel p1;
    JFrame j1;
    Hashtable<String, String> table = new Hashtable<>();

    C1() {
        setTitle("Student Information");
        setSize(700, 550);
        setVisible(true);
        setLayout(new GridLayout(4, 2, 20, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("Enter City Name: ");
        add(name);
        txtname = new JTextField(10);
        add(txtname);

        JLabel stdcode = new JLabel("Enter STD Code: ");
        add(stdcode);
        txtstd = new JTextField(10);
        add(txtstd);

        JLabel op = new JLabel("Choose Operation: ");
        add(op);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        btnadd = new JButton("Add");
        p1.add(btnadd);
        btnadd.addActionListener(this);

        btnupdate = new JButton("Update");
        p1.add(btnupdate);
        btnupdate.addActionListener(this);

        btnsearch = new JButton("Search");
        p1.add(btnsearch);
        btnsearch.addActionListener(this);

        add(p1);

    }// SETC1

    public void actionPerformed(ActionEvent ae) {

        String name = (txtname.getText());
        String std = (txtstd.getText());

        if (ae.getSource() == btnadd) {
            if (table.containsKey(name) || table.containsKey(std)) {
                JOptionPane.showMessageDialog(null, "Duplicate values are not allowed", std,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                table.put(name, std);
                System.out.println(table);
                JOptionPane.showMessageDialog(null, "Succesfully Added City STD Code", std,
                JOptionPane.INFORMATION_MESSAGE); 
            }
            txtname.setText("");
            txtstd.setText("");
        }
        if (ae.getSource() == btnupdate) {

            table.put(name, std);
            JOptionPane.showMessageDialog(null, "Succesfully Updated City STD Code", name,
                    JOptionPane.INFORMATION_MESSAGE);

            txtname.setText("");
            txtstd.setText("");
        }

        if (ae.getSource() == btnsearch) {
            String s1 = JOptionPane.showInputDialog(null, "Enter City");

            if (table.containsKey(s1)) {
                String s2 = "STD Code: " + table.get(s1);
                JOptionPane.showMessageDialog(null, s2);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR OCCURED");

            }
        }
    }
        public static void main(String[] args) {
        new C1();
    }
}