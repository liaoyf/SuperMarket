<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>
<script type="text/javascript">
function del(){
	var msg="確定刪除嗎？";
	if(confirm(msg)==true)
		return true;
	else
		return false;
}

function page(num){
	document.fm.pageNum.value = num;
	document.fm.submit();
}
</script>
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
<form name="fm" method="post" action="suppliers">
<table class="table table-bordered table-hover definewidth m10">
<tr>
				<td><label>供应商姓名</label></td>
				 <td colspan="2"><input type="hidden" name="pageNum" /><input type="text" name="supplierName"  value="${supplierName}" /></td>
				<td><label>供应商编号</label></td>
				<td colspan="2"><input type="text" name="supplierId" value="${supplierId}"/></td>

				<td><input type="submit" value="查询"/></td>
			</tr>
<tr>
<th>供应商ID</th>
<th>姓名</th>
<th>地址</th>
<th>电话</th>
<th colspan="3">操作</th>
</tr>
<c:forEach items="${suppliers}" var="s">
<tr>
<td><c:out value="${s.supplierId}"/></td>
<td><c:out value="${s.supplierName}"/></td>
<td><c:out value="${s.supplierAddress}"/></td>
<td><c:out value="${s.supplierPhone}"/></td>
<td colspan="3"><a href="suppliers/edit?supplierId=<c:out value="${s.supplierId }"></c:out>">修改</a>| <a
						href="suppliers/del?supplierId=<c:out value="${s.supplierId }"></c:out>"
						onclick="javascript:return del()"
						>删除</a>
						</td>
</tr>
</c:forEach>
<tr>
<td colspan="7"><a href="suppliers/add">添加供应商</a></td>
</tr>
</table>
<div class="page">
 <a
			href="javascript:;" onclick="page(1)">第一页</a> | <a
			href="javascript:;" onclick="page(${page.pageNum - 1 })">上一页</a>
		| 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a href="javascript:;" onclick="page(${page.pageNum + 1 })">下一页</a>
		| <a href="javascript:;" onclick="page(${page.totalPage})">最后一页</a>
		|
	</div>
</form>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>