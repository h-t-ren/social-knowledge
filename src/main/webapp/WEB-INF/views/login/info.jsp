<%@page import="java.io.*"%>
<%
String  file = request.getParameter("file");
BufferedReader input =null;
try
{
FileReader reader =new FileReader("/p/ime/smt/doc/gen/"+file);
input= new BufferedReader(reader);
}
catch (Exception e)
{
return;
}
String line = "";
while ((line = input.readLine()) != null) {
   if(line.startsWith("#"))
   continue;
   out.println(line+"<br/>");
}
out.flush();
input.close();
%>
