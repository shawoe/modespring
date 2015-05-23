<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>发布文章 - ${(node.title)!''} - ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/module/simditor/styles/simditor.css"/>
    <script type="text/javascript" src="/module/simditor/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/module.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/hotkeys.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/uploader.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/simditor.js"></script>
    <!--[if lt IE 9]>
    <script src="/module/html5shiv/dist/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">
    <div class="content">
        <section>
            <form id="writeArticleForm" action="" method="post">
                <textarea id="editor" placeholder="这里输入内容" autofocus></textarea>
            </form>
        </section>
    </div>
</div>
<script>
    var editor = new Simditor({
        textarea: $('#editor')
    });
</script>
</body>
</html>