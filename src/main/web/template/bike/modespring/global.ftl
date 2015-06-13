<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/global.html" method="post">
        <label>站点名称：<input name="title" type="text" value="${(site.title)!''}"></label>
        <label>站点LOGO：<input name="logo" type="text" value="${(site.logo)!''}"><input name="logoFile" type="file"></label>
        <label>站点URL：<input name="url" type="text" value="${(site.url)!''}"></label>
        <label>ModeSpring URL：<input name="mospUrl" type="text" value="${(site.mospUrl)!''}"></label>
        <input type="submit" value="保存"/>
    </form>
</section>
<#include "common/_footer.ftl">