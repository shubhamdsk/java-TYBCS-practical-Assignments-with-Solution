
/**
 * @author:Shubham deshmukh
 * 
 * SET B) b. Design a following Registration form and raise an appropriate exception if invalid information is entered like Birth Year '0000'
 * 
 *  *
 *for database material use here cowin.pgsql file
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InvalidBirthDateException extends Exception {

	String msg = "Invalid Date Exception\n";

	public String toString() {
		return msg;
	}

}

public class Cowin extends JFrame implements ActionListener {
	JTextField adhar, byear, phone, hosp;
	JPanel p1, p2, p3, p4;
	JButton add, update, delete, view, search;
	JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
	ButtonGroup bg,bg1,bg2;
	JComboBox hos;
	String s[] = { "Tambe Hospital", "Daima Hospital", "Nighute Hospital" };

	Cowin() {
		setTitle("Cowin Registration");

		setSize(800, 600);

		setLayout(new GridLayout(8, 2, 40, 40));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel adharno = new JLabel("Adhar Card Number: ");
		add(adharno);
		adhar = new JTextField(10);
		add(adhar);

		JLabel Byear = new JLabel("Birth Year: ");
		add(Byear);
		byear = new JTextField(10);
		add(byear);

		JLabel phoneNo = new JLabel("Mobile Number: ");
		add(phoneNo);
		phone = new JTextField(10);
		add(phone);

		// Age Radio Button
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());

		JLabel Age = new JLabel("Age Group : ");
		add(Age);
		
		r1 = new JRadioButton("18 & above");
		p1.add(r1);
		// to get the value of radio button
		r1.setActionCommand("18 & above");

		r2 = new JRadioButton("45 & above");
		r2.setActionCommand("45 & above");
		p1.add(r2);
		add(p1);

		JLabel hospital = new JLabel("Select Hospital: ");
		add(hospital);

		hos = new JComboBox(s);
		add(hos);

		// Vaccines Radio Button
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());

		JLabel Vaccines = new JLabel("Vaccines : : ");
		add(Vaccines);

		r3 = new JRadioButton("Covishield");
		p2.add(r3);
		r3.setActionCommand("Covishield");

		r4 = new JRadioButton("Covaxin");
		p2.add(r4);
		r4.setActionCommand("Covaxin");

		r5 = new JRadioButton("Sputnik V");
		p2.add(r5);
		r5.setActionCommand("SputnikV");
		add(p2);

		// TimeSlot Radio Button
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		JLabel Time = new JLabel("Time Slot :: ");
		add(Time);
		r6 = new JRadioButton("Morning");
		p3.add(r6);
		r6.setActionCommand("Morning");

		r7 = new JRadioButton("Afternoon");
		p3.add(r7);
		r7.setActionCommand("Afternoon");

		r8 = new JRadioButton("Evening");
		p3.add(r8);
		r8.setActionCommand("Evening");

		add(p3);

		// Button
		p4 = new JPanel();
		p4.setLayout(new FlowLayout());

		add = new JButton("Add");
		p4.add(add);
		update = new JButton("Update");
		p4.add(update);
		delete = new JButton("Delete");
		p4.add(delete);
		view = new JButton("View");
		p4.add(view);
		search = new JButton("Search");
		p4.add(search);
		add(p4);

		add.addActionListener(this);

		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		bg1 = new ButtonGroup();
		bg1.add(r4);
		bg1.add(r3);
		bg1.add(r5);

		bg2 = new ButtonGroup();
		bg2.add(r6);
		bg2.add(r7);
		bg2.add(r8);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {

			String adharno = (adhar.getText());
			int year = Integer.parseInt(byear.getText());
			String phNo = (phone.getText());
			String hospital = (String) (hos.getSelectedItem());
			String age=bg.getSelection().getActionCommand();
			String vaccine=bg1.getSelection().getActionCommand();
			String timestamp=bg2.getSelection().getActionCommand();


			try {
				if (year == 0000) {
					throw new InvalidBirthDateException();
				} else {
					Connection conn = null;
					PreparedStatement pstmt = null;
					try {
						// load a driver
						Class.forName("org.postgresql.Driver");

						// Establish Connection
					   // Use database name & password according to your "dbname","pass"
						conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
						pstmt = conn.prepareStatement("insert into cowin values(?,?,?,?,?,?,?)");

						pstmt.setString(1, adharno);
						pstmt.setInt(2, year);
						pstmt.setString(3, phNo);
						pstmt.setString(4, hospital);
						pstmt.setString(5, age);
						pstmt.setString(6, vaccine);
						pstmt.setString(7, timestamp);

						int result = pstmt.executeUpdate();
						if (result == 1) {

							JOptionPane.showMessageDialog(null, "Succesfully Inserted", hospital,
									JOptionPane.INFORMATION_MESSAGE);
						}

						pstmt.close();
						conn.close();

					} // try
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e, "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
					} // catch
				}
			} catch (InvalidBirthDateException e) {
				JOptionPane.showMessageDialog(null, e, "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new Cowin();
	}// MAIN

}// CLASS