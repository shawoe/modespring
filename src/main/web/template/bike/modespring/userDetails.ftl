<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/modespring/user/${(user.name)!''}.html" method="post">
        <input name="id" type="text" readonly="readonly" value="${(user.id)!''}"/>
        <input name="username" type="text" required="required" value="${(user.name)!''}"/>
        <input name="password" type="password" required="required" value="${(user.password)!''}"/>
        <input name="confirmPassword" type="password" required="required"/>
        <input name="email" type="text" required="required" value="${(user.email)!''}"/>
        <input name="linkman" type="text" value="${(user.linkman.name)!''}"/>
        <input name="phone" type="text" value="${(user.linkman.phone)!''}"/>
        <input name="QQ" type="text" value="${(user.linkman.QQ)!''}"/>
        <input name="weChat" type="text" value="${(user.linkman.weChat)!''}"/>
        <input type="submit" value="保存修改"/>
    </form>


</section>
<#include "common/_footer.ftl">