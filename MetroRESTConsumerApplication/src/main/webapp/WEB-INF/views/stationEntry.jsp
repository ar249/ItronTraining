
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Enter Source and Destination</title>
    <link rel="stylesheet" href="<c:url value='style.css'/>" >

</head>
<body>
<h4>${msg}</h4>
<br>
<br>
<spring:form action="./calculate" method="post" modelAttribute="travel" cssClass="loginForm">
    <p> <label>Select Source</label>
<select name="source" id="src">
    <c:forEach var="station" items="${stationList}">
        <option value ="${station.stations_id}">${station.station_name}</option>
    </c:forEach>
</select> </p>

    <p><label>Select Destination</label>
 <select name="destination" id="dstn">
     <c:forEach var="station" items="${stationList}">
     <option value ="${station.stations_id}">${station.station_name}</option>
     </c:forEach>
 </select>
   </p>
    <input type="submit">
    <p> <button> <a href="./userMenu"> Go Back</a></button></p>


</spring:form>
</body>
</html>
