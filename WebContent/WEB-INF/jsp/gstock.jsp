<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>库存查询页面</title>
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

function page(num){
	document.fm.pageNum.value = num;
	document.fm.submit();
}
</script>
</head>
<body>
	<form name="fm" method="post" action="main/gstock">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>物品名称：<input type="hidden" name="pageNum" /><input
					type="text" name="goodsName" value="${goodsName}" /></td>
				<td>仓库名称：<input type="text" name="stockName"
					value="${stockName}" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>

			<tr>
				<th>物品ID</th>
				<th>物品名称</th>
				<th>物品价格</th>
				<th>物品数量</th>
				<th>仓库ID</th>
				<th>仓库名称</th>
				<th>仓库容量</th>
				<th>变更时间</th>
			</tr>

			<c:forEach items="${goodsStock}" var="g">
				<tr>
					<td><c:out value="${g.goodsId}" /></td>
					<td><c:out value="${g.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${g.getGoods().getGoodsPrice()}" /></td>
					<td><c:out value="${g.goodsNum}" /></td>
					<td><c:out value="${g.stockId}" /></td>
					<td><c:out value="${g.getStock().getStockName()}" /></td>
					<td><c:out value="${g.getStock().getStockVolume()}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${g.changeTime}" /></td>

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