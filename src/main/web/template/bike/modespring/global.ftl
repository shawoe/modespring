<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/global.html" enctype="multipart/form-data" method="post">
        <label>站点名称：<input name="title" type="text" value="${(site.title)!''}"></label>
        <label>站点LOGO：<input name="logo" type="text" value="${(site.logo)!''}"><input name="logoFile" type="file"></label>
        <label>站点URL：<input name="url" type="text" value="${(site.url)!''}"></label>
        <label>ModeSpring URL：<input name="mospUrl" type="text" value="${(site.mospUrl)!''}"></label>
        <label>数据库URL：<input name="jdbcUrl" type="text" value="${(site.jdbcUrl)!''}"></label>
        <label>数据库名称：<input name="jdbcName" type="text" value="${(site.jdbcName)!''}"></label>
        <label>数据库用户名：<input name="jdbcUsername" type="text" value="${(site.jdbcUsername)!''}"></label>
        <label>数据库密码：<input name="jdbcPassword" type="password"></label>
        <label>确认密码：<input name="passwordConfirm" type="password"></label>
        <label>站点开启：<input name="open" type="text" value="true"></label>
        <input type="submit" value="保存设置"/>
    </form>
</section>
<#include "common/_footer.ftl">