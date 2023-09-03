
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>USER MENU --- CITY METRO</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >

</head>
<body>
<br/>

<h4>${msg}</h4>
<br>

<div class="index">
    <button class="b1"><a href="./listStations">Enter Source and Destination</a></button><br><br>
    <button class="b1"><a href="./balance">Check Balance</a></button><br><br>
    <button class="b1"><a href="./recharge">Recharge</a></button><br><br>
    <button class="b1"><a href="./">LogOut</a></button><br><br>
</div>
</body>
</html>
