<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@include file="../include/header.inc" %>




<div class="container col-lg-12">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <h1>Opret bruger</h1>
            <table class="table table-borderless table.responsive">
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="register">
                        Email:<br>
                        <input type="text" name="email" class="form-control" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" class="form-control" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" class="form-control" value="sesam">
                        <br>
                        <input type="submit" class="btn btn-danger btn-style mt-2" value="Submit">
                    </form>
                </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
