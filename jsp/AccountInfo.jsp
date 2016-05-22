<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>
	<center>
	<h1>Account Information</h1>
	<br>
	<br>
	<br>
	User Name: ${user.fulName} <a href='EditUserName'>Edit</a>
	<br>
	Login Name: ${user.loginName} <a href='EditUserName'>Edit</a>
	<br>
	Login Password:***** <a href='EditPassword'>Edit</a>
	<br>
	<a href='Home'><h3>Back to Home Page</h3></a>
	</center>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>