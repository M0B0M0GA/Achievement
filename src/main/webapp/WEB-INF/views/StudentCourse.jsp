<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>学生课表</title>
	<%-- 引入JQ和Bootstrap --%>
	<script src="${pageContext.request.contextPath}/layui/js/layui.js"></script>
	<link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/layui/js/layui.js"></script>
	<link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet">
	<script>
		$(function () {
			$("ul.pagination li.disabled a").click(function () {
				return false;
			});
		});

	</script>
</head>
<body>

<div>
	<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=0&studentId=${studentId}" method="post">
		<tr>
			<input id="update" type="submit" value="刷新">
		</tr>
	</form>
</div>

<div class="listDIV">
	<table class="table table-striped table-bordered table-hover table-condensed">

		<caption>课程列表 - 共${page.total }条</caption>
		<thead>
		<tr class="success">
			<th>课程id</th>
			<th>课程名</th>
			<th>授课老师编号</th>
			<th>授课老师姓名</th>
		</tr>
		</thead>

		<tbody>
		<c:forEach items="${courses}" var="s" varStatus="status">
			<tr>
				<td>${s.cId}</td>
				<td>${s.cName}</td>
				<td>${s.tId}</td>
				<td>${s.tName}</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	</form>
</div>

<nav class="pageDIV">
	<ul style="list-style-type:none;margin:0;padding:0;">
		<li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
			<a>
				<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=0&studentId=${studentId}" method="post">
					<input type="submit" value="«">
				</form>
			</a>
		</li>
		<li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
			<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=${page.start-page.count}&studentId=${studentId}" method="post">
				<input type="submit" value="‹">
			</form>
			</a>
		</li>

		<c:forEach begin="0" end="${page.totalPage-2}" varStatus="status">

			<c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
				<li style="margin:0 10px;float: left;"<c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
					<a <c:if test="${status.index*page.count==page.start}">class="current"</c:if> >
						<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=${status.index*page.count}&studentId=${studentId}" method="post">
							<input type="submit" value=${status.count}>
						</form>
					</a>

				</li>
			</c:if>
		</c:forEach>

		<li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
			<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=${page.start+page.count}&studentId=${studentId}" method="post">
				<input type="submit" value="›">
			</form>
		</li>
		<li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
			<form action="${pageContext.request.contextPath}/StudentCourse?pageStart=${page.last}&studentId=${studentId}" method="post">
				<input type="submit" value="»">
			</form>
		</li>
	</ul>
</nav>

</body>
</html>
