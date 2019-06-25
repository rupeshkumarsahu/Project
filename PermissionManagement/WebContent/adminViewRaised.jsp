<%@page import="in.ac.nitc.permission.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin view(Raised)</title>
<style>
table{
	border: 10px solid;
}
th,td{
	padding: 5px;
	text-align:center;
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

<h1  style="text-align:center;"> Admin view of Raised Permission</h1>
 <table cellspacing="20">
 <tr style="margin: 5px">
 	<th>Purpose</th>
    <th>Start Date time</th>
    <th>End Date Time</th>
    
    <th>Student RollNo</th>
    <th>Student Name</th>
    <th>Raised Date Time</th>
    <th>Lab Name</th>
    <th>No of Audience</th>
     <th>Action</th>
  </tr>
  
<%
	ArrayList<Permission> list=(ArrayList<Permission>)request.getAttribute("permission_list");

	for(Permission obj : list)
	{
		//out.println(obj);
		%>
		
  <tr style="margin: 5px">
  	<td><%=obj.getPurpose() %></td>
    <td><%= obj.getStartDatetime() %></td>
    <td><%=obj.getEndDatetime() %></td>
   
    <td><%=obj.getStudentRollno() %></td>
    <td><%=obj.getStudentName()  %></td>
    <td><%=obj.getRaisedDatetime()  %></td>
    <td><%=obj.getLabName()  %></td>
    <td><%=obj.getMaxAudience()  %></td>
    <td>
    <form action="updateStatus">
    <!-- <input type="textarea" name="message"/><br> -->
	<input type="hidden" name="submit_id" value="<%=obj.getEventId()%>" />
	    <textarea rows="4" name="message" required></textarea>
	<input type="hidden" name="change_status" value="faculty_incharge" />
	<input type="submit"   value="Forward">
	</form> 
	</td>
  </tr>
<% 
		out.println("\n");
	}

%>
</table>
	<div >
	    <h1><a href="studentLabAdminView.jsp">Back</a></h1>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
