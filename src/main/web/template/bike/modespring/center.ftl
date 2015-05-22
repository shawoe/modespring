<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户中心 -- ${(site.title)!''}</title>
</head>
<body>
<#include "common/_header.ftl">
    <#if errorMessage?? >
        <h1>${errorMessage}</h1>
    </#if>
    <h1>Hello ${(ModeSpringUser.name)!''}</h1>
</body>
</html>