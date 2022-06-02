
/**
 * @author shubham Deshmukh
 * 
 * a) Create a PROJECT table with fields project_id, Project_name, Project_description, Project_Status. etc. Insert values in the table. Display all the details of the PROJECT table in a tabular format on the screen.(using swing).
 *
 * This program is only for display the records...
 * 
*for database material use here project.pgsql file
 */

	import java.sql.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.awt.*;
	import javax.swing.table.DefaultTableModel;

	public class StudentprojectDisplay  extends JFrame implements ActionListener
	{
	Connection con;
	ResultSet rs;
	Statement st;

	static JTable table;
	String[] columnNames={"p_id","p_name","p_description","p_status"};
	JFrame frm;
	JPanel p1;
	String p_id = "",p_name = "",p_description = "",p_status = "";

	JTextField txtid,txtname,txtdesc,textstatus;
	JButton b1,b2,b3,b4;

	StudentprojectDisplay(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("STUDENT PROJECT INFO");
	p1=new JPanel();

	p1.setLayout(new GridLayout(5,5,10,10));

	Label l1 = new Label("P-ID");
	p1.add(l1);
	txtid = new JTextField(20);
	p1.add(txtid);

	Label l2 = new Label("P-NAME");
	p1.add(l2);
	txtname = new JTextField(20);
	p1.add(txtname);

	Label l3 = new Label("P-DESCRIPTION");
	p1.add(l3);
	txtdesc = new JTextField(20);
	p1.add(txtdesc);

	Label l4 = new Label("P-STATUS");
	p1.add(l4);
	textstatus = new JTextField(20);
	p1.add(textstatus);

	b1 = new JButton("Display");
	p1.add(b1);

	b1.addActionListener(this);

	add(p1,BorderLayout.WEST);

	setVisible(true);
	setSize(400,400);

	}//ProjectDetails()
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==b1)//display
	{
	frm = new JFrame("Display");
	frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frm.setLayout(new BorderLayout());
	DefaultTableModel model = new DefaultTableModel();

	model.setColumnIdentifiers(columnNames);
	table = new JTable();

	table.setModel(model);

	JScrollPane scroll = new JScrollPane(table);
	        
	       try{
	                Class.forName("org.postgresql.Driver");
											// Use database name & password according to your "dbname","pass"
					con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
																						
	                st = con.createStatement();
	                rs = st.executeQuery("select * from project");
	                
	                while(rs.next()){
	                p_id = rs.getString(1);
	                p_name = rs.getString(2);
	                p_description = rs.getString(3);
					p_status = rs.getString(4);
					
					// 		This all coloumn names are taken from project table.
	                model.addRow(new Object[]{p_id,p_name,p_description,p_status});
	                
	                
	                }//while
	                frm.add(scroll);
	                
	                frm.setVisible(true);
	                frm.setSize(400,400);
	       }//try
	       
	       catch(Exception e){
	       JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
	       }
	}//if
	}

	public static void main(String args[])
	{
		 new StudentprojectDisplay();
	}//main
	}//class
