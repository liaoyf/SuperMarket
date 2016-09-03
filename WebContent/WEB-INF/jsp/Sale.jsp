<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript" src="templet/Js/jquery.js"></script>
<script type="text/javascript" src="templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="templet/Js/common.js"></script>
<base href="http://localhost:9999/SuperMarket/">
</head>
<body>
	<form name="fm" method="post" action="main/sale">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td><input type="hidden" name="pageNum" />日期<input type="date"
					name="saleTime" <c:out value='date' /> /></td>
				<td>售货员<select name="staffId" placeholder="选择售货员的名字">

						<option></option>
						<c:forEach items="${staff}" var="s">
							<option value="<c:out value='${s.staffId}'/>">
								<c:out value='${s.staffName}' />
							</option>
						</c:forEach>
				</select>
				</td>
				<td colspan="4"><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>销售单号</th>
				<th>销售时间</th>
				<th>销售总价</th>
				<th>会员姓名</th>
				<th>员工姓名</th>
				<th></th>
			</tr>


			<!-- 显示各个销售单的基本情况  详细情况在 详情 链接中查看 -->
			<c:forEach items="${sale}" var="s">
				<tr>

					<td><c:out value="${s.saleId }" /></td>
					<td><fmt:formatDate value="${s.saleTime }"/></td>
					<td><c:out value="${s.saleNum }" /></td>
					<!-- 显示VIP顾客的名字 -->
					<%-- <c:out value="${s.getVipId()}" /> --%>
					<td><c:forEach items="${vip}" var="tv">
							<c:if test="${tv.getVipId() == s.getVipId()}">
								<c:out value="${tv.getVipName()}" />
							</c:if>
						</c:forEach></td>
					<!-- 显示售货员的名字 -->
					<td><c:forEach items="${staff}" var="st">
							<c:if test="${st.getStaffId() == s.getStaffId()}">
								<c:out value="${st.getStaffName()}" />
							</c:if>
						</c:forEach></td>
					<td><a
						href="main/sale/edit?saleId=<c:out value="${s.saleId}" />">详情</a>
					</td>
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