<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>红茶先森的博客后台</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/ckeditor.js"></script>
</head>
<body>

<%@include file="/WEB-INF/jsp/public/menu.jsp"%>

<!-- content start -->
<div class="admin-content">
  <div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
      <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">表单</strong> /
        <small>form</small>
      </div>
    </div>


    <form action="${pageContext.request.contextPath}/admin/article/create" method="post">

      <%--所属类别--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">所属类别</div>
        <div class="am-u-sm-8 am-u-md-10">
          <select data-am-selected="{btnSize: 'sm'}" name="categoryId">
            <c:forEach items="${categories}" var="cate"  >
              <option value="${cate.categoryId}" ${tbArticleEntity.categoryId==cate.categoryId?'selected':''}>${cate.categoryName}</option>
            </c:forEach>
          </select>
          <td>
            <a href="javascript:addCategory('${pageContext.request.contextPath}/manage/category_add.action')">添加类别</a>
          </td>
        </div>
      </div>

      <%--类型--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">类型</div>
        <div class="am-u-sm-8 am-u-md-10">
          <select id="type" name="articleType">
            <option value="原创" ${tbArticleEntity.articleType=='原创'?'selected':''}>原创</option>
            <option value="转载" ${tbArticleEntity.articleType=='转载'?'selected':''}>转载</option>
          </select>
        </div>
      </div>

      <%--是否置顶--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">是否置顶</div>
        <div class="am-u-sm-8 am-u-md-10">
          <select id="top" name="articleTop">
            <option value="0" ${tbArticleEntity.articleTop==0?'selected':''}>不顶置</option>
            <option value="1" ${tbArticleEntity.articleTop==1?'selected':''}>顶置</option>
          </select>
        </div>
      </div>

      <%--文章标题--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">文章标题</div>
        <div class="am-u-sm-8 am-u-md-10">
          <input type="text" class="am-input-sm"  name="articleTitle">
        </div>
      </div>

      <%--内容摘要--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">内容摘要</div>
        <div class="am-u-sm-8 am-u-md-10">
          <td><textarea name="articleMeta" cols="50" rows="4">${fn:escapeXml(tbArticleEntity.articleMeta)}</textarea></td>
        </div>
      </div>

      <%--内容描述--%>
      <div class="am-g am-margin-top">
        <div class="am-u-sm-4 am-u-md-2 am-text-right">内容描述</div>
        <div class="am-u-sm-8 am-u-md-10">
          <td><textarea name="articleContent" id="content">${fn:escapeXml(tbArticleEntity.articleContent)}</textarea></td>
        </div>
      </div>
  </div>

  <div class="am-margin">
    <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
    <button type="submit" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
  </div>
  </form>
</div>


<footer class="admin-content-footer">
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>
</div>
<!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>
<script type="text/javascript">
  CKEDITOR.replace('content');
  function addCategory(url){
    var categoryName = window.prompt("添加文章类别");
    if(categoryName==null||categoryName.trim().length<=0) {
      alert("文章类别不能为空哦！");
      return;
    }

    //类别已存在
    var select = document.getElementById('cid');
    var options = select.options;
    for(var i=0;i<options.length;i++){
      if(options[i].innerHTML==categoryName.trim()) {
        alert("你添加的类别已存在！");
        return;
      }
    }
    //符合条件，进行请求,模拟post表单
    var form = document.createElement("form");
    form.action = url;
    form.method = 'post';
    form.style.display = 'none';
    var input = document.createElement("input");
    input.type = "text";
    input.name = "cname";
    input.value = categoryName;
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
  }
</script>
</html>
