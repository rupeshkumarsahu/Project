<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NITC Permission Flow Home</title>
  </head>
 <body>
 <%
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
      
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
      <img src='img/home.jpeg'>
      
      
       <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
 
     <jsp:include page="footer.jsp"></jsp:include>
     
    
 
  </body>
</html>