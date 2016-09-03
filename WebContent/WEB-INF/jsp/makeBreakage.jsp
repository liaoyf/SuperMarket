<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="http://localhost:9999/SuperMarket/">
<link rel="stylesheet" type="text/css"
	href="templet/Css/bootstrap.css" />
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
			$("#makeBreakageFrom").validate({
				rules : {
					num : {
						required : true,
						min : 1,
						digits : true
					}
				},
				messages : {
					num : {
						required : "请输入报损数量",
						min : "数量不能少于1个",
						digits : "必须是正整数"
					}
				}
			});
		});
	</script>
<body>
	<form action="main/makeBreakage/add" method="post" id="makeBreakageFrom">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>货物名称</td>
				<td><select name="goodsId">
						<c:forEach items="${goods }" var="g">
							<option value="${g.goodsId }">${g.goodsName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>货物数量(INT)</td>
				<td><input name="num" type="text" /></td>
			</tr>
			<tr>
				<td>存放仓库</td>
				<td><select name="stockId">
						<c:forEach items="${stocks }" var="s">
							<option value="${s.stockId }">${s.stockName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>报损原因</td>
				<td><textarea name="reason" rows="4" cols="20"></textarea></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="提交" /></td></tr>
		</table>
	</form>
</body>
</html>
<c:if test="${null!=msg }">
	<script type="text/javascript">
		alert('<c:out value="${msg}" />');
	</script>
</c:if>