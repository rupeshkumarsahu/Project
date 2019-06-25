<%@page import="in.ac.nitc.permission.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Raised Request</title>

<style type="text/css">
table{
	border: 5px solid;
}
th,td{
	padding: 5px;
	text-align:center;
}
// :hover and :active styles left as an exercise for the reader.
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

	<h1 style="text-align:center;"> Faculty view of Raised Permission</h1>
 	<table cellspacing="20">
		<tr style="margin: 5px">
		    <th>Purpose</th>
		    <th>Start Date time</th>
		    <th>End Date Time</th>
		    
		    <th>Student RollNo</th>
		    <th>Student Name</th>
		    <th>Raised Date Time</th>
		        <th>Last Responsed Date Time</th>
		    <th>Permission Status</th>
		    <th>Lab Name</th>
		    <th>No of Audience</th>
		    <th>Message from Lab Admin</th>
		     <th>Action</th>
  		</tr>
  
	<%
		ArrayList<Permission> list=(ArrayList<Permission>)request.getAttribute("permission_list");

		for(Permission obj : list)
		{
	%>
		
  		<tr style="margin: 5px">
		    <td><%=obj.getPurpose() %></td>
		    <td><%= obj.getStartDatetime() %></td>
		    <td><%=obj.getEndDatetime() %></td>
		    
		    <td><%=obj.getStudentRollno() %></td>
		    <td><%=obj.getStudentName()  %></td>
		    <td><%=obj.getRaisedDatetime()  %></td>
		        <td><%=obj.getResponseDatetime()  %></td>
		    <td><%=obj.getStatus()  %></td>
		    <td><%=obj.getLabName()  %></td>
		    <td><%=obj.getMaxAudience()  %></td>
		    <td><%= obj.getMessage() %></td>
		    <td>
		    <form action="updateStatus">
			<input type="hidden" name="submit_id" value="<%=obj.getEventId()%>" />
			<select name="change_status">
			<option >Select Action</option>
			<option value="pending">On-Hold</option>
			<option value="declined">Reject</option>
			<option value="approved">Approve</option>
			</select>
			<input type="submit" value="Apply Action">
			</form> 
			</td>
  		</tr>
	<% 
			out.println("\n");
		}
	
	%>
	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div id="searchDiv">
		<h2 align="center">Search events in specified date </h2>
		<form action="${pageContext.request.contextPath}/searchEventsOnDate.jsp" method="get">
		<table align="center">
			<tr>
				<th>Choose Date</th>
			</tr>
			<tr>
				<td>
					<input type="date" name="Date" required/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"/></td>
			</tr>
		</table> 
		</form>
	</div>
	<div >
	   <h2> <a href="facultyInchargeView.jsp">Back</a></h2>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>