<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>红茶先森的博客</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/assets/style.css" />
	<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/assets/style/css/font-awesome.min.css" />
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,300italic,300,700,700italic|Open+Sans+Condensed:300,700" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/style/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/style/js/retina.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/style/js/selectnav.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/style/js/jquery.backstretch.min.js"></script>
	<script type="text/javascript">
		$.backstretch("${pageContext.request.contextPath}/assets/style/images/bg/1.jpg");
	</script>
</head>
<body>
<%@include file="/WEB-INF/jsp/public/header.jsp"%>

<div class="wrapper">
	<div class="content">
		<c:forEach items="" var="art">
			<div class="post format-image box">
				<div class="details">
					<span class="icon-image"></span>
            <span class="likes"><a href="#"
								   class="likeThis"></a></span>
					<span class="comments"><a href="#"></a></span>
				</div>
				<h1 class="title"><a href="l"></a></h1>

					<%--<p>${art.articleMeta}</p>--%>

				<div class="tags"><a href="#"></a></div>
				<div class="post-nav">
            <span class="nav-prev"><a
					href="">类型：</a></span>
					<span class="nav-next"><a href="#">作者：</a></span>

					<div class="clear"></div>
				</div>
			</div>
		</c:forEach>
		<div class="post format-image box">
			<h3 style="text-align:center"><a href="">查看更多</a></h3>
		</div>
	</div>

	<div class="sidebar box">
		<div class="sidebox widget">
			<h3 class="widget-title">最近更新</h3>
			<ul class="post-list">
				<c:forEach items="" var="art">
					<li>
						<div class="meta">
							<h5><a href=""></a></h5>
							<em></em>
						</div>
					</li>
				</c:forEach>
				<li class="more"><a href="">more</a></li>
			</ul>
		</div>

		<div class="sidebox widget">
			<h3 class="widget-title"><i class="icon-search icon"></i></h3>

			<form class="searchform" method="post" action="">
				<input type="text" name="key" value="输入关键字搜索博客..." onFocus="this.value=''"
					   onBlur="this.value='输入关键字搜索博客...'"/>
			</form>
		</div>

		<div class="sidebox widget">
			<h3 class="widget-title categories">分类</h3>
			<ul class="categories">
				<c:forEach items="" var="cate">
					<li><a href=""></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jsp/public/footer.jsp"%>
</body>
</html>
