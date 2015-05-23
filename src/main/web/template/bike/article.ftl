<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${(article.title)!''} -- ${(node.title)!''} -- ${(site.title)!''}</title>
    <link rel="stylesheet" type="text/css" href="/style/layout.css" />
    <link rel="stylesheet" type="text/css" href="/module/simditor/styles/simditor.css" />
    <script type="text/javascript" src="/module/simditor/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/module.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/hotkeys.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/uploader.js"></script>
    <script type="text/javascript" src="/module/simditor/scripts/simditor.js"></script>
</head>
<body>
<div class="wrapper">
<#include "common/_header.ftl">

<section>
    <h2>${(article.title)!''}</h2>
    <p>${(article.content)!''}</p>
    <textarea id="editor" placeholder="这里输入内容" autofocus></textarea>
    <script>
        var editor = new Simditor({
            textarea: $('#editor')
        });
    </script>
</section>
</div>
</body>
</html>