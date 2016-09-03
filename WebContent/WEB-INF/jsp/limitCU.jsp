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
<script src="js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/validate.expand.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="templet/Js/bootstrap.js"></script>
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
<script type="text/javascript">
	$().ready(function() {
		$("#limitsForm").validate({
			rules : {
				lPName : {
					required : true,
					minlength : 2,
					chcharacter : true
				},
				lPDescription : {
					required : true,
					minlength : 5,
					chcharacter : true
				}
			},
			messages : {
				lPName : {
					required : "请输入权限名",
					minlength : "权限名不能少于2个汉字",
					chcharacter : "只能输入汉字"
				},
				lPDescription : {
					required : "请输入权限描述",
					minlength : "权限描述不能少于5个汉字",
					chcharacter : "只能输入汉字"
				}
			}
		});
	});
</script>
<body>
	<form id="limitsForm" class="definewidth m20" name="myform"
		method="post"
		action=" <c:choose>
	<c:when test="${null==limit}">main/limits/add/handler</c:when>
	<c:otherwise>main/limits/edit/handler</c:otherwise>
	</c:choose>">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td>权限ID</td>
				<td><c:if test="${null==limit}">自动获取</c:if> <c:if
						test="${null!=limit }">
						<input type="text" name="lPId" value="${limit.lPId}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>权限名称</td>
				<td><input id="limitsName" type="text" name=lPName
					class="inputxt" placeholder="只能输入两个以上的汉字"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${limit.lPName}'/>" /></td>
			</tr>
			<tr>
				<td>权限描述</td>
				<td><input id="limitsDescription" type="text"
					name="lPDescription" class="inputxt" placeholder="只能输入五个以上的汉字"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${limit.lPDescription}'/>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="重置" /> <input
					type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>