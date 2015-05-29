<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/node/${(currentNode.id)!''}.html" method="post">
        <label>栏目唯一编码<input name="name" type="text" value="${(currentNode.name)!''}"></label>
        <label>栏目名称<input name="title" type="text" value="${(currentNode.title)!''}"></label>
        <label>栏目模型
            <select name="model.name">
            <#list modelList as model>
                    <#if (node.model.name)?? && model.name == node.model.name>
                        <option selected="selected" value="${(model.name)!''}">${(model.title)!''}</option>
                    <#else>
                        <option value="${(model.name)!''}">${(model.title)!''}</option>
                    </#if>
            </#list>
            </select>
        </label>
        <label>栏目列表页模板URL<input name="url" type="text" value="${(currentNode.url)!''}"></label>
        <label>栏目文章页模板URL<input name="template" type="text" value="${(currentNode.template)!''}"></label>
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