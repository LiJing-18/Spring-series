<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>首页</title>
</head>
<body>
	<!-- header 包含头部导航-->
	<%@include file="header.jsp"%>
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#">
				<img src="<%=basePath%>admin/ui/assets/img/logo.png" width="175" height="30" alt=""> 
			</a> 
			<a class="brand" href="#">欢迎登录后台管理系统</a>
		</div>
	</div>
	<div class="container-fluid containerb">
		<div class="row-fluid">
			<div class="span2">
				<a href="#" class="thumbnail">
					<img src="<s:property value="#session.admin.headPath"/>" alt="" class="caption"> 
				</a>
				<div class="well well-small smallt">
					<h4><s:property value="#session.admin.userName"/> ，你好！</h4>
					<p>欢迎您再次来到<br />后台</p>
				</div>
				<div class="line-dotted"></div>
				<!-- 引入左侧导航 -->
				<%@include file="left.jsp"%>
			</div>
			<div class="span10">
				<div class="row-fluid">
					<ul class="thumbnails">
						<li class="span2">
							<a href="<%=basePath%>admin/jsp/member/memberinfoment.jsp?operate=find" class="thumbnail">
								<img src="<%=basePath%>admin/ui/assets/img/header/icon-48-liveAll.png" alt="" class="caption">
								<span>信息</span>
							</a>
						</li>																			
					</ul>
				</div>			
			</div>	
		</div>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>