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
    <title>课程编辑页面</title>
</head>
<body>
<div class="layui-body">
    <form method="post" action="${pageContext.request.contextPath}/updateCourse" role="form">
    		<br>
    		<br>
    		<div class="layui-form-item">
			   <p><h2>修改课程</h2></p>
			  </div>
			 <div class="layui-form-item">
			   <label class="layui-form-label">课程ID：</label>
			   <div class="layui-input-inline">
			      <input type="text" name="course_id" id="course_id"  class="layui-input">
			   </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">课程名称：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="course_name" id="course_name" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">教师ID：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="course_teacher" id="course_teacher" class="layui-input">
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
