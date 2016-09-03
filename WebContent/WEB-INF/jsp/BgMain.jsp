<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="templet/assets/css/dpl-min.css" rel="stylesheet"
	type="text/css" />
<link href="templet/assets/css/bui-min.css" rel="stylesheet"
	type="text/css" />
<link href="templet/assets/css/main-min.css" rel="stylesheet"
	type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="templet/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="templet/assets/js/bui-min.js"></script>
<script type="text/javascript"
	src="templet/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="templet/assets/js/config-min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<title>王牌实验室</title>
<base href="http://localhost:9999/SuperMarket/">
<script type="text/javascript">
<!--弹出dialog-->
	$(document).ready(function() {
		$('a[rel*=leanModal]').leanModal({
			top : 200,
		});
	});
	$().ready(function() {
		$("#changeform").validate({
			rules : {
				password : {
					required : true,
					minlength : 5
				},
				confirm_password : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				password : {
					required : "请输入密码",
					minlength : "密码不能少于{0}个字符"
				},
				confirm_password : {
					required : "请输入确认密码",
					equalTo : "两次输入的密码不一致"
				}
			}

		});
	});
</script>
</head>
<body>
	<div class="header">
		<div class="dl-title">
			<a href="main">王牌小组后台管理系统</a>
		</div>
		<div class="dl-log">
			欢迎您，<span><c:out value="${_user_login_status_ok_.staffName }"></c:out></span><a
				href="logout" title="退出系统" class="dl-log-quit">[安全退出]</a><a
				href="#OpenWindow" title="更改密码" class="dl-log-quit" rel="leanModal">[更改密码]</a>
		</div>
	</div>
	<div id="OpenWindow">
		<form action="changePassword" class="definewidth m20" id="changeform">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td colspan="3">修改密码</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="password" id="password" /></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input name="confirm_password" type="password"
						id="confirm_password" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="reset" value="重置"
						style="margin-left: 100px" /><input type="submit" value="保存"
						style="margin-left: 100px" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">系统管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-order">采购管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-cost">销售管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-storage">库存管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-user">VIP管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">审核</div></li>

			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>
	<script>
		BUI.use('main', function() {
			var config = [ {
				id : '1',
				homePage : '1',
				menu : [ {
					text : '系统管理',
					items : [ {
						id : '1',
						text : '权限管理',
						href : '/SuperMarket/main/limits'
					}, {
						id : '2',
						text : '角色管理',
						href : '/SuperMarket/main/roles'
					}, {
						id : '3',
						text : '员工管理',
						href : '/SuperMarket/main/staffs'
					}, {
						id : '4',
						text : '仓库管理',
						href : '/SuperMarket/main/stocks'
					} ]
				} ]
			}, {
				id : '2',
				homePage : '1',
				menu : [ {
					text : '采购管理',
					items : [ {
						id : '1',
						text : '添加商品',
						href : '/SuperMarket/main/makeGood'
					}, {
						id : '2',
						text : '填写采购单',
						href : '/SuperMarket/main/makeOrder'
					}, {
						id : '3',
						text : '采购单记录',
						href : '/SuperMarket/main/order'
					}, {
						id : '4',
						text : '采购入库',
						href : '/SuperMarket/main/checkInStock'
					}, {
						id : '5',
						text : '供应商管理',
						href : '/SuperMarket/main/suppliers'
					} ]
				} ]
			}, {
				id : '3',
				homePage : '1',
				menu : [ {
					text : '销售管理',
					items : [ {
						id : '1',
						text : '售货单',
						href : '/SuperMarket/main/saledetail'
					}, {
						id : '2',
						text : '销售记录',
						href : '/SuperMarket/main/sale'
					}, {
						id : '3',
						text : '添加报损',
						href : '/SuperMarket/main/makeBreakage'
					}, {
						id : '4',
						text : '报损记录',
						href : '/SuperMarket/main/breakages'
					} ]
				} ]
			}, {
				id : '4',
				homePage : '1',
				menu : [ {
					text : '库存管理',
					items : [ {
						id : '1',
						text : '库存查询',
						href : '/SuperMarket/main/gstock'
					}, {
						id : '2',
						text : '盘点',
						href : '/SuperMarket/main/checks'
					}, {
						id : '3',
						text : '报损记录',
						href : '/SuperMarket/main/breakages'
					}, {
						id : '4',
						text : '添加报损',
						href : '/SuperMarket/main/makeBreakage'
					} ]
				} ]
			}, {
				id : '5',
				homePage : '1',
				menu : [ {
					text : '客户管理',
					items : [ {
						id : '1',
						text : '客户管理',
						href : '/SuperMarket/main/vips'
					} ]
				} ]
			}, {
				id : '6',
				homePage : '1',
				menu : [ {
					text : '审核',
					items : [ {
						id : '1',
						text : '采购审核',
						href : '/SuperMarket/main/shenhe'
					}, {
						id : '2',
						text : '报损审核',
						href : '/SuperMarket/main/checkBreakage'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
	</script>
	<div style="text-align: center;">sdfaf</div>
</body>
</html>