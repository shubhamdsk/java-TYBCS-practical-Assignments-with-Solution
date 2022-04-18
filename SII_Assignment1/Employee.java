/**
 * 
 * @author:Shubham Deshmukh
 *  
 * b) Create the following tables and relations, for an INVESTMENT firm EMP(empid,empname, empaddress, empcontact, 			empage) INVESTOR(invno, invname , invdate, invamt) An employee may invest in one or more investments, hence he can 		be an investor. But an investor need not be an employee of the firm. Insert sufficient number of records in the 		relations / tables with appropriate values.
	i. Display the List the distinct names of person who are either employees, or investors or both.
	ii. List the names of employees who are not investors
 *
 * for database material use here employee.pgsql file
 */


import java.sql.*;

public class Employee {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// load a driver
			Class.forName("org.postgresql.Driver");

			// Establish Connection
			conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "dsk");

			// create statement and execute queries
			stmt = conn.createStatement();

			System.out.println("\n---------------");
			System.out.println("Employees");
			System.out.println("---------------");
			rs = stmt.executeQuery("select empname from employee ");
			while (rs.next()) {
				System.out.println(rs.getString("empname"));
			} // while
			System.out.println("---------------");
			
			System.out.println("\n---------------");
			System.out.println("Investors");
			System.out.println("---------------");
			rs = stmt.executeQuery("select invname from investor ");
			while (rs.next()) {
				System.out.println(rs.getString("invname"));
			} // while

			System.out.println("---------------");
			System.out.println(
					"\n------------------------------------------------------------------------------------------");
			System.out.println(
					"Display the List the distinct names of person who are either employees or investor or both");
			System.out.println(
					"------------------------------------------------------------------------------------------");
			rs = stmt.executeQuery("select empname from employee union select invname from investor");
			while (rs.next()) {
				System.out.println(rs.getString("empname"));
			} // while
			System.out.println("---------------");

			System.out.println("\n--------------------------------------------------");
			System.out.println("List the names of Employees who are not Investors");
			System.out.println("--------------------------------------------------");
			rs = stmt.executeQuery("select empname from employee except select invname from investor");
			while (rs.next()) {
				System.out.println(rs.getString("empname"));
			} // while
			System.out.println("---------------");
			
			// close resultset,stmt & connection Object
			rs.close();
			stmt.close();
			conn.close();

		} // try
		catch (Exception e) {
			System.out.println(e);
		} // catch
	}// main
}// class
