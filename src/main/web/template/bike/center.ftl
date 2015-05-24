<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户中心 -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/style/article.css"/>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <article class="content">
        <h1>Hello ${currentUser.name}</h1>
        <a href="/user/${currentUser.name}.html">修改资料</a>
        <a href="/logout.html">退出登录</a>
    </article>

</div>
</body>
</html>