<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2016/6/3
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong></strong> <small>博客后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">1</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="admin-index.jsp"><span class="am-icon-home"></span>首页</a></li>

        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 用户模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
            <li><a href="admin-user-manage.jsp" class="am-cf"><span class="am-icon-check"></span>个人资料<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="#"><span class="am-icon-calendar"></span>系统日志</a></li>
          </ul>
        </li>


        <li><a href="${pageContext.request.contextPath}/article.action"><span class="am-icon-table"></span>文章模块</a></li>
        <li><a href="${pageContext.request.contextPath}/category.action"><span class="am-icon-table"></span>类别模块</a></li>
        <li><a href="${pageContext.request.contextPath}/guest.action"><span class="am-icon-table"></span>客户模块</a></li>
        <li><a href="${pageContext.request.contextPath}/commentManage.action"><span class="am-icon-table"></span>管理留言</a></li>

        <li><a href="UserAction_quit.action"><span class="am-icon-sign-out"></span>注销</a></li>
      </ul>


      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> to</p>
          <p>你不是人，你是天使，遇到你是我最大的狗屎运</p>
        </div>
      </div>
    </div>
  </div>
  <!-- sidebar end -->
</body>
</html>
