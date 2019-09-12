<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Course Management - Student Home</title>


<style type="text/css">
  .btn-group button {
  background-color: rgb(0, 41, 74); /* Green background */
  border-color: 1px solid rgb(0, 41, 74); /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  width: 30%; /* Set a width if needed */
  display: block; /* Make the buttons appear below each other */
}

.btn-group button:not(:last-child) {
  border-bottom: none; /* Prevent double borders */
}
.btn-group button:hover {
  background-color:rgb(100, 105, 112) ;
}

.cen {

 margin-left: 530px;
 margin-top: 230px;


}
</style>


</head>
<body>
	<%@page import="javax.servlet.http.HttpSession"%>
	
	<h1 style="text-align: center;">
	
	<%
	
	out.print(session.getAttribute("firstName"));
	out.print(" ");
	out.print(session.getAttribute("lastName"));
	
	%>
	
	
	</h1>
	
	
<!-- 	<a href= "courseRegistration">Course Registration</a>
	<a href= "registeredCourses">Registered Courses</a>
	<a href = "logout">Log out</a> -->
	<div class="btn-group cen">
   		<button><a style="text-decoration:none;color:white;" href = "courseRegistration"><strong>Course Registration</strong> </a> </button>
  		<button><a style="text-decoration:none; color:white;" href = "registeredCourses" > <strong>Registered Courses</strong> </a></button>
        <button><a style="text-decoration:none; color:white;" href = "logout" > <strong>Log Out</strong> </a></button>
    </div>
	
	
	
</body>
</html>