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
                    <span id="lang-admin">Кабінет адміністратара</span>
                </h1>
                <div class="infoblock">
                    <h3 id="lang-manage-user">
                        Кіраванне карыстальнікам
                    </h3>
                    <form method="POST" action="<c:url value="/admin/banUser"/>"
                          enctype="multipart/form-data">
                        <div class="items-group">
                            <div>
                                <label for="banEmail" id="lang-email">Пошта</label>
                            </div>
                            <input class="hstyle" id="banEmail" name="banEmail" type="text"
                                   placeholder="Пошта">
                        </div>
                        <div>
                            <button id="lang-ban" class="wds-button">Бан</button>
                        </div>
                    </form>
                </div>
                <div class="infoblock">
                    <h3 id="lang-new-writer">
                        Новы пісьменнік
                    </h3>
                    <form method="POST" action="<c:url value="/admin/addAuthor"/>"
                          enctype="multipart/form-data">
                        <div class="items-group">
                            <div>
                                <label for="authorName" id="lang-name">Імя</label>
                            </div>
                            <input class="hstyle" id="authorName" name="authorName" type="text"
                                   placeholder="Імя">
                        </div>
                        <div class="items-group">
                            <div>
                                <label for="authorFile" id="lang-photo">Фотаздымак</label>
                            </div>
                            <div class="files">
                                <label class="label">
                                    <input class="title wds-button" id="authorFile" name="authorFile"
                                           type="file"
                                           accept=".png,.jpg,.jpeg">
                                </label>
                            </div>
                            <div>
                                <button id="lang-add" class="wds-button">Дадаць</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="infoblock">
                    <h3 id="lang-new-book">
                        Новая кніга
                    </h3>
                    <form method="POST" action="<c:url value="/admin/addBook"/>"
                          enctype="multipart/form-data">
                        <div class="items-group">
                            <div>
                                <label for="bookName" id="lang-bookname">Назва</label>
                            </div>
                            <input class="hstyle" id="bookName" name="bookName" type="text"
                                   placeholder="Назва">
                        </div>
                        <div class="items-group">
                            <div>
                                <label for="bookDescription" id="lang-desc">Апісанне</label>
                            </div>
                            <textarea id="bookDescription"
                                      name="bookDescription"
                                      placeholder="Апісанне"></textarea>
                        </div>
                        <div class="items-group">
                            <div>
                                <label for="bookAuthor" id="lang-author">Аўтар</label>
                            </div>
                            <select id="bookAuthor" name="bookAuthor">
                                <c:forEach items="${requestScope.authors}" var="author">
                                    <option name="author"
                                            value="${author.getName()}">${author.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="items-group">
                            <div>
                                <label for="bookPrice" id="lang-price">Кошт</label>
                            </div>
                            <input class="hstyle" id="bookPrice" name="bookPrice" type="text"
                                   placeholder="Кошт">
                        </div>
                        <div class="items-group">
                            <div>
                                <label for="bookFile" id="lang-image">Відарыс</label>
                            </div>
                            <div class="files">
                                <label class="label">
                                    <input class="title wds-button" id="bookFile" name="bookFile"
                                           type="file"
                                           accept=".png,.jpg,.jpeg">
                                </label>
                            </div>
                            <div>
                                <button id="lang-add" class="wds-button">Дадаць</button>
                            </div>
                        </div>
                    </form>
                </div>
            </main>
            <jsp:include page="include/rail.jsp"/>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>