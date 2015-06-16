<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">

    <section class="create">
        <h2>创建用户</h2>

        <form id="newUserForm" action="/modespring/user.html" method="post">
            <select name="role.id">
            <#list roleList as role>
                <option value="${role.id}">${role.name}</option>
            </#list>
            </select>
            <input type="hidden" name="_method" value="put"/>
            <input name="name" type="text"/>
            <input name="password" type="text"/>
            <input name="email" type="text"/>
            <input type="submit" value="创建用户"/>
        </form>
    </section>

    <section class="edit">
        <h2>编辑用户</h2>
        <table>
            <tr>
                <th>删除</th>
                <th>ID</th>
                <th>用户名</th>
                <th>E-mail</th>
                <th>用户组</th>
                <th>权限</th>
                <th>联系人姓名</th>
                <th>性别</th>
                <th>最后登录</th>
                <th>注册时间</th>
                <th>实名认证</th>
                <th>已冻结</th>
            </tr>
            <form id="deleteUserForm" action="/modespring/user.html" method="post">
            <#list userList as user>
                <tr>
                    <td><input name="delete" type="checkbox" value="${user.id}"/></td>
                    <td>${user.id}</td>
                    <td><a href="/modespring/user/${user.name}.html">${user.name}</a></td>
                    <td>${user.email}</td>
                    <td>${(user.role.name)!''}</td>
                    <td>${(user.role.power)!''}</td>
                    <td>${(user.linkman.name)!''}</td>
                    <td>${(user.linkman.sex)!''}</td>
                    <td>${(user.lastLogin)!''}</td>
                    <td>${(user.registerDate)!''}</td>
                    <td>${(user.linkman.certification)!''}</td>
                    <td>${(user.frozen)?string('yes', 'no')}</td>
                </tr>
            </#list>
                <input type="hidden" name="_method" value="delete"/>
                <tr>
                    <td><input type="submit" value="删除已选"/></td>
                </tr>
            </form>
        </table>
    </section>

</section>
<#include "common/_footer.ftl">