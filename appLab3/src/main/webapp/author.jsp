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
                    <span id="lang-list">Творы аўтара</span>
                </h1>
                <div class="row">
                    <c:forEach items="${requestScope.authorBooks}" var="book">
                        <div class="card card-text card-button">
                            <div>
                                <img src="<c:url value="/${book.getImagePath()}"/>" class="card-img-top">
                            </div>
                            <div class="card-body">
                                <div><span class="card-text" id="lang-price">Кошт</span><span
                                        class="card-text">: ${book.getPrice()}$</span></div>
                                <div><a href="<c:url value="/books/${book.getId()}"/>"
                                        class="wds-button" id="lang-view">Праглядзець</a></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <nav class="pagination-nav">
                    <ul class="pagination">
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/authors/${requestScope.authorName}/paging?pageNumber=${sessionScope.bookPagingParams.getPageNumber() - 1}"/>"><<</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/authors/${requestScope.authorName}/paging?pageNumber=0"/>">1</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/authors/${requestScope.authorName}/paging?pageNumber=1"/>">2</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/authors/${requestScope.authorName}/paging?pageNumber=2"/>">3</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/authors/${requestScope.authorName}/paging?pageNumber=${sessionScope.bookPagingParams.getPageNumber() + 1}"/>">>></a>
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