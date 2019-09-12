
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  
  
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!--      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
</head>
<body class="login">
	




  <form method="post" action="home">
  	<div class="loginBox" style="height: 68%; top: 50%; margin-top: 50px;">
      <img src="user.png" class="user">
      <h2>Online Course Management</h2>
        <p>Email</p>
        <input type="text" name="email" placeholder="Enter Email" required>
        <p>Password</p>
        <input type="password" name="password" placeholder="Enter Password" required>
        <select name = "userRole" type = "submit" style="margin-bottom: 20px;" required>
          <option value="" disabled selected>Select Role</option>
          <option value="Admin">Admin</option>
          <option value="Teacher">Teacher</option>
          <option value="Student">Student</option>
        </select>
        <input type="submit" name="loginUser" value="Sign In">
        <p>
          Not yet a member? <a href="register">Sign up</a>
        </p>
      </form>
    </div>
    
    
    <script type="text/javascript">
    
    	var msg = '<%=request.getAttribute("msg")%>';
    	
    	if(msg == "invalid") {
    		swal("Sorry!", "Credential does not match.", "error");
    	}
    </script>
</body>
</html>