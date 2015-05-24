<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户注册 -- ${(site.name)!''}</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/style/layout.css"/>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section class="content">

        <form id="J_RegisterForm" action="/register.html" method="post">
            <div class="formgroup">
                <label for="registerFormName">用户名</label>
                <input id="registerFormName" name="name" type="text">
            </div>
            <div class="formgroup">
                <label for="registerFormNickname">昵称</label>
                <input id="registerFormNickname" name="nickname" type="text">
            </div>
            <div class="formgroup">
                <label for="registerFormPassword">密码</label>
                <input id="registerFormPassword" name="password" type="password">
            </div>
            <div class="formgroup">
                <label for="registerFormPasswordConfirm">确认密码</label>
                <input id="registerFormPasswordConfirm" name="passwordConfirm" type="password">
            </div>
            <div class="formgroup">
                <label for="registerFormEmail">邮箱</label>
                <input id="registerFormEmail" name="email" type="text">
            </div>
            <div class="btnGroup">
                <input id="registerFormButton" type="submit" value="注册">
            </div>

        </form>
    </section>
</div>
</body>
</html>