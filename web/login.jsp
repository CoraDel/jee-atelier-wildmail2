<%--
  Created by IntelliJ IDEA.
  User: bastienwcs
  Date: 07/06/18
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

    <c:if test="${not empty requestScope.error}">
        <p>${error}</p>
    </c:if>


    <form method="post" action="${pageContext.request.contextPath}/login">
        <label for="emailId">Email : </label>
        <input id="emailId" name="emailValue" type="text" placeholder="email@here.com" />
        <br />
        <input type="submit" />
    </form>
</body>
</html>
