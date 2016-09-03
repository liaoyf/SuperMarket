<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="http://localhost:9999/SuperMarket/">
<title></title>
<link rel="stylesheet" type="text/css" href="templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="templet/Css/style.css" />
<script type="text/javascript" src="templet/Js/jquery.js"></script>
<script type="text/javascript" src="templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="templet/Js/ckform.js"></script>
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
<body>
	<form class="definewidth m40" name="myform" method="post"
		action="main/roles/limits/edit">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td  colspan="<c:out value='${count}' />" class=tableleft>当前角色：<c:out value='${role.roleName}' />
					<input type="hidden" name="roleId" value="${role.roleId}" />
				</td>
			</tr>

			<tr>
				<td class="tableleft">权限</td>
				<c:forEach items="${limit}" var="l">
					<td class="tableleft"><input type="checkbox"
						value="<c:out value='${l.lPId}' /> " name="lpr"
						<c:forEach items="${lPRole}" var="p">
					
					<c:if test="${p.lpId==l.lPId}">
					checked="checked"
					</c:if>
					</c:forEach> />
						<c:out value='${l.lPName}' /></td>
				</c:forEach>
			</tr>
			<tr>
				<td  colspan="<c:out value='${count}'/>" class="tableleft"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
