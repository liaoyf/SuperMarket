<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<base href="http://localhost:9999/SuperMarket/">
<link rel="stylesheet" type="text/css" href="templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="templet/Css/style.css" />
<script type="text/javascript" src="templet/Js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/validate.expand.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="templet/Js/ckform.js"></script>
<script type="text/javascript" src="templet/Js/common.js"></script>
</head>

<script type="text/javascript">
	$().ready(function() {
		$("#supplierFrom").validate({
			rules : {
				supplierName : {
					required : true,
					minlength : 2,
					chcharacter : true
				},
				supplierAddress : {
					required : true,
					maxlength : 11,
					chcharacter : true
				},
				supplierPhone : {
					required : true,
					digits : true,
					rangelength : [ 11, 11 ]
				}
			},
			messages : {
				supplierName : {
					required : "请输入供应商名",
					minlength : "供应商名不能少于2个汉字",
					chcharacter : "只能输入汉字"
				},
				supplierAddress : {
					required : "请输入地址",
					chcharacter : "只能输入汉字",
					maxlength : "地址小于11位"
				},
				supplierPhone : {
					required : "请输入手机号",
					digits : "只能输入数字",
					rangelength : "手机号为11位"
				}
			}
		});
	});
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
<body>
	<form name="myform" method="post" id="supplierFrom"
		class="definewidth m20"
		action=" <c:choose>
	<c:when test="${null==supplier}">main/suppliers/add/handler</c:when>
	<c:otherwise>main/suppliers/edit/handler</c:otherwise>
	</c:choose>">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>供应商编号</td>
				<td><c:if test="${null==supplier}">自动获取</c:if> <c:if
						test="${null!=supplier }">
						<input type="text" name="supplierId"
							value="${supplier.supplierId}" readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="supplierName"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="供应商姓名为汉字且必须大于2位"
					value="<c:out value='${supplier.supplierName}'/>" /></td>
			</tr>

			<tr>
				<td>地址</td>
				<td><input type="text" name="supplierAddress"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="地址为汉字必须小于11位"
					value="<c:out value='${supplier.supplierAddress}'/>" /></td>
			</tr>

			<tr>
				<td>电话号码</td>
				<td><input type="text" name="supplierPhone"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="电话为数字必须为11位"
					value="<c:out value='${supplier.supplierPhone}'/>" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="reset" value="重置"
					style="margin-left: 180px" /> <input type="submit" value="保存"
					style="margin-left: 8px" /></td>
			</tr>
		</table>
	</form>
</body>
</html>