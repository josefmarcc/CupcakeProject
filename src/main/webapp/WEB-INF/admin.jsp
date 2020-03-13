<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Link til vores CSS -->
    <link rel="stylesheet" href="styles.css">

    <title>Cupcake admin</title>
</head>
<body>
<div class="container col-lg-12">

    <img src="hæv2.png" class="img-fluid"/>

    <nav class="navbar-expand-lg navbar">
        <a class="navbar-brand" href="#">Olesker Cupcakes management</a>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item ">
                <a class="nav-link" href="#">LOGIN</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="#">KURV</a>
            </li>
        </ul>
    </nav>

    <h1 class="text-center mb-4 mt-4"> Administrator side </h1>
    <div class="container">
        <div class="row">
            <div class="col-1" ></div>
            <div class="col-4" >
                <div class="table-wrap">
                    <table class="table table-borderless table.responsive">
                        <thead>
                        <tr>
                            <th scope="col">Ordre</th>
                            <th scope="col">Topping</th>
                            <th scope="col">Bund</th>
                            <th scope="col">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">1</label>
                                </div>
                                <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                            </td>
                            <c:forEach var="order" items="${requestScope.orders}">
                        <tr>
                            <td><c:out value="${order.topping}" /></td>
                            <td><c:out value="${order.buttom}" /></td>
                            <td><c:out value="${order.email}" /></td>
                        </tr>
                        </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <button type="button" class="btn btn-danger btn-style mt-2">
                    Slet ordre
                </button>
            </div>
            <div class="col-2" ></div>
            <div class="col-5" >
                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="opdatersaldo"/>
                    <div class="form-row">
                        <div class="col-5">
                            <input type="text" name="saldo" class="form-control" placeholder="Indsæt saldo">
                        </div>
                        <div class="col-5">
                            <input type="text" name="brugernavn" class="form-control" placeholder="Brugernavn">
                        </div>
                    </div>
                    <button type="button" class="btn btn-danger btn-style mt-4">
                        Opdater saldo
                    </button>
                </form>



            </div>
        </div> <!-- row -->

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