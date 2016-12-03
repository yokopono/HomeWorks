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
    <title>${post.title}</title>
</head>
<body>

<h1>${post.title}</h1>
<p>${post.text}</p>

<h2>Комментарии: </h2>

<form:form action="comments/add" method="post" modelAttribute="post">
    <table>
        <tr>
            <td><form:label path="text">Текст</form:label></td>
            <td><form:input path="text"/></td>
            <td><form:errors path="text"/></td>
        </tr>
    </table>
    <input type="submit" value="save"/>
</form:form>
<hr>
<c:forEach var="comment" items="${post.comments}">
    <p>${comment.text}</p>
    <small>Автор: ${comment.user.fullName}</small>
    <security:authentication property="principal.id" var="user_id"/>
    <security:authorize access="${user_id eq comment.user.id}">
        <a href="/posts/${post.id}/${comment.id}/delete">Удалить</a>
        <a href="/posts/${post.id}/${comment.id}/edit">Редактировать</a>
    </security:authorize>
    <hr>
</c:forEach>


<a href="/posts">Вернуться на главную</a>
</body>
</html>
