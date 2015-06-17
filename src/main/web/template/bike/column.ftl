<#include "common/_html.ftl">
<#include "common/_header.ftl">
<section class="main">
    <ul class="list">
    <#list articleList as cur_art>
        <a href="/${(node.name)!''}/${(cur_art.id)!''}.html">
            <li>
                <img src="${(cur_art.titleImage)!'/image/jinan.jpg'}">
                <div></div>
                <article>${(cur_art.title)!''}</article>
            </li>
        </a>
    </#list>
    </ul>
</section>
<#include "common/_footer.ftl">