<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	jQuery(function() {
		jQuery("#vipForm").validate({
			rules : {
				vipName : {
					required : true,
					minlength : 2,
					chcharacter : true
				},
				vipPassword : {
					required : true,
					minlength : 5
				},
				vipAddress : {
					required : true,
					chcharacter : true,
					maxlength : 11
				},
				vipIdentityCard : {
					required : true,
					digits : true,
					rangelength : [ 5, 10 ]
				},
				vipPhoneNumber : {
					required : true,
					digits : true,
					rangelength : [ 11, 11 ]
				},
				vipCreateTime2 : {
					required : true,
					dateISO : true,
				},
				vipVaildTime2 : {
					required : true,
					dateISO : true,
					compareDate : "#vipCreateTime2"
				}
			},
			messages : {
				vipName : {
					required : "请输入员工名",
					minlength : "员工名不能少于2个字符",
				},
				vipPassword : {
					required : "请输入密码",
					minlength : "密码不能少于5个字符"
				},
				vipIdentityCard : {
					required : "请输入鉴别卡",
					digits : "只能输入数字",
					rangelength : "鉴别卡必须在5~10位之间"
				},
				vipAddress : {
					required : "请输入地址",
					chcharacter : "只能输入汉字",
					maxlength : "地址小于11位"
				},
				vipPhoneNumber : {
					required : "请输入手机号",
					digits : "只能输入数字",
					rangelength : "手机号为11位"
				},
				vipCreateTime2 : {
					required : "日期必须填写",
					dateISO : "日期格式为xxxx-yy-dd"
				},
				vipVaildTime2 : {
					required : "日期必须填写",
					dateISO : "日期格式为xxxx-yy-dd"
				}
			}
		});
	});
</script>
</head>
<body>
	<form  id="vipForm" name="myform" method="post" class="definewidth m20"
		action="<c:choose><c:when test="${null==vip }">main/vips/add/handler</c:when><c:otherwise>main/vips/edit/handler</c:otherwise></c:choose>">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>会员ID：</td>
				<td><c:if test="${null==vip}">自动获取</c:if> <c:if
						test="${null!=vip }">
						<input type="text" name="vipId" value="${vip.vipId}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>会员姓名：</td>
				<td><c:if test="${null==vip}">
						<input type="text" name="vipName" placeholder="会员姓名为汉字且必须大于2位"
							onkeyup="this.value=this.value.replace(' ','')" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipName" value="${vip.vipName}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>会员密码：</td>
				<td><c:if test="${null==vip}">
						<input type="text" name="vipPassword" value="888888"
							readonly="readonly"
							onkeyup="this.value=this.value.replace(' ','')" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipPassword" value="${vip.vipPassword}"
							onkeyup="this.value=this.value.replace(' ','')" />
					</c:if></td>
			</tr>
			<tr>
				<td>会员地址：</td>
				<td><input type="text" name="vipAddress"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="地址为汉字必须小于11位"
					value="<c:out value='${vip.vipAddress}' />"></td>
			</tr>
			<tr>
				<td>电话号码：</td>
				<td><input type="text" name="vipPhoneNumber"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${vip.vipPhoneNumber}' />"
					placeholder="电话为数字必须为11位"></td>
			</tr>
			<tr>
				<td>消费总额：</td>
				<td><c:if test="${null==vip}">
						<input type="text" name="vipConTotal" value="0"
							readonly="readonly"
							onkeyup="this.value=this.value.replace(' ','')" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipConTotal" value="${vip.vipConTotal}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>会员等级：</td>
				<td><select name="vipLevel">
						<c:forEach items="${cDiscount}" var="c">
							<option value="<c:out value='${c.vipLevel}' />">
								<c:out value='${c.vipLevel}' />
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>鉴别卡：</td>
				<td><c:if test="${null==vip}">
						<input type="text" name="vipIdentityCard" value="0"
							placeholder="鉴别卡必须在5~10位之间"
							onkeyup="this.value=this.value.replace(' ','')" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipIdentityCard"
							value="${vip.vipIdentityCard}" readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><c:if test="${null==vip}">
						<input type="date" name="vipCreateTime2" id="vipCreateTime2" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipCreateTime2" id="vipCreateTime2"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${vip.vipCreateTime}" />"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>有效期截止：</td>
				<td><c:if test="${null==vip}">
						<input type="date" name="vipVaildTime2" id="vipVaildTime2" />
					</c:if> <c:if test="${null!=vip }">
						<input type="text" name="vipVaildTime2" id="vipVaildTime2"
							value="<fmt:formatDate pattern="yyyy-MM-dd" value="${vip.vipVaildTime}" />"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><input type="reset" value="重填"></td>
			</tr>
		</table>

	</form>
</body>
</html>