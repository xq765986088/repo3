<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>用户姓名</h3>
    <c:forEach var="account" items="${list}">
        ${account.name}<br/>
    </c:forEach>
</body>
</html>
