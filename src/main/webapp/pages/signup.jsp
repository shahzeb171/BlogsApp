<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER SIGNUP</title>
</head>
<body>
<h1>USER SIGNUP</h1>

<form action="signup" method="post">
	<input type="text" placeholder="NAME" name="name" required>
	<input type="text" placeholder="USERNAME" name="username" required>
	<input type="password" placeholder="PASSWORD" name="password" required>
	<button type="submit">SIGNUP!</button>
</form>
<a href="/login">HAVE AN ACCOUNT? </a><br>
</body>
</html>