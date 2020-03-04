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

Customer list:
<c:forEach var="element" items="${sessionScope.customerlist}">

    <br>
    ${element}
    <br>

</c:forEach>

<br>
<br>


<h1> Customer amount: ${sessionScope.antalKunder} </h1>

<br>
<br>

<td>Remove customer</td>
<td>
    <form name="removecustomer" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="removecustomer">
        Email:<br>
        <input type="text" name="email" value="someone@nowhere.com">
        <br>
        <input type="submit" value="Delete customer">
    </form>
</td>
</tr>

<br>
<br>

<td>Change password</td>
<td>
    <form name="changepassword" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="changepassword">
        Email:<br>
        <input type="text" name="email" value="someone@nowhere.com">
        <br>
        New password:<br>
        <input type="text" name="password" value="someone@nowhere.com">
        <br>
        <input type="submit" value="Change password">
    </form>
</td>
</tr>





</body>
</html>
