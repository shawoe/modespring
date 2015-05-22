<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(node.title)!''} -- ${(site.title)!''}</title>
</head>
<body>
<#include "../common/_header.ftl">
    <table>
        <tr><th>删除</th><th>ID</th><th>文章标题</th></tr>
        <form id="deleteArticleForm" action="" method="post">
        <#list articleList as article>
                <tr>
                    <td><input name="delete" type="checkbox" value="${article.id}"/></td>
                    <td>${article.id}</td>
                    <td><a href="/${(node.name)!''}/${(article.id)!''}.html">${article.name}</a></td>
                </tr>
            </#list>
            <input type="hidden" name="_method" value="delete" />
            <tr><td><input type="submit" value="删除已选"/></td></tr>
        </form>
    </table>

</body>
</html>