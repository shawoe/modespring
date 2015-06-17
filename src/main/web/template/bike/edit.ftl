<#include "common/_simditor.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/${(node.name)!''}/${(article.id)!''}/edit.html" enctype="multipart/form-data" method="post">
        <div class="fieldList">
            <img class="titleImage" src="${(article.titleImage)!''}">
            <label>文章标题：<input name="title" type="text" value="${(article.title)!''}"></label>
            <label>更换标题图：<input name="titleImageFile" type="file"></label>
        </div>
    <#if article.valueList??>
        <#list article.valueList as field>
            <input name="fieldName" type="hidden" value="${(field.name)!''}">
            <input name="fieldTitle" type="hidden" value="${(field.title)!''}">
            <label>${(field.title)!''}<input name="fieldValue" type="${(field.type)!''}"
                                             value="${(field.value)!''}"></label>
        </#list>
    </#if>
        <textarea id="editor" name="content" placeholder="这里输入内容" autofocus>${(article.content)!''}</textarea>
        <input type="submit" value="保存修改">
    </form>
</section>
<script>
    var editor = new Simditor({
        textarea: $('#editor'),
        defaultImage: '/images/image.png',
        upload: {
            url: '/uploadAjax.html',
            params: null,
            fileKey: 'file',
            connectionCount: 2,
            leaveConfirm: '正在上传文件，如果离开上传会自动取消'
        },
        toolbar: ['title', 'bold', 'italic', 'underline', 'strikethrough', 'color', 'ol', 'ul', 'blockquote', 'code', 'table', 'link', 'image', 'hr', 'indent', 'outdent', 'alignment']
    });
</script>
<#include "common/_footer.ftl">