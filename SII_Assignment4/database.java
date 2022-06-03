import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class database extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse responce) throws IOException, ServletException {
        responce.setContentType("text/html");
        PrintWriter out = responce.getWriter();
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            // load driver
            Class.forName("org.postgresql.Driver");
            // establish a conn
            con = DriverManager.getConnection("jdbc:postgresql://localhost/bcs","postgres", "");

            st = con.createStatement();
            rs = st.executeQuery("select * from student ");

            while (rs.next()) {
                out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));

                out.println("<br>");
            }

        } catch (Exception e) {
            out.println(e);
        }
        out.close();

    }
}
