<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/login.html" method="post">
        <label>用户名:<input name="name" type="text"></label>
        <label>密码:<input name="password" type="password"></label>
        <input type="submit" value="登录">
        <a href="/register.html"><input type="button" value="还没账号？现在注册"></a>
    </form>
</section>
<#include "common/_footer.ftl">