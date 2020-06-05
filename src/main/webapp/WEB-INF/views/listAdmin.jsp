<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>

    <title>管理员信息页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/register.css">
    <script>

    </script>
</head>
<body>
<form class="layui-form" action="${pageContext.request.contextPath}/listAdmin?post=0" method="post">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>管理员编号</th>
            <th>管理员姓名</th>
            <th>密码</th>
            <th>邮箱</th>
            <th>验证码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${admin}">
            <tr>
                <td><c:out value="${row.aId}"/></td>
                <td><c:out value="${row.aName}"/></td>
                <td><c:out value="${row.aPassword}"/></td>
                <td><c:out value="${row.aMail}"/></td>
                <td><c:out value="${row.aCaptcha}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
