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
		<h1>Change Password</h1><br><br><br>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>
		<error:errorMSG>${param.msg}</error:errorMSG>
		Login as: ${user.fulName}<br>
		<form method='post'>
		Current password:<input type='text' name='currentType'><br>
		New password:<input type='text' name='newPassword'><br>
		New password agian:<input type='text' name='newPassword2'><br>
		<br>
		<input type='submit' value='Apply'>
		</form>
		<br>
		<a href='AccountInfo'>Back to Account Information</a>
	</center>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>