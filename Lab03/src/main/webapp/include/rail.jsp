<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<aside class="right-rail search">
    <div class="noframe">
        <h1>
            <span id="lang-search">Пошук</span>
        </h1>
        <form>
            <input class="hstyle" type="search" id="mySearch" name="q">
            <button class="wds-button" id="find" type="submit">Пошук</button>
        </form>
    </div>
    <form>
        <fieldset class="rc-fieldset">
            <legend id="lang-translate">Перакласці</legend>
            <label>
                <input type="radio" name="lang" value="be" id="lang-be"/> Беларуская </label>
            <label>
                <input type="radio" name="lang" value="en" id="lang-en"/> English </label>
        </fieldset>
    </form>
</aside>