<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
 <html>

<head>
  <title>Header</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

    <div id = "header">

      <div id="logo" style="position:center;">
      <img src = "img/nitclogo.png" alt = "image not avilable" style = "width:4%;height :5%">
          <h1><a href="index.jsp" id="logo_text1">NITC<span id="logo_text2"> Permission Flow Management System</span></a></h1>
          &nbsp;&nbsp;
        </div>
    

      <div id="nav">
        <ul id="menu">
          <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
          <li><a href="${pageContext.request.contextPath}/events.jsp">Events Requested</a></li>
          <li><a href="${pageContext.request.contextPath}/venueDetailsView.jsp">Available Labs</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
          <%
			if(session.getAttribute("email")==null){
			%>
   			<li><a href="${pageContext.request.contextPath}/loginView.jsp">Login</a></li>
   			<%
			}
			else
			{
			%>
				<%if(session.getAttribute("type").equals("student")){ %>
					<li><a href="studentView.jsp" style="color:Cyan;"><%=session.getAttribute("name") %></a></li>
				<%}else if(session.getAttribute("type").equals("student_lab_admin")){ %>
					<li><a href="studentLabAdminView.jsp" style="color:Cyan;"><%=session.getAttribute("name") %></a></li>
				<%}else if(session.getAttribute("type").equals("faculty_incharge")){ %>
					<li><a href="facultyInchargeView.jsp" style="color:Cyan;"><%=session.getAttribute("name") %></a></li>
				<%} %>
			<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			<%
			}
			%>
   			

        </ul>

  </div>

  </div> 
  
</body>
</html>

</body>