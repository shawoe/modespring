<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录 -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css" />
</head>
<body>
<div class="wrapper">
    <#include "common/_header.ftl">
        <section>
            <form id="loginForm" action="/login.html" method="post">
                <label for="loginFormName">用户名</label>
                <input id="loginFormName" name="name" type="text">
                <label for="loginFormPassword">密码</label>
                <input id="loginFormPassword" name="password" type="password">
                <input id="loginButton" type="submit" value="登录" />
                <a href="/register.html">注册</a>
            </form>
        </section>
</div>
</body>
</html>