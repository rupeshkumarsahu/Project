<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,in.ac.nitc.permission.dbconnection.DBConnection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Lab Admin Home</title>
<link rel="stylesheet" href="/PermissionManagement/WebContent/css/studHomeStyle.css">
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
<div style="padding: 5px;float:center">
		<ul class="nav">
   			<li><a href="${pageContext.request.contextPath}/raisePermissionView.jsp">Raise Permission</a></li>
   			<li><a href="${pageContext.request.contextPath}/studentRequestsView.jsp">View Raised Permissions</a></li>
   			
		</ul>
	</div>
	
	<div style="padding: 5px;float:center">
		<p><b>Admin Responsibilities</b></p>
		<ul  class="nav">
			<li><a href="getAdmin?choice=lab_admin">Show raised Permission Requests</a></li>
			<li><a href="getAdmin?choice=approved">Show Approved Permission</a>
		</ul>
		
	</div>
	<div id="workcontent" style="width:80%;
		margin-top:100px;
		margin-left:10%;
		margin-right:10%;
    height:200px;
    border: 5px solid blue;
    overflow-y: scroll;
    overflow-x: hidden;
    white-space: nowrap;">
    <h2 style="margin-left:10%;">Forth-coming Events</h2>

			 <table cellspacing="20" align="center">
			   <tr style="margin: 5px">
			    <th>Purpose</th>
			    <th>Booked Lab</th>
			    
			    <th>Start Date & Time</th>
			    <th>End Date & Time</th>
			    <th>No of Audience</th>
			  </tr>
			  <%
			    DBConnection dbCon=new DBConnection();
				Connection con=dbCon.getDBConnection();
				String query="";
				ResultSet rs;
				try {
					query="select * from  Permission where status='approved' and start_datetime >= '2019-03-12 00:00:00'  order by start_datetime";
					Statement st = con.createStatement();
					rs=st.executeQuery(query);
					while(rs.next()) {
						int lab_id = rs.getInt("lab_id");
						PreparedStatement ps;
						query="select lab_name from  Lab where lab_id=?";
						ps=con.prepareStatement(query);
						ps.setInt(1,lab_id);
						ResultSet rs1;
						rs1=ps.executeQuery();
					    rs1.next();
					    String lab_name = rs1.getString("lab_name");
			  %>
			
			  <tr style="margin: 5px">
						    <td><%=rs.getString("purpose") %></td>
						    <td><%=lab_name %></td>
						    
						    <td><%=rs.getString("start_datetime") %></td>
						    <td><%=rs.getString("end_datetime") %></td>
						    <td><%=rs.getInt("max_audience") %></td>
			  </tr>
			  
			   <%
					      }	  
						  }catch(Exception e){
							  e.printStackTrace();
						  }
				          finally
				          {
				        	  dbCon.closeDBConnection();
				          }
			  %>
			
			</table>
		</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>