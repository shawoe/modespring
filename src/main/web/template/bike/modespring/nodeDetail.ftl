<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(currentNode.title)!''} -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css" />
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section>
        <form action="/modespring/node/${(currentNode.id)!''}.html" method="post">
            <label>栏目编码<input name="name" type="text" value="${(currentNode.name)!''}"></label>
            <label>栏目名称<input name="title" type="text" value="${(currentNode.title)!''}"></label>
            <label>栏目URL<input name="url" type="text" value="${(currentNode.url)!''}"></label>
            <label>上级栏目
                <select name="parentNode.id">
                <#list nodeList as node>
                    <#if node.level?? && node.level lte 1>
                        <#if node.id == currentNode.parentNode.id>
                            <option selected="selected" value="${(node.id)!''}">${(node.title)!''}</option>
                        <#else>
                            <option value="${(node.id)!''}">${(node.title)!''}</option>
                        </#if>
                    </#if>
                </#list>
                </select>
            </label>
            <input type="submit" value="保存修改">
        </form>

    </section>
</div>
</body>
</html>