<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">

    <section class="create">
        <h2>添加字段</h2>
        <form id="newFieldForm" action="/modespring/model/${(currentModel.name)!''}/field.html" method="post">
            <input type="hidden" name="_method" value="put"/>
            <label>字段唯一标识<input name="name" type="text"/></label>
            <label>字段名称<input name="title" type="text"/></label>
            <label>字段默认值<input name="value" type="text"/></label>
            <input type="submit" value="添加字段"/>
        </form>
    </section>

    <section class="edit">
        <h2>修改字段</h2>
        <table>
            <tr>
                <th></th>
                <th>ID</th>
                <th>字段编号</th>
                <th>字段名称</th>
                <th></th>
            </tr>
            <form action="/modespring/model/${(currentModel.name)!''}/field.html" method="post">
            <#list fieldList as field>
                    <tr>
                        <td><input type="checkbox" name="delete" value="${field.id}"/></td>
                        <td><input name="id" type="hidden" value="${field.id}"/>${field.id}</td>
                        <td><input name="name" type="text" value="${field.name}"/></td>
                        <td><input name="title" type="text" value="${field.title}"/></td>
                        <td>字段默认值<input name="value" type="text" value="${field.value}"/></td>
                    </tr>
            </#list>
                <tr>
                    <td colspan="5"><input type="submit" value="保存并删除选中"/></td>
                </tr>
            </form>
        </table>
    </section>

</section>
<#include "common/_footer.ftl">