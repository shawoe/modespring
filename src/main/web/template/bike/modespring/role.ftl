<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">

    <section class="create">
        <h2>创建角色</h2>

        <form id="newUserForm" action="/modespring/role.html" method="post">
            <input type="hidden" name="_method" value="put"/>
            <label>角色编码：<input name="name" type="text"></label>
            <label>角色头衔：<input name="title" type="text"></label>
            <input type="submit" value="创建角色"/>
        </form>
    </section>

    <section class="edit">
        <h2>编辑角色</h2>
        <table>
            <tr>
                <th>删除</th>
                <th>ID</th>
                <th>角色编码</th>
                <th>角色头衔</th>
            </tr>
            <form id="deleteUserForm" action="/modespring/role.html" method="post">
            <#list roleList as role>
                <tr>
                    <td><input name="delete" type="checkbox" value="${(role.id)!''}"/></td>
                    <td>${(role.id)!''}</td>
                    <td><a href="/modespring/role/${(role.name)!''}.html">${(role.name)!''}</a></td>
                    <td>${(role.title)!''}</td>
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