<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Course Management</title>
	<meta charset="UTF-8">
	
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     
	
   
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
<body style= "background-image: url('back.jpg');">
	<%@page import="javax.servlet.http.HttpSession"%>
	
	<h1 style="text-align: center;">
	
	<%
	
	out.print(session.getAttribute("firstName"));
	out.print(" ");
	out.print(session.getAttribute("lastName"));
	
	%>
	
	
	</h1>
	
	
	<%-- <%
		HttpSession session = request.getSession();
		out.print(session.getAttribute("firstName"));
		out.print(" ");
		out.print(session.getAttribute("lastName"));
	
	%>
	
 --%>
 
 



	
	<div class="btn-group cen">
   		<button><a style="text-decoration:none;color:white;" href = "create"><strong>Create Course</strong> </a> </button>
  		<button><a style="text-decoration:none; color:white;" href = "assign" > <strong>Assign Course</strong> </a></button>
        <button><a style="text-decoration:none; color:white;" href = "logout" > <strong>Log Out</strong> </a></button>
    </div>
	
	
	<script type="text/javascript">
	

	
	
	
	 
	 var msg = '<%=request.getAttribute("msg")%>';
	 if(msg == 'assigned') {
		 swal("Done!", "Course is assigned!", "success");

	 } else if(msg == 'added') {
		
		 swal("Done!", "Course is added!", "success");
		 
	 }
	
	
	
	</script>
	
</body>
</html>