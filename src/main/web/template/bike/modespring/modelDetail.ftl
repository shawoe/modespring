<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/model/${(currentModel.id)!''}.html" method="post">
        <label>模型唯一标识<input name="name" type="text" value="${(currentModel.name)!''}"></label>
        <label>模型名称<input name="title" type="text" value="${(currentModel.title)!''}"></label>
        <input type="submit" value="保存修改">
    </form>

</section>
<#include "common/_footer.ftl">