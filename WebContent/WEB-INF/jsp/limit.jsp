<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>


<title>权限列表</title>
<base href="http://localhost:9999/SuperMarket/">
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	function del() {
		var msg = "確定刪除嗎？";
		if (confirm(msg) == true)
			return true;
		else
			return false;
	}
</script>
</head>

<body>

	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>权限id</th>
				<th>权限名称</th>
				<th>权限描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${limit}" var="l">
			<tr>
				<td><c:out value="${l.lPId}" /></td>
				<td><c:out value="${l.lPName}" /></td>
				<td><c:out value="${l.lPDescription}" /></td>
				<td><a
					href="main/limits/edit?lPId=<c:out value="${l.lPId}"></c:out>">修改</a>|
					<a href="main/limits/del?lPId=<c:out value="${l.lPId}"></c:out>"
					onclick="javascript:return del()">删除</a></td>
			</tr>

		</c:forEach>
		<tr>
			<td colspan="4"><a class="addlimits" href="main/limits/add">添加权限</a>
			</td>
		</tr>
	</table>
	<div class="page">
		<a href="main/limits?pageNum=1">第一页</a> | <a
			href="main/limits?pageNum=<c:out value="${page.pageNum - 1 }" />">上一页</a>
		| 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a
			href="main/limits?pageNum=<c:out value="${page.pageNum + 1 }" />">下一页</a>
		| <a href="main/limits?pageNum=<c:out value="${page.totalPage }" />">最后一页</a>
		|
	</div>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>