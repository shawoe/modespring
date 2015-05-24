<#include "common/_simditor.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form id="sendArticleForm" action="" method="post">
        <label>短消息标题<input name="title" type="text"></label>
        <label>收信人<input name="addressee" type="text"></label>
        <textarea id="editor" placeholder="这里输入内容" autofocus></textarea>
        <input type="submit" value="发送短消息">
    </form>
</section>
</div>
<script>
    var editor = new Simditor({
        textarea: $('#editor')
    });
</script>
<#include "common/_footer.ftl">