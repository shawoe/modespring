<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
    <#include "../common/_header.ftl">
    <form id="J_RegisterForm" action="/user_${currentUser.id}.html" method="post">
        <input name="name" type="text" placeholder="用户名" value="${(currentUser.name)!''}" readonly="readonly" required="required"/>
        <input name="password" type="password" placeholder="原密码" required="required"/>
        <input name="newPassword" type="password" placeholder="新密码"/>
        <input name="passwordConfirm" type="password" placeholder="确认密码"/>
        <input name="email" type="text" placeholder="邮箱" value="${(currentUser.email)!''}" required="required"/>
        <input name="sex" type="text" placeholder="性别" value="${(currentUser.linkman.sex)!''}"/>
        <input id="J_RegisterButton" type="submit">保存</input>
    </form>
</body>
</html>