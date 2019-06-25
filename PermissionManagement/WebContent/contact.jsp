<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
	//response.setHeader("Pragma", "no-cache");
	//response.setHeader("Expires", "0");
	
	
%>
<br/>
<br/>
<jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>
<br/>
<br/>
Sanjib
Mithun
Rupesh
Lokesh
Shubham 
<br/>
<br/>
<br/>
<br/>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>