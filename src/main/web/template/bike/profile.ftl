<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form id="editUserForm" action="/user/${currentUser.name}.html" method="post">
        <label for="editUserFormName">用户名</label>
        <input id="editUserFormName" name="name" type="text" value="${(currentUser.name)!''}">
        <label for="editUserFormNickname">昵称</label>
        <input id="editUserFormNickname" name="nickname" type="text" value="${(currentUser.nickname)!''}">
        <label for="editUserFormPassword">原密码</label>
        <input id="editUserFormPassword" name="password" type="password">
        <label for="editUserFormNewPassword">新密码</label>
        <input id="editUserFormNewPassword" name="newPassword" type="password">
        <label for="editUserFormPasswordConfirm">确认密码</label>
        <input id="editUserFormPasswordConfirm" name="passwordConfirm" type="password">
        <label for="editUserFormEmail">邮箱</label>
        <input id="editUserFormEmail" name="email" type="text" value="${(currentUser.email)!''}">
        <input id="editUserFormButton" type="submit" value="保存">
    </form>
</section>
<#include "common/_footer.ftl">