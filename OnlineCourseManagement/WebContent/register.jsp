<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
	<link rel="stylesheet" type="text/css" href="style.css">
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!--     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
</head>
<body class="register">



<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Notification</h4>
        </div>
        <div class="modal-body">
          <p>Email is already used</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>


		<div class="loginBox" style="top: 75%; height: 115%;margin-bottom: 50px;">
			<img src="user.png" class="user">
			<h2>Online Course Management</h2>
			<form method="post" action="register">
				<p>First Name</p>
				<input type="text" name="firstName" placeholder="Enter First Name" required>
				<p>Last Name</p>
				<input type="text" name="lastName" placeholder="Enter Last Name" required>
				<p> Username</p>
				<input type="text" name="userName" placeholder="Enter Username" required>
				<p>Email</p>
				<input type="text" name="email" placeholder="Enter Email" required>
				<p>Password</p>
				<input type="password" name="password" placeholder="Enter Password" required>
				<p>Confirm Password</p>
				<input type="password" name="confirmPassword" placeholder="Confirm Password" required>
				<p> Contact No</p>
				<input type="text" name="contactNo" placeholder="Contact No" required>
				<select name = "userRole" type = "submit" style="margin-bottom: 20px;" required>
					<option value="" disabled selected>Select Role</option>
					<option value="Admin">Admin</option>
					<option value="Teacher">Teacher</option>
					<option value="Student">Student</option>
				</select>
				<input type="submit" name="regUser" value="Register">
				<p>
					Already a member? <a href="login">Sign in</a>
				</p>
			</form>
		</div>

	
	<script type="text/javascript">
    
    	var msg = '<%=request.getAttribute("msg")%>';
    	
    	if(msg == "invalid") {
    		var modal = $('#myModal');
    		modal.modal('show');
    	}
    </script>
</body>
</html>