<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/register.html" method="post">
        <label>用户名:<input name="name" type="text"></label>
        <label>昵称:<input name="nickname" type="text"></label>
        <label>密码:<input name="password" type="password"></label>
        <label>确认密码:<input name="passwordConfirm" type="password"></label>
        <label>邮箱:<input name="email" type="text"></label>
        <input type="submit" value="注册">
        <a href="/login.html"><input type="button" value="已有账号，立即登录"></a>
    </form>
</section>
<#include "common/_footer.ftl">