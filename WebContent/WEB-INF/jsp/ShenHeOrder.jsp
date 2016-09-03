<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>审核订单</title>
</head>
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

<body>
	<form action="/SuperMarket/main/shenhe/pass" method="post">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<th></th>
				<th>采购ID</th>
				<th>货物名字</th>
				<th>货物数量</th>
				<th>进价</th>
				<th>供应商ID</th>
				<th>供应商名字</th>
				<th>采购人员ID</th>
				<th>采购人员名字</th>
				<th>状态ID</th>
				<th>状态详情</th>
			</tr>


			<c:forEach items="${order}" var="u">
				<!--下一步 ， 将stockId和VipId和StaffId改为名字 over -->
				<tr id="${u.orderId }">
					<td><input class="oneCheck" type="checkbox"
						value="<c:out value='${u.orderId}' /> " name="orderId" /></td>
					<td class="orderId"><c:out value="${u.orderId }" /></td>
					<!-- 货物的名字 -->
					<td><c:forEach items="${tgoodsorderkey}" var="key">
						
							<c:if test="${key.orderId == u.orderId}">
								<c:forEach items="${goods}" var="goods">
								
									<c:if test="${key.goodsId == goods.goodsId}">
										<c:out value="${goods.goodsName}" />
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach></td>
					<td><c:out value="${u.goodsNum }" /></td>
					<td><c:out value="${u.goodsOrderPrice }" /></td>
					<td><c:out value="${u.supplierId}" /></td>
					<!-- 供应商的名字 -->
					<td><c:forEach items="${supplier}" var="su">
							<c:if test="${su.supplierId == u.supplierId}">
								<c:out value="${su.supplierName}" />
							</c:if>
						</c:forEach></td>
					<td><c:out value="${u.principal}" /></td>
					<!-- 经手人的名字 -->
					<td><c:forEach items="${staff}" var="st">
							<c:if test="${st.staffId == u.principal}">
								<c:out value="${st.getStaffName()}" />
							</c:if>
						</c:forEach></td>




					<td><c:out value="${u.stateId}" /></td>
					<!-- 状态名字 -->
					<td><c:forEach items="${state}" var="ta">
							<c:if test="${ta.stateId == u.stateId}">
								<c:out value="${ta.stateName}" />
							</c:if>
						</c:forEach></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="11"><input id="pass" type="submit" value="审核通过"></input></td>
			</tr>
		</table>


	</form>

</body>
</html>