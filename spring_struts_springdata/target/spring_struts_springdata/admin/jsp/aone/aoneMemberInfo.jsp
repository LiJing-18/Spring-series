<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>水军管理</title>
<script type="text/javascript" src="../../../My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="../../../My97DatePicker/skin/WdatePicker.css" />
</head>

<body data-spy="scroll" data-target=".subnav" data-offset-top="40">
	<!-- header 包含头部导航-->
	<%@include file="/admin/header.jsp"%>
	<!-- end header -->
	<div id="navigation" class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#">
			<img src="<%=basePath%>admin/ui/assets/img/logo.png" width="175" height="30" alt="">
			</a> 
			<a class="brand" href="#">水军管理 </a>
			<a class="brand2">修改水军 </a>
		</div>
	</div>
	<div class="container-fluid containerb">
		<div class="row-fluid">
			<div class="span2">
				<!-- 引入左侧导航 -->
				<%@include file="/admin/left.jsp"%>
			</div>
			<div id="mainlogic" class="span10">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<strong>说明</strong> 请根据需要修改水军
				</div>
				<div id="alerterror" style="display: none;" class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">&times;</a> 
					<strong></strong>
				</div>
				<div id="alertinfo" style="display: none;" class="alert alert-info">
					<a class="close" data-dismiss="alert" href="#">&times;</a> 
					<strong></strong>
				</div>
				<div class="line-dotted"></div>
				<div class="btn-group">
					<button id="btnback" type="button" class="btn btn-success">返回</button>
				</div>
				
				<!-- form表单 -->
				<div class="form-actions">
							
					<div class="form-inline">
						<span class="label label-required">用户昵称:</span> 
						<input type="text" id="nickname" name="nickname" style="width: 400px"/>
						<span class="label label-important"></span>
					</div>
					
					<div class="form-inline">
						<table>
							<tr>
								<td><span class="label label-required">用户头像:</span></td>
								<td>
									<div id=headImgUrl>
										<noscript>
											Please enable JavaScript to use file uploader.
											<!-- or put a simple form for upload here -->
										</noscript>

									</div>
								</td>
							</tr>
						</table>
						<!-- trigger elements -->
						<div id="triggers"></div>
					</div>	
					
					<div class="form-inline">
						<span class="label label-required">操作:</span> 
						<input class="btn btn-success" type="button" id="delpcA" name="delpcA" value="删除所选图片" />
					</div> 				
					
					<div class="line-dotted"></div>
					<div id="matchModal" class="modal hide fade">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h3>关闭提示</h3>
						</div>
						<div class="modal-body">
							<p id="matchContent">One fine body…</p>
						</div>
						<div class="modal-footer">
							<a href="#" id="matchclose" class="btn">取消</a> <a href="#"
								id="matchok" class="btn btn-primary">确认修改</a>
						</div>
					</div>

					<div class="form-inline">
						<label class="label label-submit"></label> 
						<input type="hidden" id="hid" name="hid" value="" />
						<input class="btn btn-success" type="button" id="submit" name="submit" value="提交" />  
						<input class="btn btn-success" type="button" id="update" name="update" value="更新" style="display: none;" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>admin/js/other/aone/aoneMemberInfo.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/common/commonmodule.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/plugins/uploader/fileuploader.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/plugins/kindeditor/kindeditor-min.js"></script>	
	<script type="text/javascript" src="<%=basePath%>admin/js/common/startendwith.js"></script>
	<script type="text/javascript">
	function createUploader(){ 
		   var uploader = new qq.FileUploader({
             element: document.getElementById('headImgUrl'),
             action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
             debug: true,
             minSizeLimit:10,
             sizeLimit: 52428800,
             allowedExtensions: ['jpeg','jpg','gif','png'],
             onComplete: function(id, fileName, responseJSON){
            		var pcpath1=responseJSON.success;
            		var pcpath=responseJSON.success;
            		id = id + "static";
					var htm="<img id='"+id+"' src='"+pcpath1+"' rel='#"+fileName+"'/>";
					var checkpc="<input id='"+id+"' name='pcpathstatic' type='checkbox' value='"+pcpath+"' /> ";
					$("#triggers").append(htm).append(checkpc);
             },
         });
 	}
	window.onload = createUploader; 
	</script>
	<%@include file="/admin/footer.jsp"%>
</body>
</html>


