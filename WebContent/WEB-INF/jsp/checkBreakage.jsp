<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/main.css">
<script type="text/javascript" src="../js/jquery.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title></title>
</head>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
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
<body>
	<div>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td style="width: 20px;"><input id="allCheck" type="checkbox" /></td>
				<th>报损编号</th>
				<th>货物名称</th>
				<th>货物数量</th>
				<th>仓库名称</th>
				<th>经手人</th>
				<th>报损时间</th>
				<th>报损原因</th>
				<th>审核状态</th>
			</tr>
			<c:forEach items="${saleBreakage}" var="b">
				<c:if test="${b.stateId==2}">
					<tr id="${b.breakageId}">
						<td><input class="oneCheck" name="box" type="checkbox" /></td>
						<td class="breakageId">${b.breakageId}</td>
						<td>${b.getGoods().goodsName }</td>
						<td>${b.goodsNum }</td>
						<td>${b.getStock().stockName }</td>
						<td>${b.getStaff().staffName }</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${b.breakageTime }" /></td>
						<td>${b.breakageRemark }</td>
						<td>${b.getState().stateName }</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<button id="inCheck" type="button" value="确认">确认</button>
	</div>
	<script type="text/javascript">
		//确认
		$("#inCheck").click(
				function() {
					var breakageId = "";
					$("[name='box']").each(
							function() {
								if ($(this).attr("checked")) {
									breakageId += $(this).parent().parent()
											.children(".breakageId").text()
											+ ",";
								}
							});

					$.post("/SuperMarket/main/BreakageCheck", {
						breakageId : breakageId
					}, function() {
						location.reload(); //刷新当前页面	
					});
				});

		//复选框全选跟全部取消
		$("#allCheck").click(function() {
			if ($("#allCheck").attr("checked") == "checked") {
				$("[type='checkbox']").attr("checked", 'true');
			} else {
				$("[type='checkbox']").removeAttr("checked");

			}
		});
	</script>
</body>
</html>