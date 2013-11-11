<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Message Post</title>
</head>
<body>
<security:authentication property="name" var="name" />
<form:form method="POST" modelAttribute="message">
    <input type="hidden" value="${name}" name="author" />
    <table>
        <tr>
            <td>Title</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Body</td>
            <td><form:textarea path="body" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Post" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
