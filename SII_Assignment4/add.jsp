<%
try{
int p = Integer.parseInt(request.getParameter("no1"));
int q = Integer.parseInt(request.getParameter("no2"));
int result = p+q;

out.print("Addition of Two Number : "+result);
}
catch(Exception e){
out.print(e);
}
%>
