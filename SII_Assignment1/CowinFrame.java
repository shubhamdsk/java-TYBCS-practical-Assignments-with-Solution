
/**
 * @author:Shubham deshmukh
 * 
 * Frame for cowin Registration..
 */

import javax.swing.*;
import java.awt.*;

public class CowinFrame extends JFrame
{
	JTextField adhar, byear, phone, hosp;
	JPanel p1, p2, p3, p4;
	JButton add, update, delete, view, search;
	JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
	JComboBox hos;
	String s[] = { "Tambe Hospital", "Daima Hospital", "Nighute Hospital" };


	CowinFrame() {
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
		r2 = new JRadioButton("45 & above");
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
		r4 = new JRadioButton("Covaxin");
		p2.add(r4);
		r5 = new JRadioButton("Sputnik V");
		p2.add(r5);
		add(p2);

		// TimeSlot Radio Button
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		JLabel Time = new JLabel("Time Slot : : ");
		add(Time);
		r6 = new JRadioButton("Morning");
		p3.add(r6);
		r7 = new JRadioButton("Afternoon");
		p3.add(r7);
		r8 = new JRadioButton("Evening");
		p3.add(r8);
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
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new CowinFrame();
	}// MAIN

}// CLASS
