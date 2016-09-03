<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<base href="http://localhost:9999/SuperMarket/">
<link rel="stylesheet" type="text/css" href="templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="templet/Css/style.css" />
<script type="text/javascript" src="templet/Js/jquery.js"></script>
<script type="text/javascript" src="templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="templet/Js/common.js"></script>
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

	<form action="../sale" method="post">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th>销售清单号</th>
				<th>货物名字</th>
				<th>数量</th>
				<th>单价</th>
				<th>折扣</th>
				<th>货物仓储</th>
			</tr>
			<!-- 展示销售详情 -->
			<c:forEach items="${saledetail}" var="u">
				<tr>
					<td><c:out value="${u.saleDetailId }" /></td>
					<td><c:out value="${u.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${u.number }" /></td>
					<td><c:out value="${u.price }" /></td>
					<td><c:out value="${u.goodsDiscount}" /></td>

					<td>
						<!-- 显示仓库id 变为名字 over--> <c:forEach items="${goodsstock}" var="gs">
							<c:forEach items="${stock}" var="ts">
								<c:if test="${gs.getGoodsId() == u.getGoodsId()}">
									<c:if test="${gs.getStockId() == ts.getStockId()}">
										<c:out value="${ts.getStockName()}" />
									</c:if>
								</c:if>
							</c:forEach>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>

		</table>




	</form>
</body>
</html>