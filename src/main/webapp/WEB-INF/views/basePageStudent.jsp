<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理系统--学生</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/register.css">
    <script src="${pageContext.request.contextPath}/layui/js/layui.js"></script>
</head>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生管理系统--学生</div>
        <ul class="layui-nav layui-layout-left">
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"> <a style="float: right; margin-top: 0px;">欢迎${studentId}同学</a> </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login/page"> 首页</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editStudent?edit_id=${studentId}" target="content">修改信息</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/StudentInfo?studentId=${studentId}" target="content">个人信息</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/StudentCourse?studentId=${studentId}&pageStart=0" target="content">课程信息</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/StudentScore?studentId=${studentId}&pageStart=0" target="content">成绩信息</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">

        <div style="padding: 15px;">
            <iframe id="iframe" name="content" src="" margin-left="300px" width="100%" height="700px"></iframe>
        </div>
    </div>
</div>

<div clas="layui-footer layui-bg-black">

</div>
</div>
</body>
<script>
//Demo
layui.use('element', function(){
  var element = layui.element;
  
});
layui.use('form', function(){
  var form = layui.form;
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
</html>
