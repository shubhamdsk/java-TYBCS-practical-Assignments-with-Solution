<%@ page language="java" %>
    <html>

    <head>
        <title>Subtract number program in JSP </title>
    </head>

    <body>
        <form method="post" action="Add_jsp.jsp">
            Enter 1st Number <input type="text" name="No1">
            Enter 2nd Number <input type="text" name="No2">
            <input type="submit" value="RESULT" />
            <% 
            try{
            int a=Integer.parseInt(request.getParameter("No1"));
            int b=Integer.parseInt(request.getParameter("No2"));
            int result=a + b;
             out.print("Addition of a and b :"+result); 
            }catch(Exception e)
            {
                out.println(e);
            }
             %>
        </form>
    </body>

    </html>