<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购单页面</title>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
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
<script type="text/javascript">

function page(num){

	document.fm.pageNum.value = num;
	document.fm.submit();
}
</script>
</head>


<body>
	<form action="order" method="post" name="fm" >
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td><label>货名</label></td>
				<td><input type="hidden" name="pageNum" /><input type="text" name="goodsName" value="${goodsName}" /></td>
				<td><label>供应商</label></td>
				<td><input type="text" name="supplierName"
					value="${supplierName}" /></td>
				<td><label>采购人</label></td>
				<td><input type="text" name="staffName" value="${staffName}" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>货名</th>
				<th>数量</th>
				<th>进价</th>
				<th>供应商</th>
				<th>采购人</th>
				<th colspan="2">状态详情</th>
			</tr>


			<c:forEach items="${order}" var="u">
				<!--下一步 ， 将stockId和VipId和StaffId改为名字 over -->
				<tr>
					<!-- 货物的名字 -->
					<td><c:forEach items="${goodsorderkey}" var="key">
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
					<!-- 供应商的名字 -->
					<td><c:forEach items="${supplier}" var="su">
							<c:if test="${su.supplierId == u.supplierId}">
								<c:out value="${su.supplierName}" />
							</c:if>
						</c:forEach></td>
					<!-- 经手人的名字 -->
					<td><c:forEach items="${staff}" var="st">
							<c:if test="${st.staffId == u.principal}">
								<c:out value="${st.getStaffName()}" />
							</c:if>
						</c:forEach></td>




					<!-- 状态名字 -->
					<td colspan="2"><c:forEach items="${state}" var="ta">
							<c:if test="${ta.stateId == u.stateId}">
								<c:out value="${ta.stateName}" />
							</c:if>
						</c:forEach></td>
				</tr>
			</c:forEach>
		</table>


	</form>
	<div class="page">
		<a href="javascript:;" onclick="page(1)">第一页</a> | <a
			href="javascript:;" onclick="page(${page.pageNum - 1})">上一页</a> | 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a href="javascript:;" onclick="page(${page.pageNum + 1 })">下一页</a>
		| <a href="javascript:;" onclick="page(${page.totalPage})">最后一页</a> |
	</div>
</body>
</html>


<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>