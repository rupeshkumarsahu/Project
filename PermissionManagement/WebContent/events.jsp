<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,in.ac.nitc.permission.dbconnection.DBConnection" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
    
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
 <jsp:include page="header.jsp"></jsp:include>
<h1>Already Planned Events</h1>

 <table cellspacing="20">
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
		query="select * from  Permission where status='approved' order by start_datetime";
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

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>