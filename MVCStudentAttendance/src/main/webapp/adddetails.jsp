<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%int count=(int)request.getAttribute("count");%>
    <%=count %><h1> Record inserted sucesfully</h1>
</body>
</html>