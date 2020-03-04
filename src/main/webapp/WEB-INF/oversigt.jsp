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

<td>Opret ny employee</td>
<td>
    <form name="removecustomer" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="removecustomer">
        Email:<br>
        <input type="text" name="email" value="someone@nowhere.com">
        <br>
        <input type="submit" value="Submit">
    </form>
</td>
</tr>





</body>
</html>
