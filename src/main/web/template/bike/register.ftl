<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
    <#include "common/_header.ftl">
    <form id="J_RegisterForm" action="/register.html" method="post">
        <label for="registerFormName">用户名</label>
        <input id="registerFormName" name="name" type="text">
        <label for="registerFormNickname">昵称</label>
        <input id="registerFormNickname" name="nickname" type="text">
        <label for="registerFormPassword">密码</label>
        <label for="registerFormPasswordConfirm">确认密码</label>
        <input id="registerFormPasswordConfirm" name="passwordConfirm" type="password">
        <label for="registerFormEmail">邮箱</label>
        <input id="registerFormEmail" name="email" type="text">
        <input id="registerFormButton" type="submit" value="注册">
    </form>
</body>
</html>