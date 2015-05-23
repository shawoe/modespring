<header>
    <h1><img src="/image/logo2.png"></h1>
    <ul class="shortcut">
        <li><a>济南</a></li>
        <li><a href="/center.html">会员中心</a></li>
        <li><a href="/modespring/index.html">后台管理</a></li>
    </ul>
</header>

<div class="ad">
    <img src="/image/ad.gif">
</div>

<nav>
    <ul class="nav">
    <#list nodeList as cur_node>
        <#if cur_node.level == 1>
            <#if node?? && ( cur_node.name == node.name || cur_node.name == node.parentNode.name )>
                <a href="/${(cur_node.name)!'javascript:;'}.html">
                    <li class="selected">${(cur_node.title)!''}</li>
                </a>
            <#else>
                <a href="/${(cur_node.name)!'javascript:;'}.html">
                    <li>${(cur_node.title)!''}</li>
                </a>
            </#if>
        </#if>
    </#list>
    </ul>

    <ul class="menu">
    <#assign isFirst = true>
    <#list nodeList as cur_menu>
        <#if node?? && cur_menu.level == 2>
            <#if cur_menu.parentNode.name == node.name>
                <#if isFirst == true>
                    <a href="/${(node.name)!'javascript:;'}.html">
                        <li class="selected">显示全部</li>
                    </a>
                    <#assign isFirst = false>
                </#if>
                <a href="/${(cur_menu.name)!'javascript:;'}.html">
                    <li>${(cur_menu.title)!''}</li>
                </a>
            </#if>
            <#if cur_menu.parentNode.name == node.parentNode.name>
                <#if isFirst == true>
                    <a href="/${(node.parentNode.name)!'javascript:;'}.html">
                        <li>显示全部</li>
                    </a>
                    <#assign isFirst = false>
                </#if>
                <#if cur_menu.name == node.name>
                    <a href="/${(cur_menu.name)!'javascript:;'}.html">
                        <li class="selected">${(cur_menu.title)!''}</li>
                    </a>
                <#else>
                    <a href="/${(cur_menu.name)!'javascript:;'}.html">
                        <li>${(cur_menu.title)!''}</li>
                    </a>
                </#if>
            </#if>
        </#if>
    </#list>
    </ul>
</nav>