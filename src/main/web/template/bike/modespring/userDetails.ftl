<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
    <#include "common/_header.ftl">
    <form id="deleteUserForm" action="/admin/user/${user.username}.html" method="post">
        <input name="id" type="text" readonly="readonly" value="${user.id}" />
        <input name="username" type="text" required="required" value="${user.username}" />
        <input name="password" type="password" required="required" value="${user.password}" />
        <input name="confirmPassword" type="password" required="required" />
        <input name="email" type="text" required="required" value="${user.email}" />
        <input name="linkman" type="text" value="${(user.linkman.name)!''}" />
        <input name="phone" type="text" value="${(user.linkman.phone)!''}" />
        <input name="QQ" type="text" value="${(user.linkman.QQ)!''}" />
        <input name="weChat" type="text" value="${(user.linkman.weChat)!''}" />
        <input type="submit" value="保存修改"/>
    </form>

</body>
</html>