<#include "common/_simditor.ftl">
<#include "common/_header.ftl">
<section class="content">
    <form id="writeArticleForm" action="" method="post">
        <label>文章标题<input name="title" type="text"></label>
        <textarea id="editor" placeholder="这里输入内容" autofocus></textarea>
        <input type="submit" value="发表文章">
    </form>
</section>
</div>
<script>
    var editor = new Simditor({
        textarea: $('#editor')
    });
</script>
<#include "common/_footer.ftl">