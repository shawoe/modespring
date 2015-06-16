<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="content">
    <section class="edit">
        <h2>文章列表</h2>
        <table>
            <tr>
                <th></th>
                <th>ID</th>
                <th>文章标题</th>
            </tr>
            <form id="nodeListForm" action="/modespring/${(node.name)!''}/article.html" method="post">
            <#list articleList as cur_art>
                <tr>
                    <td><input type="checkbox" name="delete" value="${cur_art.id}"/></td>
                    <td><input name="id" type="hidden" value="${cur_art.id}"/>${node.id}</td>
                    <td><a href="/${(node.name)!''}/${(cur_art.id)!''}.html">${(cur_art.title)!''}</a></td>

                </tr>
            </#list>
                <tr>
                    <input type="hidden" name="_method" value="delete"/>
                    <td colspan="5"><input type="submit" value="删除选中文章"/></td>
                </tr>
            </form>
        </table>
    </section>
</section>
<#include "common/_footer.ftl">