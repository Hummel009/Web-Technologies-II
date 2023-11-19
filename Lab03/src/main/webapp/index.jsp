<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html class="" lang="ru" dir="ltr">
<jsp:include page="include/head.jsp"/>
<body>
<jsp:include page="include/global-nav.jsp"/>
<div class="main-container">
    <div class="page-background"></div>
    <div class="page-container">
        <jsp:include page="include/header.jsp"/>
        <div class="page">
            <main class="page-main">
                <form>
                    <fieldset class="main-fieldset">
                        <legend id="lang-translate">Перакласці</legend>
                        <label>
                            <input type="radio" name="lang" value="be" id="lang-be"/>Беларуская </label>
                        <label>
                            <input type="radio" name="lang" value="en" id="lang-en"/> English </label>
                    </fieldset>
                </form>
                <p id="lang-intro">Сардэчна запрашаем, наведвальнік (калі ласка, далучайся да нас) на гэты
                    інтэрнэт-партал,
                    дзе вы можаце купіць кнігі некаторых беларускіх пісьменнікаў. Чытайце і пазнавайце
                    новае!</p>
                <h2>
                    <span id="lang-author-of-day">Аўтар дня</span>
                </h2>
                <div class="featured-1" id="featured-1">
                    <img src="<c:url value="/assets/jakub.jpg"/>" width="40%" height="auto" alt=""/>
                    <p>Яку́б Ко́лас, сапр. Канстанці́н Міха́йлавіч Міцке́віч (22 кастрычніка (3 лістапада) 1882,
                        засценак Акінчыцы (цяпер у межах г. <a href="http://be.wikipedia.org/wiki/Стоўбцы">Стоўбцы</a>)
                        — 13 жніўня 1956, Мінск) — беларускі паэт, празаік, драматург, крытык, публіцыст, перакладчык,
                        вучоны, педагог, грамадскі дзеяч; адзін з заснавальнікаў сучаснай беларускай літаратуры і
                        літаратурнай мовы. Народны паэт <a href="http: //be.wikipedia.org/wiki/Беларусь">Беларусі</a>
                        (1926). Акадэмік АН Беларусі (1928). Заслужаны дзеяч навукі Беларусі (1944).</p>
                </div>
                <div class="featured-2" id="featured-2">
                    <img src="<c:url value="/assets/kupala.jpg"/>" width="40%" height="auto" alt=""/>
                    <p>Я́нка Купа́ла, сапр. Іва́н Даміні́кавіч Луцэ́віч (25 чэрвеня (7 ліпеня) 1882, ф. Вязынка, цяпер
                        Маладзечанскі раён, Мінская вобласць — 28 чэрвеня 1942, Масква) — беларускі паэт, драматург,
                        публіцыст, перакладчык, класік беларускай літаратуры, адзін з заснавальнікаў новай беларускай
                        літаратуры і літаратурнай мовы. Народны паэт Беларусі (1925). Акадэмік АН Беларусі (1928), АН
                        Украіны (1929).</p>
                </div>
                <h2>
                    <span id="lang-other">Іншыя пісьменнікі</span>
                </h2>
                <div class="row">
                    <c:forEach items="${requestScope.authors}" var="item">
                        <div class="card card-text card-button">
                            <div>
                                <img src="<c:url value="/${item.getImagePath()}"/>" class="card-img-top">
                            </div>
                            <div class="card-body">
                                <div><span class="card-text">${item.getName()}</span></div>
                                <div><a href="<c:url value="/authors/${item.getName()}"/>"
                                        class="wds-button" id="lang-goto">Перайсці</a></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <nav class="pagination-nav">
                    <ul class="pagination">
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/index/paging?pageNumber=${sessionScope.authorPagingParams.getPageNumber() - 1}"/>"><<</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/index/paging?pageNumber=0"/>">1</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/index/paging?pageNumber=1"/>">2</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/index/paging?pageNumber=2"/>">3</a>
                        </li>
                        <li class="page-item"><a class="wds-button"
                                                 href="<c:url value="/index/paging?pageNumber=${sessionScope.authorPagingParams.getPageNumber() + 1}"/>">>></a>
                        </li>
                    </ul>
                </nav>
            </main>
        </div>
    </div>
</div>
<jsp:include page="include/script.jsp"/>
</body>
</html>