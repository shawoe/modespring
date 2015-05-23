<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(node.title)!''} - ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css"/>
<#include "common/_script.ftl">
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section class="content">
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