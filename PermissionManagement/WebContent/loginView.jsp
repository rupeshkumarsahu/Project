<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="./css/loginStyle.css">
</head>
<body>
	<%
		response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
	//response.setHeader("Pragma", "no-cache");
	//response.setHeader("Expires", "0");
	
		if(session.getAttribute("email")==null){
			;
		}
		else{
			if(session.getAttribute("type").equals("student"))
				response.sendRedirect("studentView.jsp");
			else if(session.getAttribute("type").equals("student_lab_admin"))
				response.sendRedirect("studentLabAdminView.jsp");
			else if(session.getAttribute("type").equals("faculty_incharge"))
				response.sendRedirect("facultyInchargeView.jsp");
		}
	%>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="loginBox">
		<form action="login" method="post">
			<table align="center">
			<tr>
				<td>Nitc Email ID:</td><td><input type="text" name="email" required></td>
			</tr>
			<tr>	
				<td>Password: </td><td><input type="password" name="pass" required/></td>
			</tr>
			<tr>
				<td></td><td><input type="submit" value="Login"/></td>
			</tr>
			
		</table>
		
	</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>