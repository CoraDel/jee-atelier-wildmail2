<%--
  Created by IntelliJ IDEA.
  User: bastienwcs
  Date: 11/06/18
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My email list</title>
</head>
<body>
<h1>Emails</h1>
<ul>
    <!-- TODO : show emails here -->
    <c:forEach items="${requestScope.mails}" var="eachMail">
<li> From : ${eachMail.from}, To :${eachMail.to} , Content :${eachMail.content}
    <a href="${pageContext.request.contextPath}/mailcontent?id=${eachMail.id}">Open</a> </li><br>

    </c:forEach>


</ul>
</body>
</html>
