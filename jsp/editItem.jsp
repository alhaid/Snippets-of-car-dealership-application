<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>
<error:errorMSG>${param.msg}</error:errorMSG>
<body>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>
	${param.success}

		<c:if test="${param.success == false}">
			<h2 style='color:red'>Item does not exist</h2>
		</c:if>
		<c:if test="${param.success}">
			<center>
				<form method='post'>
				Item Name: <input type='text' name='ItemName' placeholder='${i.itemName}'><br>
				Item QTY: <input type='text' name='ItemQTY' placeholder='${i.QTY}'><br>
				<input type='hidden' name='userId' value='${user.uid}'>
				<input type='hidden' name='itemId' value='${i.itemId}'>
				<input type='submit' value='Apply'>
				</form>
				<a href='Home'><h3>Back to Home Page</h3></a>
			</center>
		</c:if>
			
		
		
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>