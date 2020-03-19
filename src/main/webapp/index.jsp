<%@ page import="FunctionLayer.ToppingsBottoms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%!
    @Override
    public void jspInit() {
        //Fyr kode af til init. F.eks befolke datastruktur/lister etc.
        ToppingsBottoms.initLists();
    }
%>
<%
    if (request.getServletContext().getAttribute("toppings") == null) {
        request.getServletContext().setAttribute("toppings", ToppingsBottoms.getToppingsList());
    }
    if (request.getServletContext().getAttribute("bottoms") == null) {
        request.getServletContext().setAttribute("bottoms", ToppingsBottoms.getBottomsList());
    }
%>
<%@include file="include/header.inc" %>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-3">
        <div class="overskrift-size ml-5 mb-3">
            Lav din cupcake:
        </div>


        <div class="dropdown">
            <button id="btn1" name="toppingname" class="dropbtn btn-danger btn-style mb-2 btn-block">Topping
            </button>
            <div class="dropdown-content">
                <c:forEach var="topping" items="${toppings}">
                    <button class="dropdown-item" value="${topping.id}"
                            onclick="doSelect('${topping.name}','btn1')">${topping.name}</button>
                </c:forEach>
            </div>
        </div>

        <div class="dropdown">
            <button id="btn2" name="bottomname" class="dropbtn btn-danger btn-style mb-2 ml-4 btn-block">Bund
            </button>
            <div class="dropdown-content ml-4 ">
                <c:forEach var="bottom" items="${bottoms}">
                    <button class="dropdown-item" value="${bottom.id}"
                            onclick="doSelect('${bottom.name}','btn2')">${bottom.name}</button>
                </c:forEach>
            </div>
        </div>

        <script>
            function doSelect(text, btn) {
                var myElement = document.getElementById(btn);
                myElement.innerText = text;
            }
        </script>
    </div>

    <div class="col-lg-4">

        <svg class="cat" version="1.1" id="Lag_1" xmlns="http://www.w3.org/2000/svg"
             xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
             viewBox="0 0 2834.6 2834.6" style="enable-background:new 0 0 2834.6 2834.6;" xml:space="preserve">

