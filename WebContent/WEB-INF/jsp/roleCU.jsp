<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加/编辑角色页面</title>
<base href="http://localhost:9999/SuperMarket/">
<title></title>
<link rel="stylesheet" type="text/css" href="templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="templet/Css/style.css" />
<script type="text/javascript" src="templet/Js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validate.expand.js"></script>
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

</head>
<body>
	<script type="text/javascript">
		$().ready(function() {
			$("#rolesForm").validate({
				rules : {
					roleName : {
						required : true,
						minlength : 2,
						chcharacter : true
					}
				},
				messages : {
					roleName : {
						required : "请输入角色名",
						minlength : "角色名不能少于2个字符",
						chcharacter : "必须是汉字"
					}
				}
			});
		});
	</script>
	<form id="rolesForm" class="definewidth m20" name="myform"
		method="post" onsubmit="return toVaild()"
		action=" <c:choose>
	<c:when test="${null==role}">main/roles/add/handler</c:when>
	<c:otherwise>main/roles/edit/handler</c:otherwise>
	</c:choose>">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td class="tableleft">角色ID</td>
				<td class="tableleft"><c:if test="${null==role}">自动获取</c:if> <c:if
						test="${null!=role }">
						<input type="text" name="roleId" value="${role.roleId}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td class="tableleft">角色名称</td>
				<td class="tableleft"><input type="text" name="roleName"
					id="RolesName" value="<c:out value='${role.roleName}'/>"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="输入大于两个汉字" /></td>
			</tr>
			<tr>
				<td class="tableleft" colspan="2"><input type="reset"
					value="重置" /> <input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>