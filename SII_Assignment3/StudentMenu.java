
/**
 * @author:Shubham deshmukh
 * 
 *  Write Java Program to Insert,Update, Delete & Display the Records of Student. 
 * 
 * 
 *for database material use here student.pgsql file
 */
import java.sql.*;
import java.util.*;

public class StudentMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
										// Use database name & password according to your "dbname","pass"
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            System.out.println("\nStudent Records:\n");
            do {
                System.out
                        .println("\n\n1.Insert Record \n2.Update Record \n3.Delete Record \n4.Display Record \n5.Exit");
                System.out.println("Enter your choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        pstmt = conn.prepareStatement("insert into student values(?,?,?)");
                        System.out.println("Enter Roll Number:");
                        int r = sc.nextInt();
                        pstmt.setInt(1, r);

                        sc.nextLine();
                        System.out.println("Enter Name:");
                        String n = sc.nextLine();
                        pstmt.setString(2, n);

                        System.out.println("Enter Percentage:");
                        float p = sc.nextFloat();
                        pstmt.setFloat(3, p);

                        // Execute Query
                        int result = pstmt.executeUpdate();
                        System.out.println(result + " Record Inserted\n\n");
                        break;

                    case 2:
                        String SQL2 = "update student set per = ? where rollno=?";
                        pstmt = conn.prepareStatement(SQL2);

                        System.out.println("Enter Roll no which has to be Update: ");
                        int r1 = sc.nextInt();

                        System.out.println("Enter Percent for update:");
                        float p1 = sc.nextFloat();

                        pstmt.setInt(2, r1);
                        pstmt.setFloat(1, p1);
                        
                        int result2 = pstmt.executeUpdate();
                        System.out.println(result2 + " Record Updated\n\n");
                        break;

                    case 3:
                        String SQL3 = "delete from student where rollno =?";
                        pstmt = conn.prepareStatement(SQL3);
                        System.out.println("Enter Roll No whose record you want delete ");
                        int dl = sc.nextInt();
                        pstmt.setInt(1, dl);
                        int result3 = pstmt.executeUpdate();
                        System.out.println(result3 + " Record Deleted\n\n");
                        break;

                    case 4:
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("select * from student");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3));
                        }
                        break;

                    case 5:
                        System.exit(1);
                        rs.close();
                        stmt.close();
                        pstmt.close();
                        conn.close();

                    default:
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
