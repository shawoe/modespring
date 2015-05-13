<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
    <#include "common/_header.ftl">
    <form id="J_RegisterForm" action="/user/register.html" method="post">
        <input name="name" type="text" placeholder="用户名" required="required" checked="checked"/>
        <input name="password" type="password" placeholder="密码" required="required"/>
        <input name="confirmPassword" type="password" placeholder="确认密码" required="required"/>
        <input name="email" type="text" placeholder="邮箱" required="required"/>
        <input name="birthday" type="date" placeholder="生日" required="required"/>
        <a href="javascript:;" id="J_RegisterButton">注册</a>
    </form>
</body>
</html>