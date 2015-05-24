<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0" />
    <title>${(node.title)!''} - ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/style/layout.css"/>
<#include "common/_head.ftl">
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section class="main">
        <ul class="list">
        <#list articleList as cur_art>
            <li>
                <img src="/image/jinan.jpg">

                <div></div>
                <article>
                    <a href="/${(node.name)!''}/${(cur_art.id)!''}.html">${(cur_art.title)!''}</a>
                </article>
            </li>
        </#list>
        </ul>
    </section>
<#include "common/_footer.ftl">
</body>
</html>