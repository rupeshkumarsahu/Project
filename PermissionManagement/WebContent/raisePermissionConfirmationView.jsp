<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>permission</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<style>
	#confirmlink{
		color:black;
		border-color:black;
	}
	#confirmlink:hover{
		color:black;
		background-color:orange;
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
<br/>
	
	<%
	
	String name =request.getParameter("name");
	String rollNumber =request.getParameter("rollNumber");
	String department =request.getParameter("department");
	String lab =request.getParameter("lab");
	int maxAudience =Integer.parseInt(request.getParameter("maxAudience"));
	String eventStartDate =request.getParameter("eventStartDate");
	String eventStartTime =request.getParameter("eventStartTime");

	String eventEndDate=request.getParameter("eventEndDate");
	String eventEndTime =request.getParameter("eventEndTime");

	String eventPurpose =request.getParameter("eventPurpose");
	
		session.setAttribute("name", name);
		session.setAttribute("rollNumber", rollNumber);
		session.setAttribute("department", department);
		session.setAttribute("lab", lab);
		session.setAttribute("maxAudience", maxAudience);
		session.setAttribute("eventStartDate", eventStartDate);
		session.setAttribute("eventStartTime", eventStartTime);

		session.setAttribute("eventEndDate", eventEndDate);
		session.setAttribute("eventEndTime", eventEndTime);

		session.setAttribute("eventPurpose", eventPurpose);
		
	%>
	
		<div class="container">
			<div class="row">
				<label>Name: <%=name %></label>
			</div>
			
			<div class="row">
				<label>Roll Number: <%= rollNumber %></label>
			</div>
			
			<div class="row">
				<label>Department: <%= department %></label>
			</div>
			
			<div class="row">
				<label>Lab: <%= lab %></label>
			</div>
			
			<div class="row">
				<label>maximum Audience: <%= maxAudience %></label>
			</div>	
			
			<div class="row">
				<label>Event Start Date : <%= eventStartDate %></label>
			</div>
			
			<div class="row">
				<label>Event Start Time: <%= eventStartTime %></label>
			</div>
			<div class="row">
				<label>Event End Date : <%= eventEndDate %></label>
			</div>
			<div class="row">
				<label>Event End Time: <%= eventEndTime %></label>
			</div>
			
			<div class="row">
				<label>Event Purpose: <%= eventPurpose %></label>
			</div>
			<br/>
			<br/>
			
			<div class="row">
					<a  id="confirmlink" class="btn btn-outline-warning" href="raisePermission" role="button">Confirm</a>
					&nbsp;&nbsp;
					<a class="btn btn-outline-dark" href="raisePermissionView.jsp" role="button">Back</a>
			</div>
			
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>