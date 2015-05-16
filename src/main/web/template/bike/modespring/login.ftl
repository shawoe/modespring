<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户登录 -- ${(site.title)!'ModeSpring'}</title>
</head>
<body>
    <form id="loginMsForm" action="/modespring/login.html" method="post">
        <label for="loginMsFormName">用户名</label>
        <input id="loginMsFormName" name="name" type="text">
        <label for="loginMsFormPassword">密码</label>
        <input id="loginMsFormPassword" name="password" type="password">
        <input id="loginMsButton" type="submit" value="登录" />
    </form>
</body>
</html>