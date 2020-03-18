
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
        <a class="navbar-brand" href="#">OLESKER CUPCAKES</a>
        <ul class="navbar-nav ml-auto">
            <!-- https://www.tutorialrepublic.com/snippets/preview.php?topic=bootstrap&file=navbar-dropdown-login-and-signup-form-with-social-buttons -->
            <li class="nav-item ">
            <a class="nav-link">${sessionScope.email} </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link"> ${sessionScope.credit} </a>
            </li>

                <a data-toggle="dropdown" class="nav-link dropdown-toggle  " href="#">LOGIN</a>
                <ul class="dropdown-menu form-wrapper dropdown-menu-right mydropdown">
                    <li>
                        <form name="login" action="FrontController" method="POST">
                            <div class="form-group ml-2 mr-2">
                            <input type="hidden" name="taget" value="login">
                                <input type="text" class="form-control" name="email" placeholder="Email" required="required">
                            </div>
                            <div class="form-group ml-2 mr-2">
                                <input type="password" class="form-control" name="password" placeholder="Kodeord" required="required">
                            </div>
                            <div class="form-footer text-center">
                                <input type="submit" class="btn btn-danger btn-style " value="Login">

                            </div>
                            <div class="form-footer text-center">
                                <input type="hidden" name="taget" value="register">
                                <input type="submit" class="btn btn-danger btn-style " value="Ny bruger">
                            </div>

                        </form>
                    </li>
                </ul>
            </li>
            </li>
            <li class="nav-item ">
                <a class="nav-link " href="FrontController?taget=redirect&modtagerside=checkout">KURV</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="FrontController?taget=redirect&modtagerside=admin">ADMIN</a>
<!--                <form name="admin" action="FrontController" method="POST">
                    <input type="hidden" name="taget" value="orderlist">
                    <input type="submit" class="navbarButton" value="ADMIN"/>
                </form>-->
            </li>

        </ul>
    </nav>