import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class C1 extends JFrame implements ActionListener {
    JPanel panel = new JPanel();

    JLabel title_lbl = new JLabel("Traffic Light");

    JRadioButton rb1 = new JRadioButton("Red");
    JRadioButton rb2 = new JRadioButton("Yellow");
    JRadioButton rb3 = new JRadioButton("Green");

    JButton ok_btn = new JButton("OK");

    ButtonGroup g1 = new ButtonGroup();

    JLabel red;
    JLabel yellow;
    JLabel green;

    C1() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(800, 700);
        setTitle("Java Project Program");

        setLocation(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        red = new JLabel("STOP");
        red.setForeground(Color.red);
        yellow = new JLabel("READY");
        yellow.setForeground(Color.yellow);
        green = new JLabel("GO");
        green.setForeground(Color.green);

        panel.setPreferredSize(new Dimension(500, 400));
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);

        title_lbl.setBounds(200, 0, 200, 100);
        panel.add(title_lbl);

        rb1.setBounds(100, 210, 100, 20);
        panel.add(rb1);
        rb2.setBounds(200, 210, 100, 20);
        panel.add(rb2);
        rb3.setBounds(300, 210, 100, 20);
        panel.add(rb3);

        ok_btn.setBounds(200, 310, 100, 50);
        panel.add(ok_btn);
        ok_btn.addActionListener(this);

        red.setBounds(220, 110, 100, 50);
        yellow.setBounds(220, 110, 100, 50);
        green.setBounds(220, 110, 100, 50);

        rb1.setForeground(Color.red);
        rb2.setForeground(Color.yellow);
        rb3.setForeground(Color.green);

        rb1.setBackground(Color.lightGray);
        rb2.setBackground(Color.lightGray);
        rb3.setBackground(Color.lightGray);

        red.setFont(new Font("Arial", Font.BOLD, 20));
        yellow.setFont(new Font("Arial", Font.BOLD, 20));
        green.setFont(new Font("Arial", Font.BOLD, 20));
        title_lbl.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(red);
        panel.add(yellow);
        panel.add(green);

        red.setVisible(false);
        yellow.setVisible(false);
        green.setVisible(false);

        g1.add(rb1);
        g1.add(rb2);
        g1.add(rb3);

        this.add(panel);
        this.pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok_btn) {
            if (rb1.isSelected()) {
                yellow.setVisible(false);
                green.setVisible(false);
                red.setVisible(true);
            } else if (rb2.isSelected()) {
                red.setVisible(false);
                green.setVisible(false);
                yellow.setVisible(true);
            }
            if (rb3.isSelected()) {
                red.setVisible(false);
                yellow.setVisible(false);
                green.setVisible(true);
            }
        }
    }

    public static void main(String args[]) {
        new C1();

    }
}