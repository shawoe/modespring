<header>
    <h1>${(site.name)!'ModeSpring'}</h1>
    <address>
        <p>济南</p>
        <img src="">
    </address>
    <nav>
        <ul>
            <#list nodeList as node>
                <#if node.level != 2>
                    <li><a href="/node/${(node.id)!'javascript:;'}.html">${(node.name)!''}</a>
                        <ul>
                            <#list nodeList as childNode>
                                <#if childNode.level == 2 && childNode.parentNode.id == node.id>
                                    <li>${(childNode.name)!''}</li>
                                </#if>
                            </#list>
                        </ul>
                    </li>
                </#if>
            </#list>
        </ul>
    </nav>
</header>