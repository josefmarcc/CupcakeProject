<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        

        <h1>Hello ${sessionScope.email} </h1>



        You are now logged in as a EMPLOYEE of our wonderful site.

        <br>
        <br>

<h1> tryk her for at komme ind på oversigt</h1>
        <form name="customerlist" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="customerlist">
            <input type="submit" value="Tryk her for at gå til oversigt">
        </form>

<br>
<br>


        <td>Opret ny employee</td>
        <td>
            <form name="newemployee" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="newemployee">
                Email:<br>
                <input type="text" name="email" value="someone@nowhere.com">
                <br>
                Password:<br>
                <input type="password" name="password1" value="sesam">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="sesam">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        </tr>

    <br>
    <br>

        td>Logout</td>
        <td>
            <form name="logout" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="logout">
                <input type="submit" value="logout">
            </form>
        </td>
        </tr>








    </body>
</html>
