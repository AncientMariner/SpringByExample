<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Members</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Members Name</th>
        <th>Id</th>
    </tr>
    <c:forEach items="${guests}" var="guest">
        <tr>
            <td>${guest.name}</td>
            <td>${guest.id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
