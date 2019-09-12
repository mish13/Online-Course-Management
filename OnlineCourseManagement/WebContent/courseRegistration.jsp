<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Online Course Management - Course Registration</title>
</head>
<body>
	
	<div class="loginBox" style="top: 90%; height: 115%; margin-top: 50px;">
			<img src="user.png" class="user">
			<h2>Course Registration</h2>
			<form method="post" action="courseRegistration">
				<p>Course Code</p>
				<input type="text" name="courseCode" placeholder="Enter Course Code" required>
				<p>Course Title</p>
				<input type="text" name="courseTitle" placeholder="Enter Course Title" required>
				<input type="submit" name="regUser" value="Register">
			</form>
		</div>
	
</body>
</html>