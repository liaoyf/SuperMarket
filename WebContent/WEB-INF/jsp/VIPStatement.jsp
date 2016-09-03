<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>王牌实验室</title>
<style type="text/css">

html,body{
}

#detailShow:hover{
	background-color:rgb(181, 38, 38);
	cursor:pointer;
}

.tab-content{
	padding:0px;
	overflow:scroll;
	
}


p{
	margin:auto;
	text-align:center;
    background-color: rgb(45, 72, 131);
	font-size:25px;
	line-height:25px;
	padding:10px 0;
}

p span{
    padding: 10px;
    color: #fff;
}

.tab-content li{
	line-height:40px;
	text-align:center;
	background:#fff;
	border:1px solid #d5d5d5;
}

li span{
	color:#000;
	font-size:25px;
	padding:10px 0;
}

a {
	color: #fff;
}

.nav-list .dl-selected .nav-item-inner{
	background-color:#fff;
}

.dl-selected a {
	color: #0d638f;
}

a,a:focus,a:hover,a:active {
	outline: 0;
	text-decoration: none;
}

.tab_area {
	width:100%;
	height:600px;
}
</style>
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
				pwd1 : {
					required : true,
					minlength : 5
				},
				pwd2 : {
					required : true,
					minlength : 5,
					equalTo : "#pwd1"
				}
			},
			messages : {
				pwd1 : {
					required : "请输入密码",
					minlength : "密码不能少于{0}个字符"
				},
				pwd2 : {
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
			<span>VIP管理系统</span>
		</div>
		<div class="dl-log">
			欢迎您，<span><c:out value="${vipInfo.vipName }"></c:out></span><a
				href="vip/logout" title="退出系统" class="dl-log-quit">[安全退出]</a><a
				href="#OpenWindow" title="更改密码" class="dl-log-quit" rel="leanModal">[更改密码]</a>
		</div>
	</div>
	<div id="OpenWindow">
		<form action="VIPChangePWD" class="definewidth m20" id="changeform">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td colspan="3">修改密码</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input id="pwd1" type="password" value="" name="pwd1"
						class="inputxt" datatype="*6-16" nullmsg="请设置密码！"
						errormsg="密码范围在6~16位之间！" /></td>
					<td><div class="Validform_checktip"></div></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input id="pwd2" type="password" value="" name="pwd2"
						class="inputxt" datatype="*" recheck="userpassword"
						nullmsg="请再输入一次密码！" errormsg="两次输入的密码不一致！" /></td>
					<td><div class="Validform_checktip"></div></td>
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
						class="nav-item-inner nav-cost">
						<a name="tab" href="#1" class="tab-active"
							onclick="tabSwitch(this,'tab-content-',0)">消费详情</a>
					</div></li>
				<li class="nav-item"><div class="nav-item-inner nav-user">
						<a name="tab" href="#2" onclick="tabSwitch(this,'tab-content-',1)">用户详情</a>
					</div></li>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>
	<div class="tab_area">

		<div id="tab-content-0" class="tab-content">
			<p><span>当前消费的详情</span></p>
			
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th>编号</th>
					<th>消费总额</th>
					<th>消费时间</th>
				</tr>

				<c:forEach items="${sale}" var="s" varStatus="sStatus">
					<tr>
						<td>${sStatus.index}</td>
						<td>${s.saleNum }</td>
						<td><fmt:formatDate value="${s.saleTime }"/></td>
						<td><button myvalue="${s.saleId }" class="checkDetail"
								value="查看明细" type="button" >查看明细</button></td>
					</tr>
				</c:forEach>
			</table>
		
			<div id="detail" class="dialog">
				
				<%-- <tr>
				<td>编号</td>
				<td>商品编号</td>
				<td>商品数量</td>
				<td>商品单价</td>
				<td>折扣</td>
			</tr>
			<c:forEach items="${saleDetail }" var="sd" varStatus="sdStatus">
				<tr>
					<td>${sdStatus.index }</td>
					<td>${sd.goodId }</td>
					<td>${sd.number }</td>
					<td>${sd.price }</td>
					<td>${sd.goodsDiscount }</td>
				</tr>
			</c:forEach> --%>
				
			</div>
		</div>
		<div id="tab-content-1" class="tab-content">
			<div>
				<p><span>尊敬的用户！您的当前信息为:</span></p>
				<ul>
					<li><span>等级:${vipInfo.vipLevel }</span></li>
					<li><span>ID卡:${vipInfo.vipIdentityCard }</span></li>
					<li><span>地址:${vipInfo.vipAddress }</span></li>
					<li><span>电话:${vipInfo.vipPhoneNumber }</span></li>
					<li><span>当前消费总额:${vipInfo.vipConTotal }</span></li>
				</ul>
			<%-- 	<p><span>当前享有的折扣:</span></p>
				<ul>
					<li><span>最低积分:${vipLevelInfo.creditsStartIntegral
						}</span></li>
					<li><span>最高积分:${vipLevelInfo.creditsEndIntegral }</span></li>
					<li><span>优惠:${vipLevelInfo.discount }</span></li>

				</ul> --%>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		document.getElementsByName("tab")[0].click();

		function tabSwitch(_this, content_prefix, active) {
			var tabs = document.getElementsByName(_this.name);

			var number = tabs.length;
			for ( var i = 0; i < number; i++) {
				var tab = tabs[i];
				tab.className = "";
				tab.parentNode.parentNode.className = "nav-item";
				document.getElementById(content_prefix + i).style.display = 'none';
			}
			_this.className = "tab-active";
			_this.parentNode.parentNode.className = "nav-item dl-selected";
			document.getElementById(content_prefix + active).style.display = 'block';
		}
		$(".checkDetail").click(function() {
			var saleId = $(this).attr("myvalue");
			$.post("/SuperMarket/VIPSaleDetail", {
				saleId : saleId
			}, function(data) {
				$('#detail').empty().append(data);
			}, 'html');

		});
	</script>
	<!-- <div style="text-align: center;">sdfaf</div> -->
</body>
</html>