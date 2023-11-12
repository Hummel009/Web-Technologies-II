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
                    <span>${requestScope.book.getName()}</span>
                </h1>
                <div class="container">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="white-box text-left">
                                    <img alt="book-image"
                                         src="<c:url value="/${requestScope.book.getImagePath()}"/>"
                                         class="img-responsive bookImg">
                                </div>
                            </div>
                            <div class="desc">
                                <h4 class="box-title mt-5" id="lang-desc">Апісанне</h4>
                                <p>${requestScope.book.getDescription()}</p>
                                <a href="<c:url value="/cart/addBook/${requestScope.book.getId()}"/>"
                                   class="wds-button"><span
                                        id="lang-buy">Купіць</span> (${requestScope.book.getPrice()}$)</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>