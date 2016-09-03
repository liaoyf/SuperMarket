<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title></title>
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/ckform.js"></script>
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

<body>
	<form name="fm" method="post" action="main/vips">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td><label>会员姓名</label></td>
				<td colspan="2"><input type="hidden" name="pageNum" /><input
					type="text" name="vipName" value="${vipName}" /></td>
				<td><label>会员编号</label></td>
				<td colspan="2"><input type="text" name="vipId"
					value="${vipId}" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
			<tr>
				<th>会员ID</th>
				<th>会员姓名</th>
				<th>会员密码</th>
				<th>会员地址</th>
				<th>电话号码</th>
				<th>消费总额</th>
				<th>会员等级</th>
				<th>鉴别卡</th>
				<th>创建时间</th>
				<th>有效期截止</th>
				<th>操作</th>

			</tr>
			<c:forEach items="${vips}" var="v">
				<tr>
					<td><c:out value="${v.vipId}" /></td>
					<td><c:out value="${v.vipName}" /></td>
					<td><c:out value="${v.vipPassword}" /></td>
					<td><c:out value="${v.vipAddress}" /></td>
					<td><c:out value="${v.vipPhoneNumber}" /></td>
					<td><c:out value="${v.vipConTotal}" /></td>
					<td><c:out value="${v.vipLevel}" /></td>
					<td><c:out value="${v.vipIdentityCard}" /></td>

					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${v.vipCreateTime}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${v.vipVaildTime}" /></td>

					<td><a
						href="main/vips/edit?vipId=<c:out value="${v.vipId}"></c:out>">修改</a>|
						<a href="main/vips/del?vipId=<c:out value="${v.vipId }"></c:out>"
						onclick="javascript:return del()">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="11"><a href="main/vips/add">新增会员</a></td>
			</tr>
		</table>
		<div class="page">
			<a href="javascript:;" onclick="page(1)">第一页</a> | <a
				href="javascript:;" onclick="page(${page.pageNum - 1 })">上一页</a> | 总
			<c:out value="${page.totalPage }" />
			页 | 当前显示第
			<c:out value="${page.pageNum}" />
			页| <a href="javascript:;" onclick="page(${page.pageNum + 1 })">下一页</a>
			| <a href="javascript:;" onclick="page(${page.totalPage})">最后一页</a> |
		</div>
	</form>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>