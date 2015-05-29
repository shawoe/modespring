<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">

    <section class="create">
        <h2>创建模型</h2>
        <form id="newModelForm" action="/modespring/model.html" method="post">
            <input type="hidden" name="_method" value="put"/>
            <label>模型编码<input name="name" type="text"/></label>
            <label>模型名称<input name="title" type="text"/></label>
            <input type="submit" value="创建栏目"/>
        </form>
    </section>

    <section class="edit">
        <h2>修改模型</h2>
        <table>
            <tr>
                <th></th>
                <th>ID</th>
                <th>栏目编号</th>
                <th>栏目名称</th>
                <th></th>
            </tr>
            <form id="modelListForm" action="/modespring/model.html" method="post">
            <#list modelList as model>
                    <tr>
                        <td><input type="checkbox" name="delete" value="${model.id}"/></td>
                        <td><input name="id" type="hidden" value="${model.id}"/>${model.id}</td>
                        <td><input name="name" type="text" value="${model.name}"/></td>
                        <td><input name="title" type="text" value="${model.title}"/></td>
                        <td><a href="/modespring/model/${(model.id)!''}.html">编辑</td>
                        <td><a href="/modespring/model/${(model.name)!''}/field.html">修改字段</td>
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