<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 12.11.16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${comment.text}</title>
</head>
<body>

<h1>${comment.text}</h1>

<form:form action="/posts/comments/${comment.id}/save" method="post" modelAttribute="comment">
    <table>
        <tr>
            <td><form:label path="text">Текст</form:label></td>
            <td><form:input path="text"/></td>
            <td><form:errors path="text"/></td>
        </tr>
    </table>
    <input type="submit" value="save"/>
</form:form>

<a href="/posts">Вернуться на главную</a>
</body>
</html>
