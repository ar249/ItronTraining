
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New User Registration</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >
</head>
<body>
<h1>Enter Info</h1>
<h4>${msg}</h4>

<spring:form action="./add" method="post" class="loginForm" modelAttribute="usr">
    Enter Your Name :: <spring:input  path="name"></spring:input><br>
    Enter Your Email :: <spring:input  path="email"></spring:input><br>
    Enter Your Password :: <spring:input  path="password"></spring:input><br>
  <input type="submit"><br>
    <p>  <button> <a href="./mainMenu"> Go Back</a></button></p>
</spring:form>

</body>
</html>
