<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript" src="../js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<base href="http://localhost:9999/SuperMarket/">
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
		$("#saledetailFrom").validate({
			rules : {
				number : {
					required : true,
					digits : true,
					min : 1
				}
			},
			messages : {
				number : {
					required : "请输入购买数量",
					digits : "必须为正整数",
					min : "商品不能少于0个"
				}
			}
		});
	});
</script>
</head>

<body>

	<form class="definewidth m40" name="myform" id="saledetailFrom"
		action="<c:choose><c:when test="${null==saledetail}">main/saledetail/add/handler</c:when><c:otherwise>main/saledetail/edit/handler</c:otherwise></c:choose>"
		method="post">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>编号</td>
				<td><c:if test="${null ==saledetail}">
			自动获取 
				</c:if> <c:if test="${null !=saledetail }">
						<input type="text" name="saleDetailId"
							value="${saledetail.saleDetailId }" />
					</c:if></td>
			</tr>
			<tr>
				<td>物品 （ 单价）</td>
				<td><select name="goodsId" id="gd">
						<c:forEach items="${goods}" var="g">
							<option value="<c:out value='${g.goodsId}'/>"
								<c:if test="${saledetail.goodsId == g.goodsId}"> selected="true" </c:if>>
								<c:out value='${g.goodsName}' /> (
								<c:out value='${g.goodsPrice}' />)
							</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="text" name="number" placeholder="数量不能少于1个"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${saledetail.number }'/>" /></td>
			</tr>

			<%-- 		 	<tr>
		  	<td>价格</td>
				<td><input type="text" name="price"
					value="<c:out value='${saledetail.price }' />" /></td>  
			</tr>  --%>


			<tr>
				<td>折扣</td>
				<td><select name="goodsDiscount">
						<option value="<c:out value='${1}' />">1</option>
						<option value="<c:out value='${2}' />">2</option>
						<option value="<c:out value='${3}' />">3</option>
						<option value="<c:out value='${4}' />">4</option>
						<option value="<c:out value='${5}' />">5</option>
						<option value="<c:out value='${6}' />">6</option>
						<option value="<c:out value='${7}' />">7</option>
						<option value="<c:out value='${8}' />">8</option>
						<option value="<c:out value='${9}' />">9</option>
						<option value="<c:out value='${10}' />" selected="selected">无</option>
				</select>折</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="保存" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>