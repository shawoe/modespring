<#include "common/_simditor.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form id="writeArticleForm" action="/${(node.name)!''}/write.html" method="post">
        <label>文章标题<input name="title" type="text"></label>
        <label>文章编码<input name="name" type="text"></label>
    <#if node.model??>
        <#list node.model.fieldList as field>
            <input name="fieldName" type="hidden" value="${(field.name)!''}">
            <input name="fieldTitle" type="hidden" value="${(field.title)!''}">
            <label>${(field.title)!''}<input name="fieldValue" type="text" value="${(field.value)!''}"></label>
        </#list>
    </#if>
        <textarea id="editor" name="content" placeholder="这里输入内容" autofocus></textarea>
        <input type="submit" value="发表文章">
    </form>
</section>
<script>
    var editor = new Simditor({
        textarea: $('#editor')
    });
</script>
<#include "common/_footer.ftl">