<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <title>添加管理员</title>
</head>
<body>
<div class="layui-body">
    <form method="post" action="${pageContext.request.contextPath}/addAdmin" role="form">
        <br>
        <br>
        <div class="layui-form-item">
            <p><h2>修改管理员</h2></p>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-inline">
                <input type="text" name="a_name" id="a_name" placeholder="管理员姓名" required  lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="text" name="a_password" id="a_password" placeholder="请在这里输入密码" required  lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱：</label>
            <div class="layui-input-inline">
                <input type="text" name="a_mail" id="a_mail" placeholder="请在这里输入邮箱" required  lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码：</label>
            <div class="layui-input-inline">
                <input type="text" name="a_captcha" id="a_captcha" placeholder="请在这里输入验证码" required  lay-verify="required" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="button" class="layui-btn layui-btn-primary">发送</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
