<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
String checka=(String)session.getAttribute("checka");
if(checka!=null)
{
	

%>
<h1 class="display-6 text-center">Admin Page</h1>
<a href="adlogout" class="btn btn-danger">Logout</a>

<h1 class="display-6">Ram : ${c1 }</h1>
<h1 class="display-6">Shyam :${c2 } </h1>
<h1 class="display-6">Raju :${c3 } </h1>
<h1 class="display-6">Rohit :${c4 }</h1>

<h1 class="display-6">winner :${winner } </h1>
<%}
else
{
	response.sendRedirect("loginadmin.jsp");
}
%>
</body>
</html>