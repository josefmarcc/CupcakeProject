<%@ page import="FunctionLayer.ToppingsBottoms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%!
    @Override
    public void jspInit(){
        //Fyr kode af til init. F.eks befolke datastruktur/lister etc.
        ToppingsBottoms.initLists();
    }
%>
<%
    request.setAttribute("toppings", ToppingsBottoms.getToppingsList());
    request.setAttribute("bottoms", ToppingsBottoms.getBottomsList());
%>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">

    <title>Cupcake</title>
</head>
<body>
<div class="container col-lg-12">

    <img src="images/header.png" class="img-fluid"/>

    <nav class="navbar-expand-lg navbar">
        <a class="navbar-brand" href="#">Olesker Cupcakes</a>
        <ul class="navbar-nav ml-auto">
            <!-- https://www.tutorialrepublic.com/snippets/preview.php?topic=bootstrap&file=navbar-dropdown-login-and-signup-form-with-social-buttons -->
            <li class="nav-item ">
                <a data-toggle="dropdown" class="nav-link dropdown-toggle  " href="#">LOGIN</a>
                <ul class="dropdown-menu form-wrapper dropdown-menu-right mydropdown">
                    <li>
                        <form action="frontcontroller" method="post">
                            <div class="form-group ml-2 mr-2">
                                <input type="text" class="form-control" placeholder="Brugernavn" required="required">
                            </div>
                            <div class="form-group ml-2 mr-2">
                                <input type="password" class="form-control" placeholder="Kodeord" required="required">
                            </div>
                            <div class="form-footer text-center">
                                <input type="submit" class="btn btn-danger btn-style " value="Login">
                            </div>
                            <div class="form-footer text-center">
                                <a href="#">Ny bruger? Registrer dig her</a>
                            </div>

                        </form>
                    </li>
                </ul>
            </li>
            </li>
            <li class="nav-item ">
                <a class="nav-link " href="#">KURV</a>
            </li>

            <li class="nav-item">
                <form name="admin" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="orderlist">
                    <input type="submit" class="navbarButton" value="ADMIN"/>
                </form>
            </li>

        </ul>
    </nav>

    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-3">
            <div class="overskrift-size ml-5 mb-3">
                Lav din cupcake:
            </div>


            <div class="dropdown">
                <button id="btn1" class="dropbtn btn-danger btn-style mb-2 btn-block">Topping</button>
                <div class="dropdown-content">
                    <c:forEach var="topping" items="${toppings}">
                        <a class="dropdown-item" onclick="doSelect('${topping.name}','btn1')">${topping.name}</a>
                    </c:forEach>
                </div>
            </div>

            <div class="dropdown">
                <button id="btn2" class="dropbtn btn-danger btn-style mb-2 ml-4 btn-block">Bund</button>
                <div class="dropdown-content ml-4 ">
                    <c:forEach var="bottom" items="${bottoms}">
                        <a class="dropdown-item" onclick="doSelect('${bottom.name}','btn2')">${bottom.name}</a>
                    </c:forEach>
                </div>
            </div>

            <script>
                function doSelect(text,btn){
                    var myElement = document.getElementById(btn);
                    myElement.innerText = text;
                }
            </script>
        </div>


        <div class="col-lg-4">
            <img src="images/cupcake.png" class="img-fluid mb-5"/>
        </div>


        <div class="col-lg-3">
            <div class="overskrift-size">
                Antal cupcakes til bestilling:
            </div>
            <label for="validationDefault04"></label>
            <select class="custom-select" id="validationDefault04" required>
                <option selected disabled value="">Vælg antal...</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
            </select>
            <button type="button" class="btn btn-danger btn-style mt-2 mr-4">Læg i kurv</button>
            <button type="button" class="btn btn-danger btn-style mt-2">Fortryd</button>
        </div>
        <div class="col-lg-1"></div>
    </div>

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>