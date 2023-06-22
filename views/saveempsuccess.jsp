<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nkxgen.spring.orm.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee has been Successfully Saved</title>
</head>
<body>
<H3> Employee has been added successfully</H3>
<%
		Employee emp=(Employee)request.getAttribute("emp");
%>        
<table>
		<tr><td>Emp No </td>
			<td> <%= emp.getEmpNo() %> </td> 
		</tr>
		<tr><td>Name </td>
			<td><%= emp.getEName() %> </td> 
		</tr>
		<tr><td>Job </td>
			<td><%=  emp.getJob() %> </td>
		</tr>
		<tr><td>Salary </td>
			<td><%= emp.getSalary() %></td> 
		</tr>
		<tr><td>Dept No </td>
			<td><%= emp.getDeptNo() %> </td> 
		</tr>
	</table>
</body>
</html>