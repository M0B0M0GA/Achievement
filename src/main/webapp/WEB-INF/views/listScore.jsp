<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>

    <title>成绩信息页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/register.css">
    <script>

    </script>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/listScore?pageStart=0" method="post">
        <tr>
            <input id="update" type="submit" value="刷新">
        </tr>
    </form>
</div>
<div class="listDIV">
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <caption>成绩列表 - 共${page.total}条</caption>
    <thead>
    <tr>
        <th>成绩编号</th>
        <th>学生编号</th>
        <th>课程编号</th>
        <th>成绩</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${score}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.sid}"/></td>
            <td><c:out value="${row.cid}"/></td>
            <td><c:out value="${row.score}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</form>
<nav class="pageDIV">
    <ul style="list-style-type:none;margin:0;padding:0;">
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a>
                <form action="${pageContext.request.contextPath}/listScore?pageStart=0" method="post">
                    <input type="submit" value="«">
                </form>
            </a>
        </li>
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listScore?pageStart=${page.start-page.count}" method="post">
                <input type="submit" value="‹">
            </form>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-2}" varStatus="status">

            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <li style="margin:0 10px;float: left;"<c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a <c:if test="${status.index*page.count==page.start}">class="current"</c:if> >
                        <form action="${pageContext.request.contextPath}/listScore?pageStart=${status.index*page.count}" method="post">
                            <input type="submit" value=${status.count}>
                        </form>
                    </a>

                </li>
            </c:if>
        </c:forEach>

        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listScore?pageStart=${page.start+page.count}" method="post">
                <input type="submit" value="›">
            </form>
        </li>
        <li style="margin:0 10px;float: left;"<c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <form action="${pageContext.request.contextPath}/listScore?pageStart=${page.last}" method="post">
                <input type="submit" value="»">
            </form>
        </li>
    </ul>
</nav>
</body>
</html>
