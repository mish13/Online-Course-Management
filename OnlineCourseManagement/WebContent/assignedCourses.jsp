<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Online Course Management - Assigned Courses</title>
</head>
<body>
	<h1 style="text-align: center;">My assigned courses</h1>
	
	<br>
	<br>
	
	
	
	<%@page import="java.sql.ResultSet"%>
	
	<%
	ResultSet rs = (ResultSet) request.getAttribute("courseInfo");
	%>
	
	
	<div class=container>
		<div class="col-md-4"></div>
		
		<div class="col-md-4">
			<table class="table table-striped">
			
				<thead>
				<tr>
			       <th>CourseCode</th>
			       <th>Registered Students</th>
			       
			     </tr>
				</thead>
				
				
				<tbody>
				
					<% while(rs.next()) { %>
					<tr>
					
					<%String code = rs.getString("courseCode");
					
					String link = String.format("<a href='enroll?courseCode=%s'>List of Registered students of %s</a>",code,code,code);
					
					%>
					<td><% out.print(code); %></td>
					<td><%out.print(link); %> </td>
					
					
					</tr>
				    <% } %>
				
				
		
				
				
				</tbody>
			</table>
		
		
		</div>
		'
		<div class="col-md-4"></div>
	
	</div>
	
	
	
	
	
	</div>
	
	
	
 <!--   while(rs.next()) {
		/* out.print(rs.getString("courseCode"));
		out.print(" " + rs.getString("courseTitle"));
        out.print("<br>"); */
        
        String code = rs.getString("courseCode");
        
		String link = String.format("<a href='enroll?courseCode=%s'>List of Registered students of %s</a>",code,code,code);
		out.print(link);
	} -->
	
	
</body>
</html>