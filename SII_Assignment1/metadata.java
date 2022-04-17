
/**
 * @author : Shubham Deshmukh
 * 
 * b) Write a program to display information about the database and list all the tables in the database. (Use DatabaseMetaData).
 */

import java.sql.*;

public class Metadata {
	public static void main(String[] args) {
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("\t-----------------------------------------------------------------------");
			System.out.println("\t\tDriver Name : " + dbmd.getDriverName());
			System.out.println("\t\tDriver Version : " + dbmd.getDriverVersion());
			System.out.println("\t\tUserName : " + dbmd.getUserName());
			System.out.println("\t\tDatabase Product Name : " + dbmd.getDatabaseProductName());
			System.out.println("\t\tDatabase Product Version : " + dbmd.getDatabaseProductVersion());
			System.out.println("\t---------------------------------------------------------------------");

			String table[] = { "TABLE" };
			ResultSet rs = dbmd.getTables(null, null, null, table);
			System.out.println("\t\tTable Names:");

			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			rs.close();
			conn.close();
		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// metadata
