<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css" />
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <section>

        <h2>创建栏目</h2>
        <form id="newNodeForm" action="/modespring/node.html" method="post">
            <select name="parentNode.id">
            <#list nodeList as node>
                <#if node.level==0>
                    <option value="${node.id}">${node.name}</option>
                </#if>
                <#list nodeList as childNode>
                    <#if childNode.level==1 && childNode.parentNode.id==node.id>
                        <option value="${childNode.id}">${childNode.name}</option>
                    </#if>
                </#list>
            </#list>
            </select>
            <input type="hidden" name="_method" value="put" />
            <input name="name" type="text" />
            <input name="title" type="text" />
            <input type="submit" value="创建栏目" />
        </form>


        <table>
            <tr><th></th><th>ID</th><th>栏目编号</th><th>栏目名称</th><th></th></tr>
            <form id="nodeListForm" action="/modespring/node.html" method="post">
            <#list nodeList as node>
                <#if node.level lte 1 >
                    <tr>
                        <td><input type="checkbox" name="delete" value="${node.id}"/></td>
                        <td><input name="id" type="hidden" value="${node.id}"/>${node.id}</td>
                        <td><input name="name" type="text" value="${node.name}"/></td>
                        <td><input name="title" type="text" value="${node.title}"/></td>
                        <td><a href="/modespring/node/${(node.id)!''}.html">编辑</td>
                    </tr>

                    <#list nodeList as childNode>
                        <#if childNode.level == 2 && childNode.parentNode.id == node.id>
                            <tr>
                                <td><input type="checkbox" name="delete" value="${childNode.id}"/></td>
                                <td><input name="id" type="hidden" value="${childNode.id}"/>${childNode.id}</td>
                                <td><input name="name" type="text" value="${childNode.name}"/></td>
                                <td><input name="title" type="text" value="${childNode.title}"/></td>
                                <td><a href="/modespring/node/${(childNode.id)!''}.html">编辑</td>
                            </tr>
                        </#if>
                    </#list>

                </#if>
            </#list>
                <tr><td colspan="5"><input type="submit" value="保存并删除选中" /></td></tr>
            </form>
        </table>

    </section>
</div>
</body>
</html>