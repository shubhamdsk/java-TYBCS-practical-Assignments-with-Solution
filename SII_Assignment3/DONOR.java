/**
 * @author shubham Deshmukh
 * 
 * C].Write a program to display information about all coumns in the DONOR table using ResultSetMetaData.
 * 
 *for database material use here donor.pgsql file
**/

import java.sql.*;

public class DONOR {
    public static void main(String[] args) {
        try {
            // load a driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donor");

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("\t-------------------------------------------------");

            int count = rsmd.getColumnCount();
            System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
            System.out.println("\t-------------------------------------------------");
            for (int i = 1; i <= count; i++) 
            {
                System.out.println("\t\tColumn No : " + i);
                System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
                System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
                System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
                System.out.println();
            } // for
            System.out.println("\t--------------------------------------------------");

            rs.close();
            stmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }
}
