<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2016/5/16 0016
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="scanlines"></div>
<div class="header-wrapper opacity">
  <div class="header">
    <div class="logo">
      <a href="${pageContext.request.contextPath}/">
        <h1>红茶先森的博客</h1>
      </a>
    </div>

    <div id="menu-wrapper">
      <div id="menu" class="menu">
        <ul id="tiny">
          <li class="active">
            <a href="${pageContext.request.contextPath}/">博客</a>
            <ul>
              <li><a href="${pageContext.request.contextPath}/listArticle.action">所有博文</a></li>
            </ul>
          </li>
          <li>
            <a href="https://github.com/SuperNoobTao" title="进入我的Github">Github</a>
          </li>
          <li>
            <a href="http://blog.csdn.net/qq_20079725" title="进入我的CSDN博客">CSDN博客</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/commentUI.action" title="给我留言">留言板</a>
          </li>


          <li><a href="#">Menu</a>
            <ul>
              <li><a href="">仓库管理系统</a></li>
              <li><a href="">你画我猜小游戏</a></li>
              <li><a href="">IOnline</a></li>
              <li><a href="">管理员</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    <div class="clear"></div>
  </div>
</div>

<div class="wrapper">
  <ul class="social">
    <li><a class="rss" href="#" title="博客订阅"></a></li>
    <li><a class="qq" href="tencent://message/?uin=387944558&Site=&Menu=yes" title="QQ"></a></li>
    <li><a class="weibo" href="#" title="新浪微博"></a></li>
    <li><a class="wechat" href="${pageContext.request.contextPath}/public/wechat.jsp" title="微信"></a></li>
    <li><a class="email" href="mailto:387944558@qq.com" title="邮件"></a></li>
    <li><a class="phone" href="tel:15167195271" title="手机"></a></li>
  </ul>
  <div class="intro">你不是人,你是天使!遇上你是我这辈子最大的狗屎运。</div>
</div>
