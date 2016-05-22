<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form method="POST" >
<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>
<error:errorMSG>${param.msg}</error:errorMSG>
<h2>Login Form</h2>
User Name: <input type="text" name="uname"><br>
Password: <input type="password" name="upass"><br>
<input type="Submit" value="Login"><br>
<h3><a href="CreateAccount">Create an Account</a></h3>
</form>