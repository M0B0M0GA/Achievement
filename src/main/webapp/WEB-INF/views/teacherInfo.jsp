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
<div class="panel-heading">
            <left><h3 class="panel-title">教师信息</h3></left>
        </div>
        <br>
        <br>
    <form class="layui-form" action="${pageContext.request.contextPath}/TeacherInfo" method="post">
			 <div class="layui-form-item">
			   <label class="layui-form-label">教师ID：</label>
			   <div class="layui-input-inline">
			      <input type="text" name="teacher-id" id="teacher-id" value="${tea_info.tId}" class="layui-input">
			   </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">姓名：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="teacher-name" id="teacher-name" value="${tea_info.tName}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密码：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="teacher-pwd" id="teacher-pwd" value="${tea_info.tPassword}" class="layui-input">
			    </div>
			  </div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-inline">
				<input type="text" name="teacher-sex" id="teacher-sex" value="${tea_info.tSex}" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄：</label>
			<div class="layui-input-inline">
				<input type="text" name="teacher-age" id="teacher-age" value="${tea_info.tAge}" class="layui-input">
			</div>
		</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">身份证号：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="teacher-IDC" id="teacher-IDC" value="${tea_info.tNum}" class="layui-input">
			    </div>
			  </div>

			  <div class="layui-form-item">
			    <label class="layui-form-label">出生日期：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="teacher-birth" id="teacher-birth" value="${tea_info.tBirthday}" class="layui-input">
			    </div>
			  </div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱：</label>
			<div class="layui-input-inline">
				<input type="text" name="teacher-mail" id="teacher-mail" value="${tea_info.tMail}" class="layui-input">
			</div>
		</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">电话号码：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="teacher-tel" id="teacher-tel" value="${tea_info.tTel}" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">家庭住址：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="address" id="address" value="${tea_info.tAddress}" class="layui-input">
			    </div>
			  </div>


	</form>
 </div>
</div>
</body>
</html>
