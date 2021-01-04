<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<h1>LOGIN PAGE</h1>

${SPRING_SECURITY_LAST_EXCEPTION.message}

<form action="login" method="post">
	<input type="text" placeholder="USERNAME HERE"  name="username" required>
	<input type="password" placeholder="PASSWORD HERE" name="password">
	<input type="submit" value="LOGIN !"> 
	
</form>

<a href="/signup"><button>SIGNUP!</button></a>
</body>
</html>