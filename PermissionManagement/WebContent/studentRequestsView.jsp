<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,in.ac.nitc.permission.dbconnection.DBConnection" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Planned</title>
<style>
table{
	border: 1px solid;
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
<h1>Your Requested Events</h1>

 <table cellspacing="20">
   <tr style="margin: 5px">
    <th>Booked Lab</th>
    <th>Purpose</th>
    <th>Start Date & Time</th>
    <th>End Date & Time</th>
    <th>No of Audience</th>
    <th>Status</th>
  </tr>
  <%
    DBConnection dbCon=new DBConnection();
	Connection con=dbCon.getDBConnection();
	String query="";
	ResultSet rs;
	try {
		String rollno = (String)session.getAttribute("rollno");
		PreparedStatement st;
		query="select * from  Permission where student_rollno=?";
		st=con.prepareStatement(query);
		st.setString(1,rollno);
		rs=st.executeQuery();
		while(rs.next()) {
			int lab_id = rs.getInt("lab_id");
			PreparedStatement ps;
			String query1="select lab_name from  Lab where lab_id=?";
			ps=con.prepareStatement(query1);
			ps.setInt(1,lab_id);
			ResultSet rs1;
			rs1=ps.executeQuery();
		    rs1.next();
		    String lab_name = rs1.getString("lab_name");
  %>

  <tr style="margin: 5px">
			    <td><%=lab_name %></td>
			    <td><%=rs.getString("purpose") %></td>
			    <td><%=rs.getString("start_datetime") %></td>
			    <td><%=rs.getString("end_datetime") %></td>
			    <td><%=rs.getInt("max_audience") %></td>
			    <td><%=rs.getString("status") %>
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

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>