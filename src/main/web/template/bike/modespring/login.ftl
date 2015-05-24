<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
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