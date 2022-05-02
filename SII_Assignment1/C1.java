// Java Program to Implement Traffic signal
// Using Java Swing Components

// Importing required classes
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// Main class
// Extending JFrame class and
// Implementing ItemListener interface
public class C1
	extends JFrame implements ItemListener {

	// Setting the buttons for the layout
	JRadioButton jr1;
	JRadioButton jr2;
	JRadioButton jr3;

	// Setting the field area
	JTextField j1 = new JTextField(10);
	ButtonGroup b = new ButtonGroup();
	String msg = " ";

	// Initially setting the co-ordinates to 0,0,0
	int x = 0, y = 0, z = 0;
	public C1(String msg)
	{
		super(msg);
		setLayout(new FlowLayout());

		// Assigning name to the button declared above
		// with help of JRadioButton class
		jr1 = new JRadioButton("Red");
		jr2 = new JRadioButton("Yellow");
		jr3 = new JRadioButton("Green");

		jr1.addItemListener(this);
		jr2.addItemListener(this);
		jr3.addItemListener(this);

		add(jr1);
		add(jr2);
		add(jr3);
		b.add(jr1);
		b.add(jr2);
		b.add(jr3);
		add(j1);

		// Method 1
		// To add a window
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				// It haults here itself
				System.exit(0);
			}
		});
	}

	// Method 2
	// To change colors of traffic signal
	public void itemStateChanged(ItemEvent ie)
	{
		// If it is red
		if (ie.getSource() == jr1) {
			if (ie.getStateChange() == 1) {

				// Then display message- Stop
				msg = "Stop!";
				x = 1;

				// Repainting the box with original one
				// Practically black
				repaint();
			}
			else {
				msg = "";
			}
		}

		// If state is Orange or technically jr2
		if (ie.getSource() == jr2) {
			if (ie.getStateChange() == 1) {

				// Then display message-
				// Get ready in waiting state
				msg = "Get Ready to go!";
				y = 1;

				// Again repainting the button
				repaint();
			}
			else {
				msg = "";
			}
		}

		// If state is Green
		if (ie.getSource() == jr3) {
			if (ie.getStateChange() == 1) {

				// Then display message- Go
				msg = "Go!!";
				z = 1;
				repaint();
			}
			else {
				msg = "";
			}
		}
		j1.setText(msg);
	}

	// Method 3
	// handling the paint graphics and
	// dimensions of the buttons via
	// setting co-ordinates
	public void paint(Graphics g)
	{
		g.drawRect(100, 105, 110, 270);
		g.drawOval(120, 150, 60, 60);
		g.drawOval(120, 230, 60, 60);
		g.drawOval(120, 300, 60, 60);

		// Case: Red
		if (x == 1) {
			g.setColor(Color.RED);
			g.fillOval(120, 150, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(120, 230, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(120, 300, 60, 60);
			x = 0;
		}

		// Case: Orange
		if (y == 1) {
			g.setColor(Color.WHITE);
			g.fillOval(120, 150, 60, 60);
			g.setColor(Color.YELLOW);
			g.fillOval(120, 230, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(120, 300, 60, 60);
			y = 0;
		}

		// Case: Green
		if (z == 1) {
			g.setColor(Color.WHITE);
			g.fillOval(120, 150, 60, 60);
			g.setColor(Color.WHITE);
			g.fillOval(120, 230, 60, 60);
			g.setColor(Color.GREEN);
			g.fillOval(120, 300, 60, 60);
			z = 0;
		}
	}

	// Method 4
	// Main driver method
	public static void main(String args[])
	{
		// Creating object of Jframe class inside main()
		// method
		JFrame jf = new C1("Traffic Light");

		// Setting size and making traffic signal
		// operational using setVisible() method
		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}
