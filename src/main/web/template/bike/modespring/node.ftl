<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> -- ${(site.name)!''}</title>
</head>
<body>
<#include "common/_header.ftl">
    <h2>创建栏目</h2>
    <form id="newNodeForm" action="/admin/node.html" method="post">
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
        <input type="submit" value="创建栏目" />
    </form>


    <table>
        <tr><th></th><th>ID</th><th>栏目名称</th><th></th></tr>
        <form id="nodeListForm" action="/admin/node.html" method="post">
            <#list nodeList as node>
            <#if node.level lte 1 >
                <tr>
                    <td><input type="checkbox" name="delete" value="${node.id}"/></td>
                    <td><input name="id" type="hidden" value="${node.id}"/>${node.id}</td>
                    <td><input name="name" type="text" value="${node.name}"/></td>
                    <td><a href="/admin/node_${(node.id)!''}.html">编辑</td>
                </tr>

                <#list nodeList as childNode>
                <#if childNode.level == 2 && childNode.parentNode.id == node.id>
                    <tr>
                        <td><input type="checkbox" name="delete" value="${childNode.id}"/></td>
                        <td><input name="id" type="hidden" value="${childNode.id}"/>${childNode.id}</td>
                        <td><input name="name" type="text" value="${childNode.name}"/></td>
                        <td><a href="/admin/node_${(childNode.id)!''}.html">编辑</td>
                    </tr>
                </#if>
                </#list>

            </#if>
            </#list>
            <tr><td colspan="4"><input type="submit" value="保存并删除选中" /></td></tr>
        </form>
    </table>

    <#--<table>-->
        <#--<tr><th>删除</th><th>ID</th><th>栏目名称</th><th>所属栏目</th></tr>-->
        <#--<form id="nodeListForm" action="/admin/node.html" method="post">-->

            <#--<!-- 根栏目 &ndash;&gt;-->
            <#--<#list nodeList as rootNode>-->
                <#--<#if rootNode.level==0 >-->
                    <#--<tr>-->
                        <#--<td><input type="checkbox" name="delete" value="${rootNode.id}"/></td>-->
                        <#--<td><input name="id" type="text" readonly="readonly" value="${rootNode.id}"/></td>-->
                        <#--<td><input name="name" type="text" value="${rootNode.name}"/></td>-->
                        <#--<td>-->
                            <#--<select name="parentId">-->
                                <#--<option value="-1">网站根目录</option>-->
                            <#--</select>-->
                        <#--</td>-->
                    <#--</tr>-->
                <#--</#if>-->
            <#--</#list>-->

            <#--<!-- 分类栏目 &ndash;&gt;-->
            <#--<#list nodeList as node>-->
                <#--<#if node.level==1>-->
                    <#--<tr>-->
                        <#--<td><input type="checkbox" name="delete" value="${node.id}"/></td>-->
                        <#--<td><input name="id" type="text" readonly="readonly" value="${node.id}"/></td>-->
                        <#--<td><input name="name" type="text" value="${node.name}"/></td>-->
                        <#--<td>-->
                            <#--<select name="parentId">-->
                                <#--<#list nodeList as rootNode>-->
                                    <#--<#if rootNode.level==0>-->
                                        <#--<option value="${rootNode.id}">${rootNode.name}</option>-->
                                    <#--</#if>-->
                                    <#--<#if rootNode.level==1 && rootNode.id==node.parentNode.id>-->
                                        <#--<option selected="selected" value="${rootNode.id}">${rootNode.name}</option>-->
                                    <#--</#if>-->
                                    <#--<#if rootNode.level==1 && rootNode.id!=node.parentNode.id>-->
                                        <#--<option value="${rootNode.id}">${rootNode.name}</option>-->
                                    <#--</#if>-->
                                <#--</#list>-->
                            <#--</select>-->
                        <#--</td>-->
                    <#--</tr>-->
                <#--</#if>-->

                <!-- 子栏目 -->
            <#--</#list>-->

            <#--<!-- 隐藏栏目 &ndash;&gt;-->
            <#--<tr><th>删除</th><th>ID</th><th>隐藏栏目</th><th>所属栏目</th></tr>-->
            <#--<#list nodeList as hiddenNode>-->
                <#--<#if hiddenNode.level==3>-->
                    <#--<tr>-->
                        <#--<td><input type="checkbox" name="delete" value="${hiddenNode.id}"/></td>-->
                        <#--<td><input name="id" type="text" readonly="readonly" value="${hiddenNode.id}"/></td>-->
                        <#--<td><input name="name" type="text" value="${hiddenNode.name}"/></td>-->
                        <#--<td>-->
                            <#--<select name="parentId">-->
                                <#--<#list nodeList as parentNode>-->
                                    <#--<!--<#if parentNode.level==0>&ndash;&gt;-->
                                        <#--<!--<option value="${parentNode.id}">${parentNode.name}</option>&ndash;&gt;-->
                                    <#--<!--</#if>&ndash;&gt;-->
                                    <#--<#if parentNode.level==2 && parentNode.id==hiddenNode.parentNode.id>-->
                                        <#--<option selected="selected" value="${parentNode.id}">${parentNode.name}</option>-->
                                    <#--</#if>-->
                                    <#--<#if parentNode.level==2 && parentNode.id!=hiddenNode.parentNode.id>-->
                                        <#--<option value="${parentNode.id}">${parentNode.name}</option>-->
                                    <#--</#if>-->
                                <#--</#list>-->
                            <#--</select>-->
                        <#--</td>-->
                    <#--</tr>-->
                <#--</#if>-->
            <#--</#list>-->

            <#--<tr><td></td><td></td><td></td><td><input type="submit" value="全部保存" /></td></tr>-->
        <#--</form>-->
    <#--</table>-->

</body>
</html>