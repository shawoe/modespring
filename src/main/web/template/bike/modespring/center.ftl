<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <h1>Hello ${ModeSpringUser.name}</h1>
    <a href="/user/${ModeSpringUser.name}.html">修改资料</a>
    <a href="/logout.html">退出登录</a>
</section>
<#include "common/_footer.ftl">