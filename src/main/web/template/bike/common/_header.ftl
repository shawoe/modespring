<header>
    <h1>${(site.title)!'ModeSpring'}</h1>
    <address>
        <ul class="clearfix">
            <li><a>济南</a></li>
            <li><a href="/center.html">会员中心</a></li>
        </ul>
    </address>
</header>

<nav>
    <ul class="clearfix">
    <#list nodeList as currentNode>
        <#if currentNode.level lt 2>
            <#if node?? && node.name == currentNode.name>
                <li class="selected"><a href="/${(currentNode.name)!'javascript:;'}.html">${(currentNode.title)!''}</a></li>
            <#else>
            <li><a href="/${(currentNode.name)!'javascript:;'}.html">${(currentNode.title)!''}</a></li>
            </#if>
        </#if>
    </#list>
    </ul>
</nav>