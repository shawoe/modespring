<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form action="/user/${currentUser.name}.html" enctype="multipart/form-data" method="post">
        <div class="fieldList">
            <img src="${(currentUser.avatar)!''}">
            <label>用户名：<input name="name" type="text" value="${(currentUser.name)!''}"></label>
            <label>昵称：<input name="nickname" type="text" value="${(currentUser.nickname)!''}"></label>
            <label>更换头像：<input name="avatarFile" type="file"></label>
            <label>原密码：<input name="password" type="password"></label>
            <label>新密码：<input name="newPassword" type="password"></label>
            <label>确认密码：<input name="passwordConfirm" type="password"></label>
            <label>邮箱：<input name="email" type="text" value="${(currentUser.email)!''}"></label>
            <input type="submit" value="保存修改">
        </div>
    </form>
</section>
<#include "common/_footer.ftl">