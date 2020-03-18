<%@ page import="FunctionLayer.CustomerList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%!
    @Override
    public void jspInit(){
        //Fyr kode af til init. F.eks befolke datastruktur/lister etc.
        CustomerList.initLists();
    }
%>
<%
    request.setAttribute("customers", CustomerList.getCustomerList());
%>
<%@include file="../include/header.inc"%>

    <h1 class="text-center mb-4 mt-4"> Administrator side </h1>
    <div class="container col-lg-12">
        <div class="row">
            <div class="col-lg-4" >
                <div class="table-wrap">
                    <table class="table table-borderless table.responsive">
                        <thead>
                        <tr>
                            <th scope="col">Slet ordre</th>
                            <th scope="col">Topping</th>
                            <th scope="col">Bund</th>
                            <th scope="col">Orderid</th>
                            <th scope="col">Total</th>
                            <th scope="col">Antal</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                                <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                            <c:forEach var="order" items="${requestScope.orderlist}">
                        <tr>
                            <td>
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="taget" value="deleteorder" >
                                    <button class="btn btn-danger btn-style deletebutton" name="deletebutton" value="${order.orderid}"> X</button>
                                </form>
                            </td>
                            <td><c:out value="${order.getToppingName(order.toppingid)}"/></td>
                            <td><c:out value="${order.getBottomName(order.bottomid)}"/></td>
                            <td><c:out value="${order.orderid}"/></td>
                            <td><c:out value="${order.sum} kr"/></td>
                            <td><c:out value="${order.qty}"/></td>
                        </tr>
                        </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>

            <div class="col-lg-4" >
                <div class="table-wrap">
                    <table class="table table-borderless table.responsive">
                        <thead>
                        <tr>
                            <th scope="col">Kunde id</th>
                            <th scope="col">Email</th>
                            <th scope="col">Kodeord</th>
                            <th scope="col">Balance</th>
                            <th scope="col">Role</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                            <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td><c:out value="${customer.id}"/></td>
                            <td><c:out value="${customer.email}"/></td>
                            <td><c:out value="${customer.password}"/></td>
                            <td><c:out value="${customer.credit} kr"/></td>
                            <td><c:out value="${customer.role}"/></td>
                        </tr>
                        </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="col-lg-4" >
                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="addcredit"/>
                    <div class="form-row">
                        <div class="col-5">
                            <input type="text" name="saldo" class="form-control" placeholder="Indsæt saldo">
                        </div>
                        <div class="col-5">
                            <input type="text" name="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-danger btn-style mt-4">
                        Opdater saldo
                    </button>
                </form>
            </div>
        </div> <!-- row -->

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