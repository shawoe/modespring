<#include "common/_html.ftl">
<header>
    <h1><img src="/image/modespring.png"></h1>
    <ul>
        <li><a href="/index.html">前台首页</a></li>
        <li><a href="/logout.html">退出登录</a></li>
    </ul>
</header>
<section class="login">
    <form id="loginForm" action="/modespring/login.html" method="post">
        <label>用户名：<input name="name" type="text"></label>
        <label>密码：<input name="password" type="password"></label>
        <input id="loginButton" type="submit" value="登录"/>
    </form>
</section>
<#include "common/_footer.ftl">