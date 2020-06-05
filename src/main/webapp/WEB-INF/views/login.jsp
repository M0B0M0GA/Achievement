<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/js/layui.js">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/login.css">
    <script>
        function validate() {
            var pro = document.getElementById("loginType").value;
            var a = document
            if (pro!="管理员"&&pro!="学生"&&pro!="教师") {
                window.alert("身份输入违规，请重新输入！");
                return false;
            }
        }
    </script>
</head>
<body class='body'>
<h2 class="h2"><center><font face="verdana">登录页面</font></center></h2>
<br>
<div class="login-main">
    <form class="layui-form" action="${pageContext.request.contextPath}/login" method="post">
        <div class="layui-input-inline">
            <input type="text" name="account" required lay-verify="required" placeholder="用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <br>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <br>
        <div class="layui-input-inline">
            <input type="text" id="loginType" name="loginType" required lay-verify="required" placeholder="教师、学生、管理员" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="login" class="layui-btn" onclick="validate();">登录</button>
        </div>
        
        <hr/>
        <a href="${pageContext.request.contextPath}/findPasswordPage" class="fl">忘记密码？</a></p>
    </form>
</div>
</body>
</html>