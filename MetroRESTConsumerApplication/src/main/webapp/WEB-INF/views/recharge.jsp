
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Recharge Your Wallet</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >

</head>
<body>
<h4>${msg}</h4>
<br>
    <br>
    <form action="./addbal" class="loginForm">
        <p>  Enter Recharge Amount :: <input type = "number", name="amount" required/> </p>
<input type="submit"><br>
        <p>   <button><a href="./userMenu">Go Back</a></button></p>
    </form>


</body>
</html>
