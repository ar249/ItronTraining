
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >

</head>
<body>
<h1>Enter Credentials</h1>
<h4>${msg}</h4>
<br>
<spring:form action = "./verify" method="post" class="loginForm" modelAttribute="usr">
    Enter your Email :: <spring:input path = "email" ></spring:input> <br>
    Enter Your Password :: <spring:input path="password"></spring:input> <br>
    <input type = "submit"><br>
    <p><button> <a href="./mainMenu"> Go Back</a></button></p>

</spring:form>
</body>
</html>
