<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<h1 style="text-align: center;">My Registered Courses</h1>
	<br>
	<br>
	
	
	<%@page import="java.sql.ResultSet" %>
	
	<%
	ResultSet rs = (ResultSet) request.getAttribute("courseInfo");
	%>
	
	<!-- while(rs.next()) {
		out.print(rs.getString("courseCode"));
		out.print(" " + rs.getString("courseTitle"));
        out.print("<br>"); 
    } -->
    
    
    <div class=container>
		<div class="col-md-3"></div>
		
		<div class="col-md-6">
			<table class="table table-striped">
			
				<thead>
				<tr>
			       <th>Course Code</th>
			       <th>Course Title</th>
			       
			     </tr>
				</thead>
				
				
				<tbody>
				
					<% while(rs.next()) { %>
					<tr>
					
					<td><% out.print(rs.getString("courseCode")); %></td>
					<td><% out.print(rs.getString("courseTitle")); %></td>
					
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