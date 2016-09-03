<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>盘点页面</title>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
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
	<form>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td><input type="text" name="outStockId" placeholder="请输入出库编号" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>出库ID</th>
				<th>出库时间</th>
				<th>仓库ID</th>
				<th>仓库名称</th>
				<th>出库人</th>
				<th>物品ID</th>
				<th>物品名称</th>
				<th>物品数量</th>
			</tr>

			<c:forEach items="${outStock}" var="o">
				<tr>
					<td><c:out value="${o.outStockId}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${o.outStockTime}" /></td>
					<td><c:out value="${o.stockId}" /></td>
					<td><c:out value="${o.getStock().getStockName()}" /></td>
					<td><c:out value="${o.outStockPrincipal}" /></td>
					<td><c:out value="${o.goodsId}" /></td>
					<td><c:out value="${o.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${o.goodsOutNum}" /></td>
				</tr>
			</c:forEach>

		</table>
		<br>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td><input type="text" name="inStockId" placeholder="请输入入库编号" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>入库ID</th>
				<th>入库时间</th>
				<th>仓库ID</th>
				<th>仓库名称</th>
				<th>入库人</th>
				<th>物品ID</th>
				<th>物品名称</th>
				<th>物品数量</th>
			</tr>

			<c:forEach items="${inStock}" var="i">
				<tr>
					<td><c:out value="${i.inStockId}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${i.inStockTime}" /></td>
					<td><c:out value="${i.stockId}" /></td>
					<td><c:out value="${i.getStock().getStockName()}" /></td>
					<td><c:out value="${i.inStockPrincipal}" /></td>
					<td><c:out value="${i.goodsId}" /></td>
					<td><c:out value="${i.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${i.goodsInNum}" /></td>
				</tr>
			</c:forEach>

		</table>

	</form>
</body>
</html>