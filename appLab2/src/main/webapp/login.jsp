<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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
                    <span id="lang-enter">Уваход</span>
                </h1>
                <form class="p-3 mt-3" method="POST" action="<c:url value="/login"/>">
                    <div class="form-field d-flex align-items-center">
                        <label for="email"></label><input class="hstyle" type="email" name="email" id="email"
                                                          placeholder="Пошта">
                    </div>
                    <div class="errorInput">${requestScope.emailError}</div>
                    <div class="form-field d-flex align-items-center">
                        <label for="password"></label><input class="hstyle" type="password" name="password"
                                                             id="password"
                                                             placeholder="Пароль">
                    </div>
                    <div class="errorInput">${requestScope.passwordError}</div>
                    <button type="submit" class="wds-button" id="lang-enter">Уваход</button>
                </form>
                <div class="text-center fs-6">
                    <div id="lang-noacc">Няма аккаўнта?</div>
                    <a href="<c:url value="/registration"/>" class="wds-button" id="lang-register">Рэгістрацыя</a>
                </div>
                <div class="text-center fs-6">
                    <span class="status">${requestScope.status}</span>
                </div>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>