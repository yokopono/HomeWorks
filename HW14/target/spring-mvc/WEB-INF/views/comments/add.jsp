<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 12.11.16
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить коммент</title>
</head>
<body>

<form:form action="/comments/add" method="post" modelAttribute="post">
    <table>
        <tr>
            <td><form:label path="text">Текст</form:label></td>
            <td><form:input path="text"/></td>
            <td><form:errors path="text"/></td>
        </tr>
    </table>
    <input type="submit" value="save"/>
</form:form>

</body>
</html>
