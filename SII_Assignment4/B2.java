import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class B2 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String allsub = "";
        String lang[] = req.getParameterValues("sub");
        for (int i = 0; i < lang.length; i++) {

            allsub = allsub + lang[i];

        }

        Cookie c1 = new Cookie("sub1", allsub);
        res.addCookie(c1);
        out.println("cookie added with value: " + allsub);
        out.println("<br>");

        out.close();
    }

}
