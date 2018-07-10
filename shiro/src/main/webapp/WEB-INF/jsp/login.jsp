<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <base href="<%=path%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="static/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="static/jquery/1.7.2/jquery.min.js"></script>
    <script src="static/bootstrap/2.3.2/js/bootstrap.min.js"></script>

    <style type="text/css">
        .loginBox{width:240px;height:230px;padding:0 20px;border:1px solid #fff; color:#000; margin-top:40px; border-radius:8px;background: white;box-shadow:0 0 15px #222; background: -moz-linear-gradient(top, #fff, #efefef 8%);background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));font:11px/1.5em 'Microsoft YaHei' ;position: absolute;left:50%;top:50%;margin-left:-120px;margin-top:-115px;}
        .loginBox h2{height:45px;font-size:20px;font-weight:normal;}
        .loginBox .left{border-right:1px solid #ccc;height:100%;padding-right: 20px; }
    </style>
</head>
<body>
"${status}"
<form action="signIn" method="post">
    <div class="container">
        <section class="loginBox row-fluid">
            <section class="span12">
                <h2>欢迎登录</h2>
                <p><input type="text" name="userName" placeholder="用户名"/></p>
                <p><input type="text" name="password" placeholder="密码"/></p>
                <section class="row-fluid">
                    <section class="span8 lh30"><label><input type="checkbox" name="rememberme" />下次自动登录</label></section>
                    <section class="span1"><input type="submit" value="登录 " class="btn btn-primary"></section>
                </section>
            </section>
        </section>
    </div>
</form>
</body>
</html>