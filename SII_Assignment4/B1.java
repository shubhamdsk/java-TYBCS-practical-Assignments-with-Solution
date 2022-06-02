import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class B1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse responce) throws IOException, ServletException {

        responce.setContentType("text/html");
        PrintWriter out = responce.getWriter();

        try {

            Scanner sc = new Scanner(System.in);
            Connection con = null;
            ;
            Statement st = null;
            ResultSet rs = null;

            // load driver
            Class.forName("org.postgresql.Driver");
            out.println("<h2>Driver load</h2>");

            // establish a conn
            con = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "postgres", "");

            out.println("<h2>connection load</h2>");

            int cnum = Integer.parseInt(request.getParameter("num"));

            st = con.createStatement();
            rs = st.executeQuery("select * from cust where id=" + cnum);

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
