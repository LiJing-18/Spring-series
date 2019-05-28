<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>水军管理</title>
</head>
<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#">
				<img src="<%=basePath%>admin/ui/assets/img/logo.png" width="175" height="30" alt="">
			</a> 
			<a class="brand" href="#">水军管理</a> 
			<a class="brand2">这里显示了所有水军列表</a>
		</div>
	</div>
	<div class="container-fluid containerb">
		<div class="row-fluid">
			<div class="span2">
				<!-- 引入左侧导航 -->
			</div>
			<div class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明!</strong> 这里显示了所有水军列表
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> 
					<strong></strong>
				</div>
				<div id="alerterror" style="display: none;" class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> 
					<strong></strong>
				</div>
				<div class="line-dotted"></div>
				<!-- flexusermanagement数据显示 -->
				<div id="flexaoneMemberInfo">
					<table id="aoneMemberInfo" style="display: none;"></table>
				</div>
				<div class="line-dotted"></div>
				<!-- 提示框 -->
				<div id="delModal" class="modal hide fade">
				  <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				    <h3>删除提示</h3>
				  </div>
				  <div  class="modal-body">
				    <p id="contentp">One fine body…</p>
				  </div>
				  <div class="modal-footer">
				    <a href="#" id="btnclose" class="btn">关闭</a>
				    <a href="#" id="btnok" class="btn btn-primary">确认删除</a>
				  </div>
				</div>
				<div id="forbiddenModal" class="modal hide fade">
				  <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				    <h3>禁用/解禁提示</h3>
				  </div>
				  <div  class="modal-body">
				    <p id="contentpForBidden">One fine body…</p>
				  </div>
				  <div class="modal-footer">
				    <a href="#" id="forbiddenbtnclose" class="btn">关闭</a>
				    <a href="#" id="btnokforbidden" class="btn btn-primary">确认禁用/解禁</a>
				  </div>
				</div>
				<div id="bannedModal" class="modal hide fade">
				  <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				    <h3>禁言/解禁提示</h3>
				  </div>
				  <div  class="modal-body">
				    <p id="bannedState">One fine body…</p>
				  </div>
				  <div class="modal-footer">
				    <a href="#" id="banndebtnclose" class="btn">关闭</a>
				    <a href="#" id="btnokbanned" class="btn btn-primary">确认禁言/解禁</a>
				  </div>
			 	 </div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>admin/js/other/aone/aoneMemberInfo.js"></script>
	<%@include file="/admin/footer.jsp"%>
</body>
</html>

