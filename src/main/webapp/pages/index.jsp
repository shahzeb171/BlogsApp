<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BLOGS APP!</title>
</head>
<body>
<a href="blogs/new"><button>ADD A NEW BLOG!</button></a>

<% if((Boolean)request.getAttribute("loggedIn")) {%>
<a href="/logout"><button>LOGOUT!</button></a>
<% }else{ %>
<a href="/signup"><button>SIGNUP!</button></a>
<a href="/login"><button>LOGIN!</button></a>
<% } %>
<c:forEach items="${allPosts}" var="post" >
<h1>${post.title}</h1>
<c:set var="string" value="${post.description}"/>  
<b>${fn:substring(string,0,30)}</b>...
<fmt:formatDate value="${post.date}" type="date" pattern="dd-MMM-yyyy"/>
	<a href="blogs/${post.id}"><button>READ MORE!</button></a>
</c:forEach>
</body>
</html>