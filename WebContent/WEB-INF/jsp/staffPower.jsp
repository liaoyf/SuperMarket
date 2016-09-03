<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form  class="definewidth m20" >
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td  colspan="2">当前员工：<c:out value='${staff.staffName}' />
				</td>
			</tr>
			<tr>
				<td  >权限</td>
				<td >权限描述</td>
			</tr>
			<c:forEach items="${limit}" var="l">
				<tr>

					<td ><input type="checkbox"
						value="<c:out value='${l.lPId}' /> " name="${l.lPName}"
						<c:forEach items="${lPRole}" var="p">
					
					<c:if test="${p.lpId==l.lPId}">
					checked="checked"
					</c:if>
					</c:forEach> />
						<c:out value='${l.lPName}' /></td>
					<td><c:out value="${l.lPDescription}"></c:out></td>
				</tr>
			</c:forEach>
		</table>

	</form>
</body>
</html>