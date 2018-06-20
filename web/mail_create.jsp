<%--
  Created by IntelliJ IDEA.
  User: wilder
  Date: 19/06/18
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/mailcreate">
    <label for="fromid">From : </label>
    <input id="fromid" type="text" name="from" placeholder="from@mail.fr">
<br>
    <label for="toId">To : </label>
    <input id="toId" type="text" name="to" placeholder="to@mail.fr">
<br>
    <label for="content">To : </label>
    <textarea id="content" type="text" name="content" placeholder="your content here..."></textarea>
    <br>

    <input type="submit" value="Send"/>


</form>


</body>
</html>
