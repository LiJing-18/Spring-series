<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>登录</title>
<link href="<%=basePath%>admin/ui/assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
html {
	height: 100%;
}

.view-login {
	padding-top: 0;
	background-color: #142849;
	background-image: -webkit-radial-gradient(circle, #165387, #142849);
	background-image: -moz-radial-gradient(circle, #165387, #142849);
	background-image: -o-radial-gradient(circle, #165387, #142849);
	background-repeat: no-repeat;
}

.view-login .container {
	width: 300px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: 106px;
	margin-left: -150px;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0px auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 20px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="<%=basePath%>admin/ui/assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/docs.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/base.css" rel="stylesheet">
<link rel="shortcut icon" href="<%=basePath%>admin/ui/assets/ico/favicon.ico" />
</head>
<body data-spy="scroll" data-target=".bs-docs-sidebar" class="view-login">
	<div class="container">
		<form class="form-signin" action="bk/user/adminlogin.action" method="post">
			<h2 class="form-signin-heading" style="text-align: center;">后台管理系统</h2>
			<div class="messages">
				<div style="display: none;" id="message-error" class="message message-error">
					<div class="image">
						<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-alert.png" alt="Error" height="32" /> 
						<span>您输入的用户名或者密码错误</span>
					</div>
				</div>
			</div>
			<hr/>
			<input id="userName" name="userName" type="text" class="input-block-level" placeholder="Username"> 
			<input id="password" name="password" type="password" class="input-block-level" placeholder="Password"> 
			<span><input type="checkbox" value="remember-me">记住我 </span>
			<br/><br/>
			<button class="btn btn-large btn-primary" type="submit">
				<i class="icon-user icon-white"></i> 安全登录
			</button>
		</form>
	</div>
	<div class="navbar navbar-fixed-bottom">
		<div class="navbar-inner navbar-innerb">
			<div class="pull-right fixed-bottom-cp">Copyright &copy; aone 2018</div>
			<div class="viewsite fixed-bottom-div">
				<a href="http://www.localjoomla3.com/" target="_blank">
				<i class="icon-share-alt"></i> 浏览网站</a>
			</div>
			<div class="loggedin-users fixed-bottom-div">
				<span class="badge">0</span> 访客在线
			</div>
			<div class="backloggedin-users fixed-bottom-div">
				<span class="badge">1</span> 管理在线
			</div>
		</div>
	</div>
	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>admin/ui/assets/js/jquery.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-transition.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-alert.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-modal.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-dropdown.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-scrollspy.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tab.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tooltip.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-popover.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-button.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-collapse.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-carousel.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-typeahead.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/jquery.query.js"></script>
	<script type="text/javascript">
	$(function() {
		//读取登录返回状态并显示提示
		var msg = $.query.get("msg");
		if ("1" == msg) {
			$("#message-error").show();
		} else {
			$("#message-error").hide();
		}
	});
	</script>
</body>
</html>