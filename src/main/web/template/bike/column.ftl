<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(node.title)!''} -- ${(site.title)!''}</title>
</head>
<body>
<#include "common/_header.ftl">
    <h1>${(node.title)!''}</h1>
    <section>
    <table>
        <tr><th>删除</th><th>ID</th><th>文章标题</th></tr>
        <form id="deleteArticleForm" action="" method="post">
            <#list articleList as article>
                <tr>
                    <td><input name="delete" type="checkbox" value="${article.id}"/></td>
                    <td>${article.id}</td>
                    <td>${(article.title)!''}</a></td>
                </tr>
            </#list>
            <input type="hidden" name="_method" value="delete" />
        <tr><td colspan="3"><input type="submit" value="删除已选"/></td></tr>
        </form>
    </table>
    </section>

</body>
</html>