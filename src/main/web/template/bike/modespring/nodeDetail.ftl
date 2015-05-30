<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/node/${(node.id)!''}.html" method="post">
        <label>栏目唯一编码<input name="name" type="text" value="${(node.name)!''}"></label>
        <label>栏目名称<input name="title" type="text" value="${(node.title)!''}"></label>
        <label>栏目模型
            <select name="model.id">
            <#list modelList as cur_model>
                <#if cur_model.id == node.model.id>
                    <option selected="selected" value="${(cur_model.id)!''}">${(cur_model.title)!''}</option>
                <#else>
                    <option value="${(cur_model.id)!''}">${cur_model.name}${(cur_model.title)!''}</option>
                </#if>
            </#list>
            </select>
        </label>
        <label>栏目列表页模板URL<input name="url" type="text" value="${(node.url)!''}"></label>
        <label>栏目文章页模板URL<input name="template" type="text" value="${(node.template)!''}"></label>
        <label>上级栏目
            <select name="parentNode.id">
            <#list nodeList as cur_node>
                <#if cur_node.level?? && cur_node.level lte 1>
                    <#if cur_node.id == node.parentNode.id>
                        <option selected="selected" value="${(cur_node.id)!''}">${(cur_node.title)!''}</option>
                    <#else>
                        <option value="${(cur_node.id)!''}">${(cur_node.title)!''}</option>
                    </#if>
                </#if>
            </#list>
            </select>
        </label>
        <input type="submit" value="保存修改">
    </form>
</section>
<#include "common/_footer.ftl">