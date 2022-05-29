import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse responce) throws IOException, ServletException {

        responce.setContentType("text/html");
        PrintWriter out = responce.getWriter();
        out.println("Hello Java");
        out.close();
    }

}
