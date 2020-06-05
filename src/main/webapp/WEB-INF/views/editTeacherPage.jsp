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
    <title>修改教师</title>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/updateTeacherPage" role="form">
        <br>
        <br>
        <div class="layui-form-item">
            <p><h2>修改教师</h2></p>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">教师ID：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-id" id="teacher-id" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-name" id="teacher-name" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-pwd" id="teacher-pwd" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-IDC" id="teacher-IDC" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-sex" id="teacher-sex" required  lay-verify="required"  placeholder="性别" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生日期：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-birth" id="teacher-birth" placeholder="输入格式为：YYYY-MM-DD" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacherAge" id="teacherAge"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacherMail" id="teacherMail" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话号码：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-tel" id="teacher-tel"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">家庭住址：</label>
            <div class="layui-input-inline">
                <input type="text" name="teacher-addr" id="teacher-addr" class="layui-input">
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
