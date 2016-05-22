<%@page import="testpack.DB_Access"%>
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
	<h2>Delete Item</h2>
	<form method='post'>
	Are you sure about deleting item(${item.itemName}) and its QTY(${item.QTY}) ?
	<input type='hidden' name='userId' value='${user.uid}'>
	<input type='hidden' name='itemId' value='${item.itemId}'>
	<input type='submit' value='Delete'>
	</form>
	<a href='Home'><h3>Back to Home Page</h3></a>
	</center>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>