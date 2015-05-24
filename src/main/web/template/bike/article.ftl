<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(article.title)!''} - ${(node.title)!''} - ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/style/article.css"/>
<#include "common/_script.ftl">
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <article class="content">
        <h2>${(article.title)!''}</h2>
        <p>${(article.content)!''}</p>
    </article>
</div>
</body>
</html>