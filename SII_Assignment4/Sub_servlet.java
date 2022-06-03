import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sub_servlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {

        int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));
        int s = n1 - n2;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Substraction > " + s);
        out.close();
    }

}
