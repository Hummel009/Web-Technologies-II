<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html class="" lang="ru" dir="ltr">
<jsp:include page="include/head.jsp"/>
<body>
<jsp:include page="include/global-nav.jsp"/>
<div class="main-container">
    <div class="page-background"></div>
    <div class="page-container">
        <jsp:include page="include/header.jsp"/>
        <div class="page has-right-rail">
            <main class="page-main">
                <h1>
                    <span id="lang-cart">Кош</span>
                </h1>
                <div class="cart-info">
                    <div>
                        <span id="lang-sum">Сумарны кошт</span><span>: ${sessionScope.cart.getSummaryPrice()}$</span>
                    </div>
                    <div>
                        <a href="<c:url value="/cart/makeOrder"/>" id="lang-order" class="wds-button">Аформіць
                            заказ</a>
                        <a href="<c:url value="/cart/clear"/>" id="lang-clear" class="wds-button">Ачысціць</a>
                    </div>
                    <div>
                        <span style="color: ${requestScope.color}">${requestScope.status}</span>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${sessionScope.cart.getBooks()}" var="book">
                        <div class="card card-text card-button">
                            <div>
                                <img src="<c:url value="/${book.getImagePath()}"/>" class="card-img-top">
                            </div>
                            <div class="card-body">
                                <div><span class="card-text" id="lang-price">Кошт</span><span
                                        class="card-text">: ${book.getPrice()}$</span></div>
                                <div><a href="<c:url value="/cart/removeBook/${book.getId()}"/>"
                                        class="wds-button" id="lang-remove">Выдаліць</a></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>