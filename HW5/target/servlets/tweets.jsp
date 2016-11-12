<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 07.11.16
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
</head>
<body>

<h1>Twitter</h1>

<form action="/twitter" method="post">
    <label>Ваше сообщение: </label>
    <input type="text" name="message">
    <input type="submit">
</form>


<br>
<c:if test="${tweets.isEmpty()}">
    <p>Ничего пока нету :(</p>
</c:if>

<c:forEach items="${tweets}" var="tweet">
    <p>${tweet.message}</p>
    <p>${tweet.createdAt}</p>
    <form action="/twitter/del" method="post" >
        <input type="hidden" name="id" value="${tweet.id}" >
        <input type="submit" value="Удалить">
    </form>

    <form action="/twitter/com" method="post" >
        <label>Комментарии: </label>
    <c:forEach items=" ${tweet.commentsMessage}" var="comment">
        <p>${comment}</p>
        </c:forEach>
        <input type="text" name="commentMessage">
        <input type="hidden" name="idComment" value="${tweet.id}" >
        <input type="submit" value="Добавить">
    </form>
    <hr>
</c:forEach>

</body>
</html>
