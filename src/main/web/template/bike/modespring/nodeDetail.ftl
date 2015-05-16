<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
<#include "common/_header.ftl">
    <form action="/admin/node_${(currentNode.id)!''}.html" method="post">
        <label for="name">栏目名称<input name="name" type="text" value="${(currentNode.name)!''}"></label>
        <label for="url">栏目列表模板<input name="url" type="text" value="${(currentNode.url)!''}"></label>
        <label for="parentNode.id">上级栏目
            <select name="parentNode.id">
            <#list nodeList as node>
                <#if node.level lte 1>
                    <#if node.id == currentNode.parentNode.id>
                        <option selected="selected" value="${node.id}">${node.name}</option>
                    <#else>
                        <option value="${node.id}">${node.name}</option>
                    </#if>
                </#if>
            </#list>
            </select>
        </label>
        <input type="submit" value="保存修改">
    </form>

</body>
</html>