<body>
<div class="wrapper">
    <header>
        <h1><a href="${(site.url)!""}"><img src="${(site.logo)!''}" alt="${(site.title)!''}"></a></h1>
        <ul class="shortcut">
            <li><a>济南</a></li>
        <#if Session.currentUserName??>
            <li><a href="/center.html">会员中心</a></li>
            <li><a href="/logout.html">退出登录</a></li>
            <li><a href="/modespring/index.html">进入后台</a></li>
        <#else>
            <li><a href="/login.html">登录</a></li>
            <li><a href="/register.html">注册</a></li>
        </#if>
        </ul>
    </header>

    <div class="slide">
        <img src="/image/background.gif" alt="头部导航">
    </div>

    <nav>
        <ul class="nav">
        <#list nodeList as cur_node>
            <#if cur_node.level == 1>
                <#if node?? && node.parentNode??>
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

        <div class="action">
            <ul>
                <li><a href="/${(node.name)!''}/write.html">发表文章</a></li>
            </ul>
        </div>
    </nav>

    <div class="menu">
            <#if  node?? && node.parentNode??>
                <ul>
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
                                    <li><a href="/${(cur_menu.name)!'javascript:;'}.html">${(cur_menu.title)!''}</a>
                                    </li>
                                </#if>
                            </#if>
                        </#if>
                    </#list>
                </ul>
            </#if>

        <ul class="sequence">
            <li><a href="javascript:;">精华</a></li>
            <li class="selected"><a href="javascript:;">最新</a></li>
            <li><a href="javascript:;">热门</a></li>
            <li><a href="javascript:;">关注</a></li>
        </ul>
    </div>
