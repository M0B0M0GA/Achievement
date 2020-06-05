<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/js/layui.js">
        layui.use('form', function(){
            var form = layui.form;
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
    <title>密码找回</title>
</head>
<body>
<h2 class="h2"><center><font face="verdana">找回密码</font></center></h2>
<br>
<div class="login-main">
    <form class="layui-form" action="${pageContext.request.contextPath}/findPassword" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">登录邮箱：</label>
            <div class="layui-input-inline">
                <input type="email" placeholder="请输入登录邮箱" name="email" id="email"  lay-verify="required" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">注册时的邮箱</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">身份：</label>
            <div class="layui-input-inline">
                <input type="text" id="pro-o" name="forgetType" required lay-verify="required" placeholder="教师、学生、管理员" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    function submitEmail(){
        var pro = document.getElementById("pro-o").value;
        if (pro!="管理员"&&pro!="学生"&&pro!="教师") {
            window.alert("身份输入违规，请重新输入！");
            return false;
        };
    }
</script>
</body>
</html>
