<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>
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
	<error:errorMSG>${param.msg}</error:errorMSG>
		<form method="post">
			<h2>Add New Item</h2>
			Item Name: <input type='text' name='itemName'><br>
			Item Qty: <input type='text' name='itemQty'><br>
			<input type='submit' value='Add Item'>
			<input type='hidden' name='userId' value='${user.uid}'>
		</form>
		<a href='Home'>Back to Home Page</a>
	</center>
	
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>