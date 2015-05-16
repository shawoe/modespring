<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录 -- ${(site.title)!''}</title>
</head>
<body>
    <#include "common/_header.ftl">
    <form id="loginForm" action="/login.html" method="post">
        <label for="loginFormName">用户名</label>
        <input id="loginFormName" name="name" type="text">
        <label for="loginFormPassword">密码</label>
        <input id="loginFormPassword" name="password" type="password">
        <input id="loginButton" type="submit" value="登录" />
        <a href="/register.html">注册</a>
    </form>
</body>
</html>