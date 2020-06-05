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
    <title>添加学生</title>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/addStudent" role="form">
    		<br>
    		<br>
    		<div class="layui-form-item">
			   <p><h2>添加学生</h2></p>
			  </div>

			  <div class="layui-form-item">
			    <label class="layui-form-label">姓名：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="name" id="name" placeholder="请在这里输入名字" required  lay-verify="required" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密码：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="password" id="password" placeholder="请在这里输入密码" required  lay-verify="required" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">年龄：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="age" id="age" placeholder="请在这里输入年龄" required  lay-verify="required" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">性别：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="student-sex" id="student-sex" required  lay-verify="required" placeholder="性别" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">出生日期：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="birthday" id="birthday" 
                                   required  lay-verify="required" placeholder="请在这里输入出生日期" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">地址：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="address" id="address" 
                                   required  lay-verify="required" placeholder="请在这里输入地址" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">电话：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="tel" id="tel" 
                                   required  lay-verify="required" placeholder="请在这里输入电话" class="layui-input">
			    </div>
			  </div>
				<div class="layui-form-item">
				<label class="layui-form-label">邮箱：</label>
				<div class="layui-input-inline">
					<input type="text" name="mail" id="mail"
						   required  lay-verify="required" placeholder="请在这里输入邮箱" class="layui-input">
				</div>
			</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">身份证号：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="IDCard" id="IDCard" 
                                   required  lay-verify="required" placeholder="请在这里输入身份证号" class="layui-input">
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
