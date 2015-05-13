<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录 -- ${(site.name)!''}</title>
</head>
<body>
    <#include "common/_header.ftl">
    <form id="loginForm" action="/login.html" method="post">
        <input name="name" type="text" placeholder="用户名" required="required" />
        <input name="password" type="password" placeholder="密码" required="required" />
        <input id="loginButton" type="submit" value="登录" />
        <a href="/user/register.html">注册</a>
    </form>
</body>
</html>