<path id="XMLID_301_" class="top-color" d="M1757.5,449.5c82.1,58.7,135.2,149.8,145.7,250.2c4.9,47.2,7.5,91.6,8.1,117.2
   c0.7,28.9,13.3,37.1,41.2,35.5c180.3-10.8,342,79.7,412.9,241.8c64.4,147.2,46.4,289.7-52.8,418.9c-92.1,119.9-219.5,160-364.4,160
   c-188.8,0-377.5,0-566.3,0c0-0.1,0-0.1,0-0.2c-186.5,0-372.9,0.8-559.4-0.3c-85.7-0.5-169.7-10.1-244.9-58.4
   c-129.7-83.2-196.1-200.5-191.5-354.8c5.9-194,141.1-327.3,312.2-375.1c22.8-6.4,47.9-5,72-6.4c35.4-2.1,43-8.9,30.8-42.3
   c-3.6-9.9-6.3-23.2-8.3-38.6C774.9,653.6,847.3,514.2,974,445.1l46.1-25.1c51.8-28.2,109.8-43,168.7-43H1543
   c73.5,0,145.1,23,204.9,65.7L1757.5,449.5z M968.3,1260.9c40.4-24.4,79.2-45.7,115.1-71.1c7.4-5.2,10.4-30.6,4.5-37.3
   c-9.3-10.8-31.4-22.7-41.5-18.5c-36.6,15.4-71.6,35.7-104.6,58c-8.5,5.8-12.9,27.8-9.1,38.7C936.8,1242,953.2,1248.9,968.3,1260.9z
    M727.7,1406.8c-3.1-5.1-7.5-17.6-16.1-25.4c-24.6-22.1-50.6-42.8-76.7-63.2c-16.9-13.2-34-11.9-49.3,3.6
   c-16.2,16.5-13.7,34,1.6,48.3c27.5,25.7,55.2,51.5,85.3,73.8C696.4,1461.6,727.7,1443.1,727.7,1406.8z M1690.8,1416.7
   c-7.7-9.4-14.2-24.5-24.5-28c-12-4-31.1-2.7-40.6,4.7c-27.7,21.8-54.2,46-76.8,72.9c-8,9.6-9.4,33.3-3.1,44.5
   c10,17.8,30.3,25.3,49.4,8.1c28-25.1,55.4-50.8,82.4-77.1C1683,1436.7,1685,1428.1,1690.8,1416.7z M2022,1153.1
   c-1.4-3.5-2.1-13.9-7.5-17.6c-34.6-24.2-69.2-49-106.3-68.8c-8.2-4.3-31.7,7.3-38.8,17.9c-5.8,8.6-2.5,33,5.5,39.3
   c31.3,24.8,65.1,47,100,66.5C1996.4,1202.4,2022.4,1182.3,2022,1153.1z M944.1,1484.8c24.1-0.1,47-22.2,46.9-45.3
   c0-23.7-26-49.5-48.9-48.7c-22.8,0.8-44.8,25-44,48.3C899,1464.8,919.2,1484.9,944.1,1484.8z M648.1,1183.5
   c23.8-0.7,47.3-24.1,46.6-46.3c-0.7-21.4-26.3-45.8-48.3-46c-24.4-0.3-48.7,25-47.2,49.2C600.5,1164.8,622.7,1184.3,648.1,1183.5z
    M1159.5,875.7c0.3-24.1-20.8-47.2-43.9-48.1c-23-0.9-45.5,21.1-46.5,45.6c-1.1,26.3,20.9,50.4,45.5,49.8
   C1138.2,922.4,1159.1,900.4,1159.5,875.7z M1326.2,1305.8c-24.5,0.7-44.4,21.9-44.3,47.2c0.1,22.8,23.5,47.3,45.1,47.3
   c21.6-0.1,49.7-27.6,49.8-48.8C1377,1328.5,1351,1305,1326.2,1305.8z M2097.4,1398.3c1.4-25.5-17.3-46.6-42.9-48.2
   c-23.5-1.4-48.2,19.8-49.9,42.8c-1.6,22.3,20.7,46.5,44.4,48.1C2073.8,1442.8,2096,1423.1,2097.4,1398.3z M1714.5,926.5
   c0.6-24.7-19.5-47.8-42.8-49.2c-23.7-1.4-49.5,23.1-49.4,46.9c0.1,21.5,24.7,47.2,45.8,48C1690.3,973,1713.9,949.8,1714.5,926.5z"></path>

            <path id="XMLID_300_" class="bottom-color" d="M1372,2570.5c-197.9,0-395.8-0.8-593.7,0.7c-35.9,0.3-55.3-10.5-63.5-46.3
   c-20.5-89.6-43.2-178.7-64.8-268.1c-37.7-156.4-75.1-312.9-113.1-469.3c-7.3-30.1,10.2-73.1,40.1-80.8c11.4-2.9,29.5,7.2,40,16.5
   c28.1,24.6,36.3,26,60.9-2c19.8-22.5,37.2-21,58.1-0.8c31.5,30.5,36.2,30,65.9-2c17.7-19.1,33.7-19.9,52.5-0.9
   c32.9,33.1,37.6,33.6,68.7,0.4c21.5-23,37.9-19.9,56.6,2.4c23.9,28.7,34.4,28.7,61,3.1c30-28.8,36-29,63.4,1.5
   c19.1,21.3,36.3,25,56.8,0.8c25.6-30.2,37.6-31.3,63.6-2.3c23.8,26.6,41.6,21.9,61.4-3c17.2-21.5,34.8-21.2,55.1-1.4
   c32.9,32.1,37.2,31.6,68.9-1.5c18.5-19.3,34.6-17.9,52.6,0.7c30.8,31.9,36.3,32.6,65.9,1.1c22.3-23.7,39.4-21.8,59.3,1.9
   c23,27.5,33.5,27,60.5,0.7c26.2-25.6,35.9-25.4,62,1.6c25.3,26.1,35.7,26.2,60.2-2.2c19.1-22.1,36.2-22.4,57.6-2.1
   c33.1,31.3,34,30.4,67.6-3.2c17.2-17.2,32.8-16.3,50.4,0.9c34.8,34,38.9,33.9,71.2-0.9c20.7-22.4,37.3-17.5,53.5,4.1
   c17.4,23.2,35.5,31.3,59.2,6.5c12.3-12.8,22.3-34.5,48-19.9c27.2,15.5,45.4,46.4,39.1,73.5c-6.5,27.9-14.9,55.4-21.7,83.3
   c-47.4,194.3-94.7,388.6-141.7,583c-5.9,24.6-9.8,49.7-15.2,74.3c-7.3,33.2-24.6,49.8-62.4,49.5c-201.3-1.6-402.7-0.8-604.1-0.8
   C1372,2570,1372,2570.2,1372,2570.5z"></path>
</svg>

    </div>
    <div class="col-lg-3">
        <div class="overskrift-size">
            Antal cupcakes til bestilling:
        </div>

        <div class="form-group">
            <label for="exampleFormControlSelect1">Vælg antal</label>
            <select class="form-control" name="qty" id="exampleFormControlSelect1">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
        </div>

        <form action="FrontController" method="POST">
            <input type="hidden" name="taget" value="addToBasket"/>
            <button type="input" class="btn btn-danger btn-style mt-2 mr-4">Læg i kurv</button>
            <div class="overskrift-size mt-5">
                Total pris: ${requestScope.totalprice} kr
            </div>
        </form>
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