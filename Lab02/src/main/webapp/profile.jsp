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
                    <span id="lang-profile">Профіль</span>
                </h1>
                <div class="infoblock">
                    <div class="media">
                        <label id="lang-username">Імя:</label>
                        <p>${sessionScope.user.getName()}</p>
                    </div>
                    <div class="media">
                        <label id="lang-usersurname">Прозвішча:</label>
                        <p>${sessionScope.user.getLastName()}</p>
                    </div>
                    <div class="media">
                        <label id="lang-usermail">Пошта:</label>
                        <p>${sessionScope.user.getEmail()}</p>
                    </div>
                    <div class="media">
                        <label id="lang-usermoney">Грошы:</label>
                        <p>${sessionScope.user.getBalance()}$</p>
                    </div>
                </div>
                <div class="infoblock">
                    <div class="media">
                        <label id="lang-userbirth">Дата нараджэння:</label>
                        <p>${sessionScope.user.getBirthDateFormatted()}</p>
                    </div>
                    <c:choose>
                        <c:when test="${sessionScope.user.getAddress() != null && sessionScope.user.getPhoneNumber() != null}">
                            <div class="media">
                                <label id="lang-useraddress">Адрас:</label>
                                <p>${sessionScope.user.getAddress()}</p>
                            </div>
                            <div class="media">
                                <label id="lang-userphone">Тэлефон:</label>
                                <p>${sessionScope.user.getPhoneNumber()}</p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form method="POST" action="<c:url value="/profile"/>">
                                <div class="media">
                                    <label id="lang-useraddress" for="address">Адрас</label>
                                    <div>
                                        <input class="info-input hstyle" type="text"
                                               name="address"
                                               id="address"
                                               placeholder="Адрас">
                                    </div>
                                    <div class="errorInput">${requestScope.addressError}</div>
                                </div>
                                <div class="media">
                                    <label id="lang-userphone" for="phoneNumber">Тэлефон</label>
                                    <div>
                                        <input class="info-input hstyle" type="tel"
                                               name="phoneNumber"
                                               id="phoneNumber"
                                               placeholder="Тэлефон">
                                    </div>
                                    <div class="errorInput">${requestScope.phoneNumberError}</div>
                                </div>
                                <button id="lang-usersave" class="wds-button" type="submit">
                                    Захаваць
                                </button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="infoblock">
                    <div class="media">
                        <label id="lang-userregister" class="m-0px font-w-600">Дата рэгістрацыі:</label>
                        <p class="count h2" data-to="500"
                           data-speed="500">${sessionScope.user.getRegisterDateFormatted()}
                        </p>
                    </div>
                    <div class="media">
                        <label id="lang-userorders" class="m-0px font-w-600">Колькасць заказаў:</label>
                        <p class="count h2" data-to="150"
                           data-speed="150">${sessionScope.user.getOrdersQuantity()}</p>
                    </div>
                    <div class="media">
                        <label id="lang-userbooks" class="m-0px font-w-600">Колькасць кніг:</label>
                        <p class="count h2" data-to="850"
                           data-speed="850">${sessionScope.user.getBooksQuantity()}</p>
                    </div>
                    <div class="media">
                        <label id="lang-userauthor" class="m-0px font-w-600">Абраны аўтар:</label>
                        <p class="count h2" data-to="190"
                           data-speed="190">${sessionScope.user.getFavouriteAuthor()}</p>
                    </div>
                </div>
                <c:forEach items="${requestScope.orders}" var="order">
                    <div class="history">
                        <div class="order-data">
                            <span id="lang-orderword">Заказ</span><span> №${order.getId()} | </span><span>${order.getDateFormatted()} | </span>
                            <span id="lang-sum">Сумарны кошт</span><span>: ${order.getPrice()}$</span>
                        </div>
                        <div class="row">
                            <c:forEach items="${order.getBooks()}" var="book">
                                <div class="card card-text">
                                    <div>
                                        <img src="<c:url value="/${book.getImagePath()}"/>" class="card-img-top">
                                    </div>
                                    <div class="card-body">
                                        <div><span id="lang-price" class="card-text">Кошт</span><span
                                                class="card-text">: ${book.getPrice()}$</span></div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
                <nav class="pagination-nav">
                    <ul class="pagination">
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/profile/paging?pageNumber=${sessionScope.orderPagingParams.getPageNumber() - 1}"/>"><<</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/profile/paging?pageNumber=0"/>">1</a></li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/profile/paging?pageNumber=1"/>">2</a></li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/profile/paging?pageNumber=2"/>">3</a></li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/profile/paging?pageNumber=${sessionScope.orderPagingParams.getPageNumber() + 1}"/>">>></a>
                        </li>
                    </ul>
                </nav>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>