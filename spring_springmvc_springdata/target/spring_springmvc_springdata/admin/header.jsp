<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pathb = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathb + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>首页 &middot; aone</title>
<!-- Le styles -->
<link href="<%=basePath%>admin/ui/assets/css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/docs.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
<link href="<%=basePath%>admin/ui/assets/css/base.css" rel="stylesheet">
<link href="<%=basePath%>admin/js/plugins/icheckmaster/skins/square/blue.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../../autocomplete/jquery.autocomplete.css">
<!-- import flexigrid css -->
<link href="<%=basePath%>admin/js/plugins/flexigrid/css/flexigrid/flexigrid_blue.css" rel="stylesheet" type="text/css">
<!-- import uploader css -->
<link href="<%=basePath%>admin/js/plugins/uploader/fileuploader.css" rel="stylesheet">
<!-- import  farbtastic css-->
<link href="<%=basePath%>admin/js/plugins/farbtastic/farbtastic.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="shortcut icon" href="<%=basePath%>admin/ui/assets/ico/favicon.ico">
</head>
<body>
	<!-- Navbar================================================== -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse"> 
					<span class="icon-bar"></span>
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</a>
				<div class="nav-collapse collapse navbar-inverse-collapse">
					<ul class="nav" >
						<li class="active">
						<a tabindex="-1" href="<%=basePath%>admin/index.jsp">主页</a>
						</li>
					</ul>
					<ul class="nav pull-right">
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">信息管理
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="<%=basePath%>admin/jsp/member/memberinfoment.jsp?operate=find">信息</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">订单管理
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">订单</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">工具
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">设置</a></li>
								<li class="divider"></li>
								<li><a href="#">设置</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">用户管理<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%=basePath%>admin/jsp/member/memberinfoment.jsp?operate=find">用户</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">其它 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">综合数据设置</a></li>
								<li class="divider"></li>
								<li><a href="<%=basePath%>admin/jsp/share/shareInfoMent.jsp?operate=find">分享设置</a></li>
								<li class="divider"></li>
								<li><a href="<%=basePath%>admin/jsp/aone/aoneMemberInfoment.jsp?operate=find">水军设置</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=basePath%>admin/ui/assets/js/jquery.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/google-code-prettify/prettify.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-transition.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-alert.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-modal.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-scrollspy.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tab.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-tooltip.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-popover.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-button.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-collapse.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-carousel.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-typeahead.js"></script>
	<script src="<%=basePath%>admin/ui/assets/js/bootstrap-dropdown.js"></script>
	<script src="<%=basePath%>admin/js/plugins/icheckmaster/jquery.icheck.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/plugins/flexigrid/myflexigrid.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/common/jquery.query.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/plugins/validatorjs/validator.js"></script>	
	<script type="text/javascript" src="<%=basePath%>admin/js/common/indexjs.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/common/base.js"></script>
	<script type="text/javascript" src="../../autocomplete/jquery.autocomplete.js"></script>
</body>
</html>
