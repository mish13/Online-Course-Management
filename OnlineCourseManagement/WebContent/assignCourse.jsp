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
<title>Online Course Management - Assign Course</title>
</head>
<body>

<div class="loginBox" style="top: 75%; height: 115%;">
			<img src="user.png" class="user">
			<h2>Assign Course</h2>
			<form method="post" action="assign">
				<p>Course Code</p>
				<input type="text" name="courseCode" placeholder="Enter Course Code" required>
				<p>Course Title</p>
				<input type="text" name="courseTitle" placeholder="Enter Course Title" required>
				<p> Teacher's Username</p>
				<input type="text" name="teacherName" placeholder="Enter Teacher's Username" required>
				<p>Teahcer's Email</p>
				<input type="text" name="teacherEmail" placeholder="Enter Teacher's Email" required>
				<input type="submit" name="regUser" value="Assign">
			</form>
		</div>

</body>
</html>


