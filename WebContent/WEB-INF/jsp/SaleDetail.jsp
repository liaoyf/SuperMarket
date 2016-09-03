<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<script type="text/javascript" src="../js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<form action="main/sale/add" class="definewidth m40" name="myform">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th>货名</th>
				<th>数量</th>
				<th>单价</th>
				<th>折扣</th>
				<th>仓库</th>
				<th colspan="2">操作</th>
			</tr>

			<c:forEach items="${saledetail}" var="u">
				<tr name="detail">
					<td><c:out value="${u.getGoods().getGoodsName()}" /></td>
					<td><c:out value="${u.number }" /></td>
					<td><c:out value="${u.price }" /></td>
					<td><c:out value="${u.goodsDiscount}" /></td>
					<td>
						<!-- 显示仓库id 变为名字 over--> <c:forEach items="${tgoodsstock}"
							var="gs">
							<c:forEach items="${stock}" var="ts">
								<c:if test="${gs.getGoodsId() == u.getGoodsId()}">
									<c:if test="${gs.getStockId() == ts.getStockId()}">
										<c:out value="${ts.getStockName()}" />
									</c:if>
								</c:if>
							</c:forEach>
						</c:forEach>
					</td>
					<td><a
						href="main/saledetail/edit?saleDetailId=<c:out value="${u.saleDetailId}" />">修改</a>
						</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8"><a href="main/saledetail/add">售货</a></td>
			</tr>
			<tr>
				<td>时间：<input type="text" name="saleTime"
					value="<c:out value='${date}'/>" readonly="readonly" /></td>
				<td><span>销售号(自动生成)</span></td>
				<td>售货员编号:<input type="text" name="staffId"
					value="<c:out value='${staff.staffId}'/>" readonly="readonly" >
						</input></td>
				<td>VIP顾客<select name="vipId">
						<!-- 顾客下拉框展示 -->
						<c:forEach items="${vip}" var="t">
							<option value="<c:out value='${t.vipId}'/>">
								<c:out value='${t.vipName}' />
							</option>
						</c:forEach>
				</select></td>
				<td>总价<input readonly="readonly" id="sum" type="text"
					name="saleNum" />元
				</td>
				<!-- 	TSale dto,Date date,Integer staffId , String vipId,Float saleNum -->
				<!-- over -->
				<td colspan="2"><input type="submit" value="确定" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			var sum = 0;
			$("[name='detail']").each(function() {
				var num = Number($(this).children("td:eq(1)").text());
				var price = Number($(this).children("td:eq(2)").text());
				var count = Number($(this).children("td:eq(3)").text());
				sum += num * price * count / 10;
			});
			$("#sum").attr("value", sum);
		});
	</script>
</body>
</html>
