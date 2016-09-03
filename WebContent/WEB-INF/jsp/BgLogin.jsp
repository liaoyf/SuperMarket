<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="http://localhost:9999/SuperMarket/">
<title>王牌实验室</title>
<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="css/default.css" rel="stylesheet" type="text/css"
	id="style_color" />
<link href="css/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="js/jquery.uniform.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/login.js" type="text/javascript"></script>
</head>
<body class="login">
	<div class="logo"></div>
	<div class="content">

		<!-- BEGIN LOGIN FORM -->

		<form class="form-vertical login-form" action="login" method="post">

			<h3 class="form-title">登录员工账户</h3>
			<div class="control-group">

				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

				<label class="control-label visible-ie8 visible-ie9">账户</label>

				<div class="controls">

					<div class="input-icon left">

						<i class="icon-user"></i> <input class="m-wrap placeholder-no-fix"
							type="text" placeholder="账户名" name="staffName" />

					</div>

				</div>

			</div>

			<div class="control-group">

				<label class="control-label visible-ie8 visible-ie9">密码</label>

				<div class="controls">

					<div class="input-icon left">

						<i class="icon-lock"></i> <input class="m-wrap placeholder-no-fix"
							type="password" placeholder="密码" name="password" />

					</div>

				</div>

			</div>

			<div class="form-actions">
				<button type="reset" class="btn blue pull-left">

					重置 <i class="m-icon-swapright m-icon-white"></i>

				</button>
				<button type="submit" class="btn green pull-right">

					登录 <i class="m-icon-swapright m-icon-white"></i>

				</button>

			</div>
		</form>
		<!-- END LOGIN FORM -->
		<div class="copyright">2015 &copy;王牌小组制</div>
		<script>
			jQuery(document).ready(function() {
				Login.init();
			});
		</script>
	</div>
</body>
</html>
<c:if test="${null != msg }">
	<script>
		alert('<c:out value="${msg}" />');
	</script>
</c:if>