
/**
 * @author shubham Deshmukh
 * 
 * C].Write a program to display information about all coumns in the DONOR table using 
**/

import java.sql.*;
public class DONOR {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            // Use database name & password according to your "dbname","pass"
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            Statement stmt = null;
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from donor");
            ResultSetMetaData rsmd = rs.getMetaData();

            int n = rsmd.getColumnCount();

            for (int i = 1; i < n; i++) {
                System.out.println("Column No :" + i);
                System.out.println("Column Name : " + rsmd.getColumnName(i));
                System.out.println("Column Type : " + rsmd.getColumnTypeName(i));
                System.out.println("Column Display Size : " + rsmd.getColumnDisplaySize(i));

            } // for

            rs.close();
            stmt.close();
            conn.close();

        } // try
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
