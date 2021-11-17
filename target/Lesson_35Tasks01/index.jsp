<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Purchase</title>

</head>
<body>

<c:choose>
<%--    <c:when test="${not empty purchases}">--%>
<%--&lt;%&ndash;<c:when test="${not empty exceptionMessage}">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <p style="color: #ff0000">${exceptionMessage}</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:when>&ndash;%&gt;--%>
<%--<c:otherwise>--%>
<%--<c:choose>--%>
<c:when test="${not empty purchases}">
        <table>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Sum</th>
            </tr>

            <c:forEach var="purchase" items="${purchases}">
                <tr>
<%--                    <td>${purchase.id}</td>--%>
                    <td>${purchase.name_purchase}</td>
                    <td>${purchase.price_purchase}</td>
                    <td>${purchase.sum_purchase}</td>
                    <td>
                        <input type="checkbox" name="ids" form="deleteForm" value="${purchase.id}">
                    </td>
                </tr>
            </c:forEach>

            </c:when>
            <c:otherwise>
                <p style="color: red">Пока не добавлено ни одной покупки</p>
            </c:otherwise>
            </c:choose>
            <form method="post" action="/add.jsp", loadOnStartup = 1>
                <input class="input" type="submit" value="Добавить">
            </form>
            <form id="deleteForm" method="post" action="/RemovePurchaseController">
                <input class="input" type="submit" value="Удалить">
            </form>
            <form method="post" action="/SortPurchaseController">
                <div class="sort">
                    <div class="radios_input">
                        <input type="submit" value="Сортировать">
                    </div>
                    <div class="radios">
                        <div class="group1">
                            <div class="radioGroup">
                                <p>По имени: </p>
                                <input type="radio" name="radio" value="name">
                            </div>
                            <div class="radioGroup">
                                <p>По количеству: </p>
                                <input type="radio" name="radio" value="number">
                            </div>
                            <div class="radioGroup">
                                <p>По цене: </p>
                                <input type="radio" name="radio" value="price">
                            </div>
                        </div>
                        <div class="group2">
                            <div class="radioGroup">
                                <p>По возрастанию: </p>
                                <input type="radio" name="radioSortChoose" value="asc">
                            </div>
                            <div class="radioGroup">
                                <p>По убыванию: </p>
                                <input type="radio" name="radioSortChoose" value="desc">
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </form>
<%--            </c:otherwise>--%>
<%--            </c:choose>--%>





        </table>


<%--    <c:otherwise>--%>
<%--        <p style="color: #ff0000">${message}</p>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>

</body>
</html>
