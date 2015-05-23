<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户中心 -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css"/>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section>
        <h1>Hello ${ModeSpringUser.name}</h1>
        <a href="/user/${ModeSpringUser.name}.html">修改资料</a>
        <a href="/logout.html">退出登录</a>
    </section>

</div>
</body>
</html>