<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<div class="page-header">
    <nav class="local-navigation">
        <a href="<c:url value="/index"/>">
            <span id="lang-main">Галоўная</span>
        </a>
        <a href="<c:url value="/registration"/>">
            <span id="lang-register">Рэгістрацыя</span>
        </a>
        <a href="<c:url value="/login"/>">
            <span id="lang-enter">Уваход</span>
        </a>
        <a href="<c:url value="/profile"/>">
            <span id="lang-profile">Профіль</span>
        </a>
        <a href="<c:url value="/cart"/>">
            <span id="lang-cart">Кош</span>
        </a>
        <a href="<c:url value="/admin"/>">
            <span id="lang-admin">Кабінет адміністратара</span>
        </a>
    </nav>
</div>