<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Duty Page</title>
<style>
body {
  background-color: lightblue;
 text-align: center;
}
</style>
</head>
<body>
<%
	response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
	//response.setHeader("Pragma", "no-cache");
	//response.setHeader("Expires", "0");
	
	if(session.getAttribute("email")==null){
		response.sendRedirect("loginView.jsp");
	}
%>
<br/>
<br/>
<jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>
	<h1>Admin Duty</h1>
	<form action="getAdmin">
  		<input type="radio" name="choice" value="lab_admin" checked> Show Raised Permissions <br> 
  		<!--It will goto servlet page "admin_view with data "lab_admin"   -->
  
  		<input type="radio"  name="choice" value="approved">Show Approved permissions<br>
    	<!--It will goto servlet page "admin_view with data "approved"   -->
  		<input type="submit" value="Submit">
	</form> 
	<div >
	    <h1><a href="studentLabAdminView.jsp">Back</a></h1>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>