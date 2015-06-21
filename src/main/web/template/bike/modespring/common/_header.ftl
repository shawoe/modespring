<body>
<header>
    <h1><img src="/image/modespring.png" alt="ModeSpring"></h1>
    <ul>
        <li><a href="/index.html">前台首页</a></li>
        <li><a href="/logout.html">退出登录</a></li>
    </ul>
</header>

<nav>
    <ul class="clearfix">
        <#list mospList as cur_mosp>
            <#if MospNodeName == cur_mosp.name>
                <li class="selected"><a href="/modespring/${(cur_mosp.name)!''}.html">${(cur_mosp.title)!''}</a></li>
            <#else>
                <li><a href="/modespring/${(cur_mosp.name)!''}.html">${(cur_mosp.title)!''}</a></li>
            </#if>
        </#list>
    </ul>
</nav>