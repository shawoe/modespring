<header>
    <h1><img src="/image/logo2.png"></h1>
    <ul class="shortcut">
        <li><a>济南</a></li>
    <#if currentUser??>
        <li><a href="/center.html">会员中心</a></li>
        <li><a href="/modespring/index.html">后台管理</a></li>
    <#else>
        <li><a href="/login.html">登录</a></li>
    </#if>
    </ul>
</header>

<div class="ad">
    <img src="/image/ad.gif">
</div>

<nav>
    <ul class="nav">
    <#list nodeList as cur_node>
        <#if cur_node.level == 1>
            <#if node??>
                <#if cur_node.name == node.name || cur_node.name == node.parentNode.name >
                    <li class="selected">
                        <a href="/${(cur_node.name)!'javascript:;'}.html">${(cur_node.title)!''}</a>
                    </li>
                <#else>
                    <li><a href="/${(cur_node.name)!'javascript:;'}.html">${(cur_node.title)!''}</a></li>
                </#if>
            <#else>
                <li><a href="/${(cur_node.name)!'javascript:;'}.html">${(cur_node.title)!''}</a></li>
            </#if>
        </#if>
    </#list>
    </ul>

    <ul class="action">
        <li>
            <ul class="filter">
                <li>精华主题</li>
                <li>最新发表</li>
                <li>最后评论</li>
                <li>最多关注</li>
            </ul>
        </li>

        <li>
        <#if  node??>
            <ul class="menu">
                <#assign isFirst = true>
                <#list nodeList as cur_menu>
                    <#if cur_menu.level == 2>
                        <#if cur_menu.parentNode.name == node.name>
                            <#if isFirst == true>
                                <li class="selected"><a href="/${(node.name)!'javascript:;'}.html">显示全部</a></li>
                                <#assign isFirst = false>
                            </#if>
                            <li><a href="/${(cur_menu.name)!'javascript:;'}.html">${(cur_menu.title)!''}</a></li>
                        </#if>
                        <#if cur_menu.parentNode.name == node.parentNode.name>
                            <#if isFirst == true>
                                <li><a href="/${(node.parentNode.name)!'javascript:;'}.html">显示全部</a></li>
                                <#assign isFirst = false>
                            </#if>
                            <#if cur_menu.name == node.name>
                                <li class="selected">
                                    <a href="/${(cur_menu.name)!'javascript:;'}.html">${(cur_menu.title)!''}</a>
                                </li>
                            <#else>
                                <li><a href="/${(cur_menu.name)!'javascript:;'}.html">${(cur_menu.title)!''}</a></li>
                            </#if>
                        </#if>
                    </#if>
                </#list>
            </ul>
        </#if>
        </li>
    </ul>
</nav>