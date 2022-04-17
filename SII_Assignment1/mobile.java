// Set B
// a) Create a MOBILE table with fields Model_Number, Model_Name, Model_Color,
// Sim_Type, ProcessorType. Insert values in the table. Write a menu driven program to pass the
// input using Command line argument to perform the following operations on MOBILE
// table. 1. Insert 2. Modify 3. Delete 4. Search 5. View All 6. Exit

import java.sql.*;
import java.util.*;

public class mobile {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            Scanner sc = new Scanner(System.in);
            System.out.println("\nMOBILE\n");
            System.out.println("1.Insert \n2.Modify\n3.Delete\n4.Search \n5.View All\n6Exit");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    pstmt = conn.prepareStatement("insert into mobile values(?,?,?,?,?,?,?,?)");

                    System.out.println("Enter Model_Number: ");
                    int mno = sc.nextInt();
                    pstmt.setInt(1, mno);

                    sc.nextLine();
                    System.out.println("Enter Model_Name: ");
                    String name = sc.nextLine();
                    pstmt.setString(2, name);

                    System.out.println("Enter Model_Color: ");
                    String color = sc.nextLine();
                    pstmt.setString(3, color);

                    System.out.println("Enter Sim_Type: ");
                    String sim = sc.nextLine();
                    pstmt.setString(4, sim);

                    System.out.println("Enter BatteryCapacity: ");
                    int Battery = sc.nextInt();
                    pstmt.setInt(5, Battery);
                    

                    System.out.println("Enter InternalStorage In GB: ");
                    int internal = sc.nextInt();
                    pstmt.setInt(6, internal);

                    System.out.println("Enter RAM In GB: ");
                    int ram = sc.nextInt();
                    pstmt.setInt(7, ram);

                    System.out.println("Enter Processor_Type: ");
                    String pr = sc.nextLine();
                    pstmt.setString(8, pr);

                    int result = pstmt.executeUpdate();
                    System.out.println(result + " Record Inserted");
                    break;

                case 2:
                    String SQL = "update student set=? where mno=?";
                    pstmt = conn.prepareStatement(SQL);
                    System.out.println("Enter Model No for Update Record: ");
                    int no = sc.nextInt();
                    pstmt.setInt(1, no);

                    System.out.println("Enter Updated Model name: ");
                    String mname = sc.nextLine();
                    pstmt.setString(2, mname);

                    pstmt.executeUpdate();
                    break;

                case 3:
                    pstmt = conn.prepareStatement("delete from mobile where mno=?");
                    System.out.println("Enter Model No for Delete Record: ");
                    int model = sc.nextInt();
                    pstmt.setInt(1, model);
                    pstmt.executeUpdate();
                    break;

                case 4:
                    pstmt = conn.prepareStatement("select * from mobile where mno=?");
                    System.out.println("Enter Model No for serach Record: ");
                    int m = sc.nextInt();
                    pstmt.setInt(1, m);
                    pstmt.executeQuery();
                    break;

                case 5:
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from student");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
                                + rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t" + rs.getInt(7)
                                + "\t" + rs.getString(8));
                    } // while

                    break;
            }
            pstmt.close();
            conn.close();

        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }// main
}// class