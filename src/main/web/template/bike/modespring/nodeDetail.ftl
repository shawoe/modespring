<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/node/${(currentNode.id)!''}.html" method="post">
        <label>栏目编码<input name="name" type="text" value="${(currentNode.name)!''}"></label>
        <label>栏目名称<input name="title" type="text" value="${(currentNode.title)!''}"></label>
        <label>栏目URL<input name="url" type="text" value="${(currentNode.url)!''}"></label>
        <label>栏目模板<input name="template" type="text" value="${(currentNode.template)!''}"></label>
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
<#include "common/_footer.ftl">