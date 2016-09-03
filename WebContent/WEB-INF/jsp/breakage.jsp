<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title></title>
<script type="text/javascript">
function page(num){
	document.fm.pageNum.value = num;
	document.fm.submit();
}
</script>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/validate.expand.js"></script>
<script type="text/javascript" src="../js/messages_zh.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/ckform.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>
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
</head>
<body>
	<form name="fm" method="post" action="main/breakages" id="breakageFrom">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td colspan="3"><input type="hidden" name="pageNum" />起始时间:<input
					type="date" name="beginTime" id="begintime"></td>
				<td colspan="3">结束时间:<input type="date" name="endTime"></td>

				<td><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>报损单号</th>
				<th>产品编号</th>
				<th>产品名称</th>
				<th>数量</th>
				<th>仓库</th>
				<th>日期</th>
				<th>经办人</th>
				<th>备注</th>
				<th>状态</th>
			</tr>
			<c:forEach items="${breakages}" var="s">
				<tr>
					<td><c:out value="${s.breakageId}" /></td>
					<td><c:out value="${s.goodsId}" /></td>
					<td><c:out value="${s.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${s.goodsNum}" /></td>
					<td><c:out value="${s.getStock().getStockName()}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${s.breakageTime}" /></td>
					<td><c:out value="${s.getStaff().getStaffName()}" /></td>
					<td><c:out value="${s.breakageRemark}" /></td>
					<td><c:out value="${s.getState().getStateName()}" /></td>

				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="page">
		<a href="javascript:;" onclick="page(1)">第一页</a> | <a
			href="javascript:;" onclick="page(${page.pageNum - 1 })">上一页</a> | 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a href="javascript:;" onclick="page(${page.pageNum + 1 })">下一页</a>
		| <a href="javascript:;" onclick="page(${page.totalPage})">最后一页</a> |
	</div>
</body>
</html>