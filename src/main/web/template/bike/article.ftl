<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(article.title)!''} -- ${(node.title)!''} -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css"/>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">

    <section>
        <h2>${(article.title)!''}</h2>

        <p>${(article.content)!''}</p>
    </section>
</div>
</body>
</html>