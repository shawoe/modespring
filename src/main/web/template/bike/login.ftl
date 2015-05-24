<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录 -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/style/article.css"/>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <article class="content">
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
    </article>
</div>
</body>
</html>