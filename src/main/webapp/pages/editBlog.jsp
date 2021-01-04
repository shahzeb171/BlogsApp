<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT BLOG</title>
</head>
<body>
<a href="/logout"><button>LOGOUT!</button></a>
<h1>EDIT YOUR BLOG!</h1>

<form:form method="put" action="/blogs/${blog.id}">
	<input type="text" name="title" placeholder="Title" required value="${blog.title}"><br>
	<textarea rows="10" cols="10" placeholder="Description" name="description" required >${blog.description}</textarea>
	<input type="submit" value="EDIT IT!">
</form:form>

</body>
</html>