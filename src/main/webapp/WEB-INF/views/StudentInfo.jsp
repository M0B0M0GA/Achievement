<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>个人信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/js/layui.js"></script>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/StudentInfo" method="post">
    		<br>
    		<br>
    		<div class="layui-form-item">
			   <p><h2>学生信息</h2></p>
			  </div>
			 <div class="layui-form-item">
			   <label class="layui-form-label">学号：</label>
			   <div class="layui-input-inline">
			      <input type="text" name="student_id" id="student_id" value="${stu_info.sId}" class="layui-input">
			   </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">姓名：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="name" id="name" value="${stu_info.sName}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密码：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="password" id="password" value="${stu_info.sPassword}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">年龄：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="age" id="age" value="${stu_info.sAge}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">性别：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="sex" id="sex" value="${stu_info.sSex}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">出生日期：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="birthday" id="birthday" value="${stu_info.sBirthday}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">地址：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="address" id="address" value="${stu_info.sAddress}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">电话：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="tel" id="tel" value="${stu_info.sTel}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">身份证号：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="IDCard" id="IDCard" value="${stu_info.sNum}" class="layui-input">
			    </div>
			  </div>
	</form>
 </div>
</body>
</html>
