<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHOW PAGE</title>
</head>
<body>

<% if(request.getAttribute("Userusername")!=null){ %>
<a href="/logout"><button>LOGOUT!</button></a>
<% }else{ %>
<a href="/signup"><button>SIGNUP!</button></a>
<a href="/login"><button>LOGIN!</button></a>
<% } %>
<h1>${post.title}</h1>
<b>${post.description}</b>
<fmt:formatDate value="${post.date}" type="date" pattern="dd-MMM-yyyy"/>

<% if(request.getAttribute("Userusername")!=null   && request.getAttribute("Userusername").equals(request.getAttribute("username"))){ %>

<a href="/blogs/${post.id}/edit"><button>EDIT!</button></a>

<form:form action="/blogs/${post.id}" method="delete">
<input type="submit" value="DELETE!">
</form:form>
<% } %>
</body>
</html>