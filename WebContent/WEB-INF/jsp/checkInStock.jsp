<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>入库查询</title>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>
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

	<div>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th><input id="allCheck" type="checkbox" /></th>
				<th>订单编号</th>
				<th>货物名称</th>
				<th>货物数量</th>
				<th>订单总价</th>
				<th>供货商</th>
				<th>经手人</th>
				<th>审核状态</th>
			</tr>
			<c:forEach items="${order}" var="o">
				<c:if test="${o.stateId==3}">
					<tr id="${o.orderId}">
						<td><input class="oneCheck" name="box" type="checkbox" /></td>
						<td class="orderId">${o.orderId}</td>
						<td>${o.getGoods().goodsName }</td>
						<td>${o.goodsNum }</td>
						<td>${o.goodsOrderPrice }</td>
						<td>${o.getSupplier().supplierName }</td>
						<td>${o.getStaff().staffName }</td>
						<td>${o.getState().stateName }</td>
					</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="8"><button id="inStock" type="button" value="入库">入库</button></td>
			</tr>
		</table>

	</div>
	<script type="text/javascript">
		//入库
		$("#inStock").click(
				function() {
					var orderId = "";
					$("[name='box']").each(
							function() {
								if ($(this).attr("checked")) {
									orderId += $(this).parent().parent()
											.children(".orderId").text()
											+ ",";
								}
							});
					$.post("/SuperMarket/main/InStock", {
						orderId : orderId
					}, function() {
						location.reload(); //刷新当前页面	
					});
				});

		//复选框全选跟全部取消
		$("#allCheck").click(function() {
			if ($("#allCheck").attr("checked") == "checked") {
				$("[type='checkbox']").attr("checked", 'ture');
			} else {
				$("[type='checkbox']").removeAttr("checked");
			}
		});
	</script>
</body>
</html>