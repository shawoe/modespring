<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <h1>${currentUser.name}，欢迎你的到来！</h1>
    <img class="avatar" src="${(currentUser.avatar)!''}">
    <a href="/user/${currentUser.name}.html">修改资料</a>
    <a href="/logout.html">退出登录</a>
</section>
<#include "common/_footer.ftl">