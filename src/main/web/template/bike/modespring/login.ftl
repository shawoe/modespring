<#include "common/_html.ftl">
<header>
    <h1><img src="/image/modespring.png"></h1>
    <ul>
        <li><a href="/index.html">前台首页</a></li>
        <li><a href="/logout.html">退出登录</a></li>
    </ul>
</header>
<section class="login">
    <form id="loginForm" action="/login.html" method="post">
        <label for="loginFormName">用户名</label>
        <input id="loginFormName" name="name" type="text">
        <label for="loginFormPassword">密码</label>
        <input id="loginFormPassword" name="password" type="password">
        <input id="loginButton" type="submit" value="登录"/>
        <a href="/register.html">注册</a>
    </form>
</section>
<#include "common/_footer.ftl">