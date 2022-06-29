<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<h3>Registered Successfully!</h3>
<h3>Your Information Is</h3>

<%-- Fetching data coming from controller --%>


<h3>Name ${user.username} </h3>
<h3>Email ${user.email}</h3>
<h3>Password ${user.password}</h3>
</body>
</html>