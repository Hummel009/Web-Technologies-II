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
                    <span id="lang-register">Рэгістрацыя</span>
                </h1>
                <form class="p-3 mt-3 js-form" method="POST" action="<c:url value="/registration"/>">
                    <div class="form-field d-flex align-items-center">
                        <label for="name"></label><input type="text" class="js-input hstyle" name="name" id="name"
                                                         placeholder="Імя">
                    </div>
                    <div class="errorInput">${requestScope.nameError}</div>
                    <div class="form-field d-flex align-items-center">
                        <label for="lastName"></label><input type="text" class="js-input hstyle" name="lastName"
                                                             id="lastName"
                                                             placeholder="Прозвішча">
                    </div>
                    <div class="errorInput">${requestScope.lastNameError}</div>
                    <div class="form-field d-flex align-items-center">
                        <label for="email"></label><input type="email" class="js-input hstyle" name="email" id="email"
                                                          placeholder="Пошта">
                    </div>
                    <div class="errorInput">${requestScope.emailError}</div>
                    <div class="form-field d-flex align-items-center">
                        <label for="password"></label><input type="password" class="js-input hstyle" name="password"
                                                             id="password" placeholder="Пароль">
                    </div>
                    <div class="errorInput">${requestScope.passwordError}</div>
                    <div class="form-field d-flex align-items-center">
                        <label for="birthDate"></label><input type="text" class="js-input hstyle" name="birthDate"
                                                              id="birthDate" placeholder="Дата нараджэння"
                                                              onfocus="(this.type='date')">
                    </div>
                    <div class="errorInput">${requestScope.birthDateError}</div>
                    <button type="submit" class="wds-button" id="lang-register">Рэгістрацыя</button>
                </form>
                <div class="text-center fs-6">
                    <div id="lang-yesacc">Ёсць аккаўнт?</div>
                    <a href="<c:url value="/login"/>" class="wds-button" id="lang-enter">Уваход</a>
                </div>
                <div class="text-center fs-6">
                    <span style="color:${requestScope.color};" class="status">${requestScope.status}</span>
                </div>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>