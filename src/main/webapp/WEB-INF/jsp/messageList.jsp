<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Message List</title>
</head>
<body>
<h2>Welcome! <security:authentication property="name" var="name" /></h2>
<security:authentication property="authorities" var="authorities" />
<ul>
    <c:forEach items="${authorities}" var="authority">
        <li>${authority.authority}</li>
    </c:forEach>
</ul>
<hr />

<%--default--%>
<%--<a href="<c:url value="/spring_security_login" />">Login</a>--%>
<a href="<c:url value="login" />">Login</a>
<a href="<c:url value="/j_spring_security_logout" />">Logout</a>

<c:forEach items="${messages}" var="message">
    <table>
        <security:authorize ifAllGranted="ROLE_ADMIN,ROLE_USER">
        <%--<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">--%>
        <%--<security:authorize ifNotGranted="ROLE_GUEST">--%>
        <%--<security:accesscontrollist domainObject="${message}" hasPermission="8,16">--%>
        <tr>
            <td>Author</td>
            <td>${message.author}</td>
        </tr>
        </security:authorize>
        <%--</security:accesscontrollist>--%>
        <tr>
            <td>Title</td>
            <td>${message.title}</td>
        </tr>
        <tr>
            <td>Body</td>
            <td>${message.body}</td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="messageDelete?messageId=${message.id}">Delete</a>
            </td>
        </tr>
    </table>
    <hr />
</c:forEach>
<a href="messagePost.htm">Post</a>
</body>
</html>
