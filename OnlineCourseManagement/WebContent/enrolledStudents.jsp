<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Online Course Management - Enrolled Students</title>
</head>
<body>
	
	<h1 style="text-align: center;">Enrolled Students</h1>
	
	<br>
	<br>
	
	
	
	<%@page import="java.sql.ResultSet"%>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("courseInfo");
	%>
	
	<%-- <%
	ResultSet rs = (ResultSet) request.getAttribute("courseInfo");
	
	
	
	
	
	while(rs.next()) {
		out.print(rs.getString("firstName"));
		out.print(" " + rs.getString("lastName"));
        out.print("<br>");
        
      
	}
	
	%>  --%>
	
	
	<div class=container>
		<div class="col-md-3"></div>
		
		<div class="col-md-6">
			<table class="table table-striped">
			
				<thead>
				<tr>
			       <th>Firstname</th>
			       <th>Lastname</th>
			       <th>Email</th>
			     </tr>
				</thead>
				
				
				<tbody>
				
					<% while(rs.next()) { %>
					<tr>
					<td><% out.print(rs.getString("firstName")); %></td>
					<td><% out.print(rs.getString("lastName")); %></td>
					<td><% out.print(rs.getString("email")); %></td>
					</tr>
				    <% } %>
				
				
		
				
				
				</tbody>
			</table>
		
		
		</div>
		'
		<div class="col-md-3"></div>
	
	</div>
	
	
</body>
</html>