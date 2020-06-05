<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生管理系统--管理员</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/register.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">学生管理系统--管理员</div>
    <ul class="layui-nav layui-layout-left">
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"> <a style="float: right; margin-top: 0px;">欢迎${adminId}管理员</a> </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login/page"> 退出</a> </li>
    </ul>
  </div>
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="${pageContext.request.contextPath}/addStudentPage" target="content">增加学生</a>
        </li>
        <li class="layui-nav-item">
          <a href="${pageContext.request.contextPath}/addCoursePage" target="content">增加课程</a>
        </li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/addScorePage" target="content">增加成绩</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/addTeacherPage" target="content">增加教师</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editStudentPage" target="content">修改学生</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editCourse" target="content">修改课程</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editScore" target="content">修改成绩</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editTeacherPage" target="content">修改教师</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/editAdmin?adminId=${adminId}" target="content">修改管理员</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/listStudent?pageStart=0" target="content">学生列表</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/listTeacher?pageStart=0" target="content">教师列表</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/listAdmin?pageStart=0" target="content">管理员列表</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/listCourse?pageStart=0" target="content">课程表</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/listScore?pageStart=0" target="content">成绩表</a></li>
      </ul>
      </ul>
    </div>
  </div>
  <div class="layui-body">
    
    <div style="padding: 15px;">
    	<iframe id="iframe" name="content" src="" margin-left="300px" width="100%" height="700px"></iframe>
    </div>
  </div>
</div>
  
  <div clas="layui-footer">
    		@课程管理
   </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/layui/js/layui.js">
layui.use('element', function(){
  var element = layui.element;
  
});
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

