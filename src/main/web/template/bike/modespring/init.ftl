<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0"/>
    <title>ModeSpring 系统初始化</title>
    <link rel="stylesheet" type="text/css" href="/template/bike/modespring/style/layout.css"/>
    <!--[if lt IE 9]>
    <script src="/module/html5shiv/dist/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <h1><img src="/image/modespring.png" alt="ModeSpring"> - 系统初始化</h1>
</header>
<section class="content">
    <form action="/modespring/init.html" method="post">
        <label>网站名称：<input name="title" type="text" value="ModeSpring"></label>
        <label>网站URL：<input name="url" type="text" value="localhost:8080"></label>
        <label>网站LOGO：<input name="logo" type="text" value="/image/modespring.png"></label>
        <label>数据库URL：<input name="jdbcUrl" type="text" value="localhost"></label>
        <label>数据库名称：<input name="jdbcName" type="text" value="modespring"></label>
        <label>数据库用户名：<input name="jdbcUsername" type="text" value="root"></label>
        <label>数据库密码：<input name="jdbcPassword" type="text"></label>
        <label>初始管理员：<input name="username" type="text" value="admin"></label>
        <label>初始密码：<input name="password" type="text"></label>
        <label>电子邮箱：<input name="email" type="text"></label>
        <input type="submit" value="立即建站">
    </form>
</section>
</body>
</html>