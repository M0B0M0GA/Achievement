<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>

    <title>教师信息页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/register.css">
    <script>

    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/listTeacher?pageStart=0" method="post">
        <tr>
            <input id="update" type="submit" value="刷新">
        </tr>
    </form>
</div>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>老师编号</th>
        <th>老师姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>老师年龄</th>
        <th>身份证号</th>
        <th>电话号码</th>
        <th>家庭住址</th>
        <th>出生日期</th>
        <th>邮箱</th>
        <th>验证码</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${teachers}">
        <tr>
            <td><c:out value="${row.tId}"/></td>
            <td><c:out value="${row.tName}"/></td>
            <td><c:out value="${row.tPassword}"/></td>
            <td><c:out value="${row.tSex}"/></td>
            <td><c:out value="${row.tAge}"/></td>
            <td><c:out value="${row.tNum}"/></td>
            <td><c:out value="${row.tTel}"/></td>
            <td><c:out value="${row.tAddress}"/></td>
            <td><c:out value="${row.tBirthday}"/></td>
            <td><c:out value="${row.tMail}"/></td>
            <td><c:out value="${row.tCaptcha}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
<nav class="pageDIV">
    <ul style="list-style-type:none;margin:0;padding:0;">
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a>
                <form action="${pageContext.request.contextPath}/listTeacher?pageStart=0" method="post">
                    <input type="submit" value="«">
                </form>
            </a>
        </li>
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listTeacher?pageStart=${page.start-page.count}" method="post">
                <input type="submit" value="‹">
            </form>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage}" varStatus="status">

            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <li style="margin:0 10px;float: left;"<c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a <c:if test="${status.index*page.count==page.start}">class="current"</c:if> >
                        <form action="${pageContext.request.contextPath}/listTeacher?pageStart=${status.index*page.count}" method="post">
                            <input type="submit" value=${status.count}>
                        </form>
                    </a>

                </li>
            </c:if>
        </c:forEach>

        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listTeacher?pageStart=${page.start+page.count}" method="post">
                <input type="submit" value="›">
            </form>
        </li>
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listTeacher?pageStart=${page.last}" method="post">
                <input type="submit" value="»">
            </form>
        </li>
    </ul>
</nav>
</body>
</html>
