<%@page import="model.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% ArrayList<StudentDTO> list=(ArrayList)request.getAttribute("studentlist");%>
    <%int aClasses; int tClasses;%>
   <table border="2">
      <tr>
          <th style="color: red;">Student Id</th>
          <th style="color: red">Student Name</th>
          <th style="color: red">Batch Code</th>
          <th style="color: red">Total Classes</th>
          <th style="color: red">Attended Classes</th>
          <th style="color: red">Attendance Percentage</th>
      </tr>
      <%for(StudentDTO dto: list){%>
      		<tr>
      		    <% double a=dto.getAttendedClasses(); %>
      		    <% double b=dto.getTotalClasses(); %>
      		    <% double c=(a/b)*100; %>
      			<td style="font-weight: bold;"><%=dto.getStudentId() %></td>
      			<td style="font-weight: bold;"><%=dto.getStudentName() %></td>
      			<td style="font-weight: bold;"><%=dto.getBatchCode() %></td>
      			<td style="font-weight: bold;"><%=dto.getTotalClasses() %></td>
      			<td style="font-weight: bold;"><%=dto.getAttendedClasses()%></td>
      			<td style="font-weight: bold;"><%= c %>
      			  
      			
      		</tr>
    	  
      <%}%>
            
   </table>
</body>
</html>