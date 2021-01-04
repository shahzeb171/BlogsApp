<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE BLOG</title>
</head>
<body>
<a href="/logout"><button>LOGOUT!</button></a>
<h1>CREATE A NEW BLOG!</h1>

<form method="post" action="/blogs">
	<input type="text" name="title" placeholder="Title" required><br>
	<textarea rows="10" cols="10" placeholder="Description" name="description" required></textarea>
	<input type="submit" value="ADD IT!">
</form>

</body>
</html>