<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title></title>
<title></title>
<link rel="stylesheet" type="text/css" href="../templet/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../templet/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../templet/Css/style.css" />
<script type="text/javascript" src="../templet/Js/jquery.js"></script>
<script type="text/javascript" src="../templet/Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../templet/Js/bootstrap.js"></script>
<script type="text/javascript" src="../templet/Js/ckform.js"></script>
<script type="text/javascript" src="../templet/Js/common.js"></script>
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
function del(){
	var msg="確定刪除嗎？";
	if(confirm(msg)==true)
		return true;
	else
		return false;
}
function page(num){
	document.fm.pageNum.value = num;
	document.fm.submit();
}
</script>
</head>
<body>
	<form class="definewidth m40" name="fm" method="post" action="staffs">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>

				<td><label>员工姓名</label></td>
				 <td colspan="2"><input type="hidden" name="pageNum" />
				 <input type="text" name="staffName"  value="${staffName}" /></td>
				<td><label>员工编号</label></td>
				<td colspan="2"><input type="text" name="staffId" value="${staffId}"/></td>

				<td  colspan="2" class="tableleft"><input  type="submit" value="查询" /></td>
			</tr>
			<tr>
				<td class="tableleft">员工ID</td>
				<td class="tableleft">员工姓名</td>
				<td class="tableleft">身份证</td>
				<td class="tableleft">性别</td>
				<td class="tableleft">年龄</td>
				<td class="tableleft">电话号码</td>
				<td class="tableleft">职位</td>
				<td class="tableleft">操作</td>
			</tr>
			<c:forEach items="${staffs}" var="s">
				<tr>
					<td class="tableleft" ><c:out value="${s.staffId}" /></td>
					<td class="tableleft" ><c:out value="${s.staffName}" /></td>
					<td class="tableleft" ><c:out value="${s.staffIdentityCard}" /></td>
					<td class="tableleft" ><c:out value="${s.sex}" /></td>
					<td class="tableleft" ><c:out value="${s.age}" /></td>
					<td class="tableleft" ><c:out value="${s.phoneNumber}" /></td>
					<td class="tableleft" ><c:out value="${s.getRole().getRoleName()}" /></td>
					<td class="tableleft" ><a
						href="staffs/edit?staffId=<c:out value="${s.staffId }"></c:out>">修改</a>|
						<a href="staffs/del?staffId=<c:out value="${s.staffId }"></c:out>"
						onclick="javascript:return del()">删除</a>|
						<a href="stafflimit?staffId=<c:out value="${s.staffId }"></c:out>">权限</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td  colspan="8" class="tableleft" ><a href="staffs/add">添加员工</a></td>
			</tr>
		</table>
	</form>
<div class="page">
 <a
			href="javascript:;" onclick="page(1)">第一页</a> | <a
			href="javascript:;" onclick="page(${page.pageNum - 1 })">上一页</a>
		| 总
		<c:out value="${page.totalPage }" />
		页 | 当前显示第
		<c:out value="${page.pageNum}" />
		页| <a href="javascript:;" onclick="page(${page.pageNum + 1 })">下一页</a>
		| <a href="javascript:;" onclick="page(${page.totalPage})">最后一页</a>
		|
	</div>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>