<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2016/7/6
  Time: 9:26e
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游客页面</title>
</head>
<body>
游客页面
<%String s = session.getId(); //获取session ID号  %>
<%=s %>
<br/>
<br/>
<%=(String)session.getAttribute("clj1")%>
</body>
</html>
