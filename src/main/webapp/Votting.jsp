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
String check=(String)session.getAttribute("check");
if(check!=null)
{
	

%>
<h1 class="display-6 text-center">Voting Page</h1>

<div class="container">
<form action="voteProcess">

<label for="c1" class="form-label">Ram</label>
<input type="radio" name="candidatename" value="Ram" id="c1" class="form-input d-block">

<label for="c2" class="form-label">Shyam</label>
<input type="radio" name="candidatename" value="Shyam" id="c2" class="form-input  d-block">

<label for="c3" class="form-label">Raju</label>
<input type="radio" name="candidatename" value="Raju" id="c3" class="form-input  d-block">

<label for="c4" class="form-label">Rohit</label>
<input type="radio" name="candidatename" value="Rohit" id="c4" class="form-input  d-block">

<input type="hidden" name="uid" value=<%=check %>>
<button class="btn btn-success">Vote</button>

</form>
</div>

<%}
else
{
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>