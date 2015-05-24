<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="main">
    <ul class="list">
    <#list articleList as cur_art>
        <li>
            <img src="/image/jinan.jpg">

            <div></div>
            <article>
                <a href="/${(node.name)!''}/${(cur_art.id)!''}.html">${(cur_art.title)!''}</a>
            </article>
        </li>
    </#list>
    </ul>
</section>
<#include "common/_footer.ftl">