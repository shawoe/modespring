<header>
    <h1>${(site.title)!'ModeSpring'}</h1>
    <address>
        <p>济南</p>
        <a href="/center.html">会员中心</a>
    </address>
    <nav>
        <ul>
            <#list nodeList as node>
                <#if node.level lt 2>
                    <li><a href="/${(node.name)!'javascript:;'}.html">${(node.title)!''}</a>
                        <ul>
                            <#list nodeList as childNode>
                                <#if childNode.level == 2 && childNode.parentNode.name == node.name>
                                    <li>${(childNode.title)!''}</li>
                                </#if>
                            </#list>
                        </ul>
                    </li>
                </#if>
            </#list>
        </ul>
    </nav>
</header>