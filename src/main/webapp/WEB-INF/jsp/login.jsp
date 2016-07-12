<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2016/7/6
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>红茶先森的个人博客 | Login Page</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <!-- GLOBAL STYLES -->
    <!-- PAGE LEVEL STYLES -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/magic/magic.css" />
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- END PAGE LEVEL STYLES -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body >
<%String s = session.getId(); //获取session ID号  %>
<%=s %>
<%
    session.setAttribute("clj1", "clj20150527");
%>
<!-- PAGE CONTENT -->
<div class="container">


    <div class="text-center">
        <img src="${pageContext.request.contextPath}/assets/img/logo.png" id="logoimg" alt=" Logo" />
    </div>
    <div class="tab-content">
        <div id="login" class="tab-pane active">
            <form action="${pageContext.request.contextPath}/user/login" class="form-signin" method="post">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">
                    Enter your username and password
                </p>
                <input type="text" name="userAcount" placeholder="Username" class="form-control" />
                <input type="password" name="userPwd" placeholder="Password" class="form-control" />
                <button class="btn text-muted text-center btn-danger" type="submit">Sign in</button>
            </form>
        </div>
        <div id="forgot" class="tab-pane">
            <form action="index.html" class="form-signin">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">Enter your valid e-mail</p>
                <input type="email"  required="required" placeholder="Your E-mail"  class="form-control" />
                <br />
                <button class="btn text-muted text-center btn-success" type="submit">Recover Password</button>
            </form>
        </div>
        <div id="signup" class="tab-pane">
            <form method="post" id="signupform" class="form-signin">
                <p class="text-muted text-center btn-block btn btn-primary btn-rect">Please Fill Details To Register</p>

                <input type="text" id="userAcount" name="userAcount" placeholder="User Acount" class="form-control" onBlur="checkUserName(this)" />
                <SPAN id="username_notice" ></SPAN>

                <input type="text" id="userName" name="userName" placeholder="User Name" class="form-control" />

                <input type="email" id="userEmail" name="userEmail" placeholder="Your E-mail" class="form-control"  onBlur="checkEmail(this)"/>
                <SPAN id=email_notice ></SPAN>

                <input type="password" id="userPwd" name="userPwd" placeholder="Password" class="form-control"  onkeyup="checkIntensity(this.value)" />
                <SPAN id=password_notice ></SPAN>
                <TR>
                    <TD><TABLE cellSpacing=0 cellPadding=1 width=145 border=0>
                        <TBODY>
                        <TR align=middle>
                            <TD id=pwd_lower width="33%">弱</TD>
                            <TD id=pwd_middle width="33%">中</TD>
                            <TD id=pwd_high width="33%">强</TD>
                        </TR>
                        </TBODY>
                    </TABLE></TD>
                </TR>

                <input type="text" id="userPhone" name="userPhone" placeholder="User Phone" class="form-control" />
                <br />
                <%--<button class="btn text-muted text-center btn-success" id="register" name="register" type="button"  onclick="checkUserRegister() " disabled>Register</button>--%>
                <input type=button value=确认注册  id="register" name="register" onclick="checkUserRigister(this)" class="btn text-muted text-center btn-success" disabled>
            </form>

        </div>
    </div>

    <div class="text-center">
        <ul class="list-inline">
            <li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li>
            <li><a class="text-muted" href="#forgot" data-toggle="tab">Forgot Password</a></li>
            <li><a class="text-muted" href="#signup" data-toggle="tab">Signup</a></li>

        </ul>

        <div class="modal" id="mymodal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">注册成功</h4>
                    </div>
                    <div class="modal-body">
                        <p>欢迎来到红茶先森的个人博客</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <a  href="#login" data-toggle="tab" data-dismiss="modal"><button type="button" class="btn btn-primary">登录</button></a>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <div class="modal" id="mymodal_fail">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">注册失败</h4>
                    </div>
                    <div class="modal-body">
                        <p>请核对您的信息</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</div>



<!--END PAGE CONTENT -->

<!-- PAGE LEVEL SCRIPTS -->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-2.0.3.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/login.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/registerCheck.js"></script>
<!--模态框的js资源-->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-transition.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>

<!--END PAGE LEVEL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
