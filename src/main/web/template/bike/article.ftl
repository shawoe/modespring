<#include "common/_html.ftl">
<#include "common/_header.ftl">
<article class="content">
    <h2>${(article.title)!''}</h2>
    <#list article.valueList as value>
        <h3>${(value.title)!''}</h3>
        <p>${(value.value)!''}</p>
    </#list>
    <div>${(article.content)!''}</div>
</article>
<#include "common/_footer.ftl">