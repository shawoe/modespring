<header>
    <h1>${(site.title)!'ModeSpring'}</h1>
    <ul>
        <li><a>济南</a></li>
        <li><a href="/center.html">会员中心</a></li>
        <li><a href="/modespring/index.html">后台管理</a></li>
    </ul>
</header>

<nav>
    <ul class="clearfix">
    <#list nodeList as currentNode>
        <#if currentNode.level == 1>
            <#if node?? && node.name == currentNode.name>
                <a href="/${(currentNode.name)!'javascript:;'}.html">
                    <li class="selected">${(currentNode.title)!''}</li>
                </a>
            <#else>
                <a href="/${(currentNode.name)!'javascript:;'}.html">
                    <li>${(currentNode.title)!''}</li>
                </a>
            </#if>
        </#if>
    </#list>
    </ul>
</nav>