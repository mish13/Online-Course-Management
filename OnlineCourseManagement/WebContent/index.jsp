<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Course Management</title>

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

body {
	background-image = url('back.jpg');

}


</style>


</head>
<body class="login">

<center>
<h1>Online Course Management</h1>
</center>

<div class="btn-group cen">
  <button><a style="text-decoration:none;color:white;" href = "register"><strong>Register</strong> </a> </button>
  <button><a style="text-decoration:none; color:white;" href = "login" > <strong>Login</strong> </a></button>
</div>

</body>
</html>