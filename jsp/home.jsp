<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>
			<%@ taglib uri="welcomeTag" prefix="welcome"%>
			<welcome:welcome>${user.fulName}</welcome:welcome>
			<div style="text-align:right;"><a href="AccountInfo">Edit Account</a>&nbsp;&nbsp;<a href="LogOut">Log Out</a></div>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div align="center">
			<h2 >List of Your Items</h2>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>
			<error:errorMSG>${param.msg}</error:errorMSG>
			<table align="center">
		<c:forEach var="item" items="${items}">
						<tr>
							<td><a href="view?id=${item.itemId}">View</a></td>
							<td><a href="edit?id=${item.itemId}">Edit</a></td>
							<td><a href="delete?id=${item.itemId}">Delete</a></td>
							<td> &nbsp;${item.itemName}</td>
							<td>${item.QTY}</td>
						</tr>	
		</c:forEach>
			</table>
			<h2><a href="addItem">Add New Item</a></h2>
		</div>
	<div style="text-align:center; background-color:lightgrey;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>