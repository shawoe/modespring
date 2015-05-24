<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form id="loginForm" action="/login.html" method="post">
        <div class="formgroup">
            <label for="loginFormName">用户名:</label>
            <input id="loginFormName" name="name" type="text">
        </div>
        <div class="formgroup">
            <label for="loginFormPassword">密码:
            </label>
            <input id="loginFormPassword" name="password" type="password">
        </div>
        <div class="btnGroup">
            <input id="loginButton" type="submit" value="登录"/>
            <a href="/register.html">注册</a>
        </div>

    </form>
</section>
<#include "common/_footer.ftl">