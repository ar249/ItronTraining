<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >

</head>

<body>
<h1>Welcome to City Metro System</h1>
<br/>
<h4>${msg}</h4>
 <br>
<div class="index">
<button class="b1"><a href="./register">Register</a></button><br>
<button class="b1"><a href="./login">Login</a></button><br>
<button class="b1"><a href="./thankYou">Exit</a></button>
</div>
</body>
</html>