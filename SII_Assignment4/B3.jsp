<!DOCTYPE html>
<html>

<body>
    <%@ page import="java.sql.*;" %>
        <%! int pno,age; 
        String pname,address,diease; %>
            <% try {
                Class.forName("org.postgresql.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:postgresql:postgres","postgres", " ");
                Statement st=cn.createStatement();
                ResultSetrs=st.executeQuery("select * from Patient");
                 %>
                <table border="1" width="40%">
                    <tr>
                        <td>Patient No</td>
                        <td>Name</td>
                        <td>Age</td>
                        <td>Address</td
                        <td>Diease</td>
                    </tr>
                    <% while(rs.next()) { %>
                        <tr>
                            <td>
                                <%= rs.getInt("pno") %>
                            </td>
                            <td>
                                <%= rs.getString("pname") %>
                            </td>
                            <%= rs.getInt("age") %>
                             </td>
                            
                            <td>
                                <%= rs.getString("address") %>                          
                             <td>
                                <%= rs.getString("diease") %>
                             </td>
                             
                            </tr>
                        <% 
                        }
                         cn.close(); 
                        }
                        catch(Exception e) {
                         out.println(e); 
                        }
                         %>
</body>

</html>
