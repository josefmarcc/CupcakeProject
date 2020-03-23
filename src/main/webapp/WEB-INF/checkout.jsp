<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../include/header.inc" %>


<h1 class="text-center mb-4 mt-4"> Din kurv </h1>

<div class="container col-lg-12">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-lg-5">
            <div class="table-wrap">
                <table class="table table-borderless table.responsive">
                    <thead>
                    <tr>
                        <th scope="col">Slet ordre</th>
                        <th scope="col">Topping</th>
                        <th scope="col">Bund</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Pris</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <!-- https://www.codejava.net/java-ee/jsp/how-to-list-records-in-a-database-table-using-jsp-and-jstl -->
                        <c:forEach var="cupcake" items="${sessionScope.basketlist}" varStatus="loop">
                    <tr>
                        <td>
                            <form action="FrontController" method="post">
                                <input type="hidden" name="taget" value="deletecupcake">
                                <button class="btn btn-danger btn-style deletebutton" name="deletebutton"
                                        value="${cupcake}"> X</button>
                            </form>
                        </td>
                        <td><c:out value="${cupcake.top.name}"/></td>
                        <td><c:out value="${cupcake.bottom.name}"/></td>
                        <td><c:out value="${sessionScope.qtyList.get(loop.index)}"/></td>
                        <td><c:out value="${sessionScope.priceList.get(loop.index)} kr"/></td>
                    </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-1"></div>
        <div class="col-lg-3">
            <div class="overskrift-size ">
                Total pris:
            <p><span class="price"><b>${sessionScope.basketprice} kr,-</b></span></p>
            </div>
            <form action="FrontController" method="post" name="payment">
                <input type="hidden" name="taget" value="payment">
                <input type="submit" class="btn btn-danger btn-style mt-2" value="Betal">
            </form>

        </div>
        <div class="col-lg-1"></div>
    </div>
</div>
</div>

<%@include file="../include/footer.inc" %>
