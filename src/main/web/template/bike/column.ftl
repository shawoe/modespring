<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(node.title)!''} -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css" />
    <!--[if lt IE 9]>
    <script src="/module/html5shiv/dist/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section>
        <h2>${(node.title)!''}</h2>
    <table>
        <tr><th>删除</th><th>ID</th><th>文章标题</th></tr>
        <form id="deleteArticleForm" action="" method="post">
            <#list articleList as article>
                <tr>
                    <td><input name="delete" type="checkbox" value="${(article.id)!''}"/></td>
                    <td>${(article.id)!''}</td>
                    <td><a href="/${(node.name)!''}/${(article.id)!''}.html">${(article.title)!''}</a></td>
                </tr>
            </#list>
            <input type="hidden" name="_method" value="delete" />
        <tr><td colspan="3"><input type="submit" value="删除已选"/></td></tr>
        </form>
    </table>
    </section>
</div>
</body>
</html>