<%@ page import="FunctionLayer.CustomerList" %>
<%@ page import="PresentationLayer.OrderList" %>
<%@ page import="FunctionLayer.LogicFacade" %>
<%@ page import="FunctionLayer.Orderline" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%!
    @Override
    public void jspInit() {
        //Fyr kode af til init. F.eks befolke datastruktur/lister etc.
        CustomerList.initLists();
        Orderline.initLists();
    }
%>
<%
    if (request.getServletContext().getAttribute("orderlist") == null) {
        request.getServletContext().setAttribute("orderlist", Orderline.orderList);
    }
    if (request.getServletContext().getAttribute("customerList") == null) {
        request.getServletContext().setAttribute("customerList", CustomerList.customerList);
    }
%>



<%@include file="../include/header.inc" %>

<h1 class="text-center mb-4 mt-4"> Administrator side </h1>
<div class="container col-lg-12">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-5">
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
                        <c:forEach var="order" items="${applicationScope.orderlist}">
                    <tr>
                        <td>
                            <form action="FrontController" method="post">
                                <input type="hidden" name="taget" value="deleteorder">
                                <button class="btn btn-danger btn-style deletebutton" name="deletebutton"
                                        value="${order.orderid}"> X
                                </button>
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

            <div class="mt-4">
                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="addcredit"/>
                    <div class="form-row">
                        <div>
                            <input type="text" name="saldo" class="form-control" placeholder="Indsæt saldo">
                        </div>
                        <div class="ml-4">
                            <input type="text" name="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-danger btn-style mt-4">
                        Opdater saldo
                    </button>
                </form>
            </div>
            <div class="alert alert-success mt-4 <c:if test = "${empty requestScope.message}">d-none</c:if> "
                 role="alert">
                ${requestScope.message}
            </div>

        </div>
        <div class="col-lg-5">
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
                        <c:forEach var="customer" items="${applicationScope.customerList}">
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
        <div class="col-lg-1"></div>
    </div> <!-- ROW -->
</div>

<%@include file="../include/footer.inc" %>