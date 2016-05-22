<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="error"%>

<form method="POST" >
<error:errorMSG>${param.msg}</error:errorMSG>
<h2>Create Account Form</h2>
User Name: <input type="text" name="uname"><br>
Full Name: <input type="text" name="name"><br>
Password: <input type="password" name="upass"><br>
<input type="Submit" value="Create"><br>
<h3><a href="Login">Back to Login Page</a></h3>
</form>