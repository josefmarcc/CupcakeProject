<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: josef
  Date: 02-03-2020
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<br>
<br>

Other employees:
<c:forEach var="element" items="${sessionScope.customerlist}">

    <br>
    ${element}
    <br>

</c:forEach>



</body>
</html>
