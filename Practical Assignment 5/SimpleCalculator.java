/*Set A
a) Write a java program that works as a simple calculator. Use a grid layout to arrange buttons for the digits and for the +, -, *, % operations. Add a text field to display the
result.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField txt1;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bsum, bsub, bmult, bdiv,bdot, beql;
    JPanel p1, p2;
    String opt = "", s1 = "";
    float n1, n2;
    int s2;
    int aft = 0;

    SimpleCalculator() {
        setSize(300, 300);
        setVisible(true);
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();

        p1.setLayout(new FlowLayout());

        txt1 = new JTextField(15);
        p1.add(txt1);
        p2.setLayout(new GridLayout(4, 4, 6, 6));

        b1 = new JButton("1");
        p2.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("2");
        p2.add(b2);
        b2.addActionListener(this);
        b3 = new JButton("3");
        p2.add(b3);
        b3.addActionListener(this);
        bsum = new JButton("+");
        p2.add(bsum);
        bsum.addActionListener(this);
        b4 = new JButton("4");
        p2.add(b4);
        b4.addActionListener(this);
        b5 = new JButton("5");
        p2.add(b5);
        b5.addActionListener(this);
        b6 = new JButton("6");
        p2.add(b6);
        bsub = new JButton("-");
        p2.add(bsub);
        bsub.addActionListener(this);
        b6.addActionListener(this);
        b7 = new JButton("7");
        p2.add(b7);
        b7.addActionListener(this);
        b8 = new JButton("8");
        p2.add(b8);
        b8.addActionListener(this);
        b9 = new JButton("9");
        p2.add(b9);
        b9.addActionListener(this);
        bmult = new JButton("*");
        p2.add(bmult);
        bmult.addActionListener(this);
        b0 = new JButton("0");
        p2.add(b0);
        b0.addActionListener(this);
        bdot = new JButton(".");
        p2.add(bdot);
        bdot.addActionListener(this);
        beql = new JButton("=");
        p2.add(beql);
        beql.addActionListener(this);
        bdiv = new JButton("/");
        p2.add(bdiv);
        bdiv.addActionListener(this);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1)
            s1 = s1 + b1.getText();
        if (e.getSource() == b2)
            s1 = s1 + b2.getText();
        if (e.getSource() == b3)
            s1 = s1 + b3.getText();
        if (e.getSource() == b4)
            s1 = s1 + b4.getText();
        if (e.getSource() == b5)
            s1 = s1 + b5.getText();
        if (e.getSource() == b6)
            s1 = s1 + b6.getText();
        if (e.getSource() == b7)
            s1 = s1 + b7.getText();
        if (e.getSource() == b8)
            s1 = s1 + b8.getText();
        if (e.getSource() == b9)
            s1 = s1 + b9.getText();
        if (e.getSource() == b0)
            s1 = s1 + b0.getText();
        if (e.getSource() == bdot)
            s1 = s1 + bdot.getText();

        txt1.setText(s1);

        if (e.getSource() == bsum) {
            opt = "+";
            txt1.setText("");
            n1 = Float.parseFloat(s1);
            s1 = "";
        }
        if (e.getSource() == beql) {
            if (opt.equals("+")) {
                n2 = Float.parseFloat(s1);
                txt1.setText((n1 + n2) + "");
                s1 = "";

            }
        } else if (e.getSource() == bsub) {
            opt = "-";
            txt1.setText("");
            n1 = Float.parseFloat(s1);
            s1 = "";
        }
        if (e.getSource() == beql) {
            if (opt.equals("-")) {
                n2 = Float.parseFloat(s1);
                txt1.setText((n1 - n2) + "");
                s1 = "";
            }
        } else if (e.getSource() == bmult) {
            opt = "*";
            txt1.setText("");
            n1 = Float.parseFloat(s1);
            s1 = "";
        }
        if (e.getSource() == beql) {
            if (opt.equals("*")) {
                n2 = Float.parseFloat(s1);
                txt1.setText((n1 * n2) + "");
                s1 = "";
            }
        }

        else if (e.getSource() == bdiv) {
            opt = "/";
            txt1.setText("");
            n1 = Float.parseFloat(s1);
            s1 = "";
        }
        if (e.getSource() == beql) {
            if (opt.equals("/")) {
                n2 = Float.parseFloat(s1);
                txt1.setText((n1 / n2) + "");
                s1 = "";
            }
        }
    }
}
