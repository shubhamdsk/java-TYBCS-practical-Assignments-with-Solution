import java.sql.*;
public class resultsetmdata{
public static void main(String[] args){
		try{
						//load a driver
				Class.forName("org.postgresql.Driver");

				//Establish Connection
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs" , "postgres" , "");
			Statement stmt = null;
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from donor");
			ResultSetMetaData rsmd = rs.getMetaData();
			int noOfColumns = rsmd.getColumnCount();
			System.out.println("\t-----------------------------------------------------------------------");
	for(int i=1;i<=noOfColumns;i++)
	{
			
			System.out.println("\t\tColumn No : "+i);
			System.out.println("\t\tColumn Name : "+rsmd.getColumnName(i));
			System.out.println("\t\tColumn Type : "+rsmd.getColumnTypeName(i));
			System.out.println("\t\tColumn Display Size : "+rsmd.getColumnDisplaySize(i));
	}//for
			System.out.println("\t---------------------------------------------------------------------");

			rs.close();
			stmt.close();
			conn.close();
				}//try
					catch(Exception e)
					{
						System.out.println(e);
					}//catch
			}//main
			}//metadata
