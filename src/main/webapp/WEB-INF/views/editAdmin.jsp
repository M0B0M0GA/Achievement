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
    <title>学生管理页面 - 编辑页面</title>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/updateAdmin?adminId=${update_Admin.aId}" role="form">
        <br>
        <br>
        <div class="layui-form-item">
            <p><h2>修改学生</h2></p>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学号：</label>
            <div class="layui-input-inline">
                <input type="text" name="id" id="id"
                       required  lay-verify="required" placeholder="请在这里输入学号" value="${update_Admin.aId}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name" placeholder="请在这里输入名字" value="${update_Admin.aName}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="text" name="password" id="password" placeholder="请在这里输入密码" value="${update_Admin.aPassword}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱：</label>
            <div class="layui-input-inline">
                <input type="text" name="mail" id="mail" value="${update_Admin.aMail}"
                       placeholder="请在这里输入邮箱" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
