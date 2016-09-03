<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/ckform.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>
<title></title>
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
function del(){
	var msg="確定刪除嗎？";
	if(confirm(msg)==true)
		return true;
	else
		return false;
}
</script>
</head>
<body>
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<th class="tableleft" >角色Id</th>
			<th class="tableleft" >角色名称</th>
			<th class="tableleft" >权限</th>
			<th class="tableleft" >操作</th>
		</tr>
		<c:forEach items="${role}" var="r">
			<tr>
				<td class="tableleft" ><c:out value="${r.roleId}" /></td>
				<td class="tableleft"><c:out value="${r.roleName}" /></td>
				<td class="tableleft"><a
					href="roles/limits?roleId=<c:out value="${r.roleId}"></c:out>">权限设置</a>
				</td>
				<td class="tableleft"><a
					href="roles/edit?roleId=<c:out value="${r.roleId}"></c:out>">修改</a>|
					<a href="roles/del?roleId=<c:out value="${r.roleId}"></c:out>"
					onclick="javascript:return del()"
					>删除</a>
				</td>
			</tr>
		</c:forEach>

		<tr>
			<td  colspan="4" class="tableleft"><a href="roles/add">添加角色</a></td>
		</tr>
	</table>
	<div class="page">
 <a
			href="roles?pageNum=1">第一页</a> | <a
			href="roles?pageNum=<c:out value="${page.pageNum - 1 }" />">上一页</a>
		| 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a href="roles?pageNum=<c:out value="${page.pageNum + 1 }" />">下一页</a>
		| <a href="roles?pageNum=<c:out value="${page.totalPage }" />">最后一页</a>
		|
	</div>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>