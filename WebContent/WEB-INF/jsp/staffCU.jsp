<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="http://localhost:9999/SuperMarket/">
<title>员工添加/编辑页面</title>
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
<script type="text/javascript" src="templet/Js/common.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	$().ready(function() {
		$("#staffForm").validate({
			rules : {
				staffName : {
					required : true,
					minlength : 2,
					chcharacter : true
				},
				password : {
					required : true,
					minlength : 5
				},
				staffIdentityCard : {
					required : true,
					digits : true,
					rangelength : [ 5, 10 ]
				},
				age : {
					required : true,
					digits : true,
					range : [ 20, 50 ]
				},
				phoneNumber : {
					required : true,
					digits : true,
					rangelength : [ 11, 11 ]
				}
			},
			messages : {
				staffName : {
					required : "请输入员工名",
					minlength : "员工名不能少于2个字符",
				},
				password : {
					required : "请输入密码",
					minlength : "密码不能少于5个字符"
				},
				staffIdentityCard : {
					required : "请输入身份证",
					digits : "只能输入数字",
					rangelength : "身份证必须在5~10位之间"
				},
				age : {
					required : "请输入年龄",
					digits : "只能输入数字",
					range : "年龄必须在20~50岁之间"
				},
				phoneNumber : {
					required : "请输入手机号",
					digits : "只能输入数字",
					rangelength : "手机号为11位"
				}
			}
		});
	});
</script>

</head>
<body>
	<form id="staffForm" class="definewidth m20" name="myform"
		method="post"
		action=" <c:choose>
	<c:when test="${null==staff}">main/staffs/add/handler</c:when>
	<c:otherwise>main/staffs/edit/handler</c:otherwise>
	</c:choose>">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td>员工编号</td>
				<td><c:if test="${null==staff}">自动获取</c:if> <c:if
						test="${null!=staff }">
						<input type="text" name="staffId" value="${staff.staffId}"
							readonly="readonly" />
					</c:if></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="staffName"
					value="<c:out value='${staff.staffName}'/>"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="姓名不能少于两个汉字" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" placeholder="密码必须大于5位"
					onkeyup="this.value=this.value.replace(' ','')"
					<c:choose><c:when test="${null==staff}">value="888888" readonly="readonly"</c:when><c:otherwise>value="<c:out value='${staff.password}' />"</c:otherwise>
	</c:choose> />
				</td>
			</tr>
			<tr>
				<td>身份证</td>
				<td><input type="text" name="staffIdentityCard"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="身份证只能输入数字且位数为5~10位"
					value="<c:out value='${staff.staffIdentityCard}'/>" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>男<input type="radio" id="nan" name="sex" value="男"
					<c:if test="${staff==null||staff.sex=='男'}">
					checked="checked"
					</c:if> />
					女<input type="radio" id="nv" name="sex" value="女"
					<c:if test="${ staff.sex=='女'}">
					checked="checked"
					</c:if> />

					<%--  <input type="text"
					name="sex"
					value="<c:out value='${staff.sex}' /> " /> --%>
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"
					onkeyup="this.value=this.value.replace(' ','')"
					placeholder="年龄必须在20~50岁" value="<c:out value='${staff.age}'/>" /></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input type="text" name="phoneNumber"
					placeholder="手机号为数字且为11位"
					onkeyup="this.value=this.value.replace(' ','')"
					value="<c:out value='${staff.phoneNumber}'/>" /></td>
			</tr>
			<tr>
				<td>职位</td>
				<td><select name="roleId">
						<c:forEach items="${role}" var="r">
							<option value="<c:out value='${r.roleId}'/>"
								<c:if test="${staff.roleId==r.roleId}">selected="true"</c:if>>
								<c:out value='${r.roleName}' />
							</option>
						</c:forEach>
				</select></td>
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