<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加/编辑仓库页面</title>
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
<script type="text/javascript">
	$().ready(function() {
		$("#stockForm").validate({
			rules : {
				stockName : {
					required : true,
					minlength : 4,
					chcharacter : true
				},
				stockVolume : {
					required : true,
					digits : true,
					min : 0
				}
			},
			messages : {
				roleName : {
					required : "请输入仓库名",
					minlength : "仓库名不能少于2个汉字",
					chcharacter : "必须为汉字"
				},
				stockVolume : {
					required : "请输入仓库容量",
					digits : "必须为数字",
					min : "仓库容量不能少于0"
				}
			}
		});
	});
</script>
</head>
<body>
	<form class="definewidth m20" name="myform" method="post"
		action=" <c:choose>
	<c:when test="${null==stock}">main/stocks/add/handler</c:when>
	<c:otherwise>main/stocks/edit/handler</c:otherwise>
	</c:choose>">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td class="tableleft">仓库ID</td>
				<td class="tableleft"><c:if test="${null==stock}">自动获取</c:if> <c:if
						test="${null!=stock }">
						<input type="text" name="stockId" value="${stock.stockId}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td class="tableleft">仓库名称</td>
				<td class="tableleft"><input type="text" name="stockName"
					placeholder="仓库名不能少于2个汉字"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${stock.stockName}'/>" /></td>
			</tr>
			<tr>
				<td class="tableleft">仓库容量</td>
				<td class="tableleft"><input type="text" name="stockVolume"
					placeholder="容量为正整数"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${stock.stockVolume}' />" /></td>
			</tr>
			<tr>
				<td class="tableleft" colspan="2"><input type="reset"
					value="重置" /> <input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>