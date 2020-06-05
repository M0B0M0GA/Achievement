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
    <title>分数编辑页面</title>
</head>
<body>
<div class="layui-body">
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/updateScore" role="form">
    		<br>
    		<br>
    		<div class="layui-form-item">
			   <p><h2>修改成绩</h2></p>
			  </div>
			 <div class="layui-form-item">
			   <label class="layui-form-label">成绩序号：</label>
			   <div class="layui-input-inline">
			      <input type="text" name="score_id" id="score_id" placeholder="请在这里输入成绩序号" class="layui-input">
			   </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">学生学号：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="score_stuID" id="score_stuID" placeholder="请在这里输入学号" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">课程号：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="score_CourseID" id="score_CourseID" placeholder="请在这里输入课程号" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">分数：</label>
			    <div class="layui-input-inline">
			      <input type="text" name="score" id="score" placeholder="请在这里输入分数" class="layui-input">
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
