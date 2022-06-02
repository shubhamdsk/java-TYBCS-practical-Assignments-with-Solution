
/**
 * @author:Shubham deshmukh
 * 
 * a) Create tables : Course (courseid, coursename, courseinstructor) and Student
    (studentid, studentname, studentclass). Course and Student have a many to many
    relationship. Create a GUI based system for performing the following operations on
    the tables:
    Course : Add Course, View All students of a specific course
    Student : Add Student, Delete Student, View All students, Search student.

 *   for database material use here student_course.pgsql file
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;

public class Student_Course extends JFrame implements ActionListener {

    JButton addstd, Delete, View, Search, addcourse, course;
    JPanel p1, p2;
    Connection con;
    ResultSet rs;
    Statement st;
    PreparedStatement pstmt = null;

    AddStudent stdobj;
    Addcourse cobj;

    static JTable table;
    String s_id = "", s_name = "", s_class = "";
    
    String st_name = "";

    String[] columnNames = { "s_id ", "s_name ", "s_class " };
    String[] SC_columns = { "st_name "};
    JFrame frm,frmdisp;

    Student_Course() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENT INFO");
        setLayout(new GridLayout(4, 4, 40, 20));
        setVisible(true);
        setSize(400, 400);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());

        JLabel std = new JLabel("Student   : ");
        add(std);

        addstd = new JButton("Add");
        p1.add(addstd);

        Delete = new JButton("Delete");
        p1.add(Delete);

        View = new JButton("View All");
        p1.add(View);

        Search = new JButton("Search");
        p1.add(Search);

        add(p1);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        JLabel sub = new JLabel("Course  : ");
        add(sub);

        addcourse = new JButton("Add");
        p2.add(addcourse);

        course = new JButton("View ");
        p2.add(course);

        add(p2);
        // adding action listener to all buttons
        addstd.addActionListener(this);
        addcourse.addActionListener(this);
        Delete.addActionListener(this);
        View.addActionListener(this);
        Search.addActionListener(this);
        course.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            Class.forName("org.postgresql.Driver");
            // Use database name & password according to your "dbname","pass"
            con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            if (ae.getSource() == View) {
                frm = new JFrame("Student DISPLAY");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                setLayout(new BorderLayout());
                DefaultTableModel model = new DefaultTableModel();

                model.setColumnIdentifiers(columnNames);
                table = new JTable();

                table.setModel(model);

                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                table.setFillsViewportHeight(true);

                JScrollPane scroll = new JScrollPane(table);

                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                st = con.createStatement();
                rs = st.executeQuery("select * from student1");

                while (rs.next()) {
                    s_id = rs.getString(1);
                    s_name = rs.getString(2);
                    s_class = rs.getString(3);

                    // This all coloumn names are taken from project table.
                    model.addRow(new Object[] { s_id, s_name, s_class });

                } // while
                frm.add(scroll);

                frm.setVisible(true);
                frm.setSize(400, 400);

            } // view

            if (ae.getSource() == addstd) {
                stdobj = new AddStudent();
            } // adding student record

            if (ae.getSource() == Search) {
                String s1 = JOptionPane.showInputDialog(null, "Enter Student Name");

                pstmt = con.prepareStatement("select * from student1 where s_name=?");
                pstmt.setString(1, s1);
                
                rs = pstmt.executeQuery();
                while (rs.next()) {
                String result = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3);
                JOptionPane.showMessageDialog(null, result);
                }

            }

            if (ae.getSource() == Delete) {
                String s1 = JOptionPane.showInputDialog(null, "Enter Student Name ");
                pstmt = con.prepareStatement("delete from student1 where s_name=?");

                pstmt.setString(1, s1);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record deleted");

            }

            if (ae.getSource() == addcourse) {
                cobj = new Addcourse();
            } // adding course record

            if (ae.getSource() == course) {

                String s1 = JOptionPane.showInputDialog(null, "Enter course Name");

                frmdisp = new JFrame("Student course DISPLAY");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                setLayout(new BorderLayout());
                DefaultTableModel model = new DefaultTableModel();

                model.setColumnIdentifiers(SC_columns);
                table = new JTable();

                table.setModel(model);

                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                table.setFillsViewportHeight(true);

                JScrollPane scroll = new JScrollPane(table);

                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                pstmt = con.prepareStatement(
                        "select s_name from SC where c_name = ?");
                pstmt.setString(1, s1);
                
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    st_name = rs.getString(1);

                    // This all coloumn names are taken from sc table.
                    model.addRow(new Object[] { st_name});

                } // while
                frmdisp.add(scroll);
                

                frmdisp.setVisible(true);
                frmdisp.setSize(400, 400);

            }

        } // try

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        new Student_Course();
    }
}// class

class AddStudent extends JFrame implements ActionListener {
    JTextField txtroll, txtname, txtclass;
    JButton btnadd, btnclear;

    AddStudent() {
        setTitle("Student Information");

        setSize(400, 500);
        setVisible(true);
        setLayout(new GridLayout(4, 2, 40, 40));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel rollno = new JLabel("Enter Roll Number: ");
        add(rollno);
        txtroll = new JTextField(10);
        add(txtroll);

        JLabel stdname = new JLabel("Enter Student Name: ");
        add(stdname);
        txtname = new JTextField(10);
        add(txtname);

        JLabel classname = new JLabel("Enter Student Class: ");
        add(classname);
        txtclass = new JTextField(10);
        add(txtclass);

        btnadd = new JButton("Submit");
        add(btnadd);
        btnadd.addActionListener(this);

        btnclear = new JButton("Clear");
        add(btnclear);
        btnclear.addActionListener(this);

    }// constructor

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        int rn = Integer.parseInt(txtroll.getText());
        String name = (txtname.getText());
        String cname = (txtclass.getText());

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
            if (str.equals("Submit")) {
                pstmt = conn.prepareStatement("insert into student1 values(?,?,?)");

                pstmt.setInt(1, rn);
                pstmt.setString(2, name);
                pstmt.setString(3, cname);

                int result = pstmt.executeUpdate();
                System.out.println(result + "  Record Inserted");

                txtroll.setText("");
                txtname.setText("");
                txtclass.setText("");

            }
            pstmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }

}

class Addcourse extends JFrame implements ActionListener {
    JTextField txtcname, txtins, txtcno;
    JButton btnadd, btnclear;

    Addcourse() {
        setTitle("course Information");

        setSize(400, 500);
        setVisible(true);
        setLayout(new GridLayout(4, 2, 40, 40));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel cno = new JLabel("Enter Course Number: ");
        add(cno);
        txtcno = new JTextField(10);
        add(txtcno);

        JLabel cname1 = new JLabel("Enter course Name: ");
        add(cname1);
        txtcname = new JTextField(10);
        add(txtcname);

        JLabel ins = new JLabel("Enter course Instructor: ");
        add(ins);
        txtins = new JTextField(10);
        add(txtins);

        btnadd = new JButton("Submit");
        add(btnadd);
        btnadd.addActionListener(this);

        btnclear = new JButton("Clear");
        add(btnclear);
        btnclear.addActionListener(this);

    }// constructor

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        int cn = Integer.parseInt(txtcno.getText());
        String name = (txtcname.getText());
        String course = (txtins.getText());

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
            if (str.equals("Submit")) {
                pstmt = conn.prepareStatement("insert into course values(?,?,?)");
                pstmt.setInt(1, cn);
                pstmt.setString(2, name);
                pstmt.setString(3, course);

                int result = pstmt.executeUpdate();
                System.out.println(result + "  Record Inserted");

                txtcno.setText("");
                txtcname.setText("");
                txtins.setText("");

            }
            pstmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }
}