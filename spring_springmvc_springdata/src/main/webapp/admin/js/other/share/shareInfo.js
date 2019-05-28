$(function(){
	//删除照片
	deleteSelectPictureA=function(){
		var str = "";
		var sum = 0;
		$(":checkbox[name='pcpathstatic']").each(function() {
			if ($(this).attr("checked")) {
				sum++;
				str += this.id + ",";
			}
		});
		if (sum == 0) {
			alert('只有在选择图片后才能删除');
			return false;
		}
		var array = new Array();
		array = str.split(",");
		$(array).each(function(k, v) {
			$("#triggers img").remove("img[id=" + v + "]");
			$("#triggers input[name='pcpathstatic']").remove("input[id=" + v + "]");
		});
	},
	
	 
	$("#delpcA").click(function() {
		deleteSelectPictureA();
	});	
	//查看所有
	findAllShareInfo = function (){
		$("#shareinfoment").flexigrid( {
			url:'findAllShareInfo.action',
			dataType : "json",
			cache : false,
			colModel : [ {
				display:"类型",
				name:"type",
				width:90,
				sortable:true,
				align:"center"
			},{
				display:"文字",
				name:"content",
				width:120,
				sortable:true,
				align:"center"	
			},{
				display:"图片",
				name:"imgUrl",
				width:120,
				sortable:true,
				align:"center"	
			}],
			buttons : [ {
				name : "添加",
				bclass : "add",
				onpress : action
			},{
				name : "编辑",
				bclass : "edit",
				onpress : action
			},{
				name:"删除",
				bclass:"del",
				onpress:action
			}],

			searchitems : [{
				display:"请选择搜索条件",
				name:"sc",
				isdefault : true
			} ],
			sortname : "registtime",
			sortorder : "desc",
			usepager : true,
			title : "",
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			width :"auto",
			height : "auto",
			pagestat : "显示{from}到{to}条，共{total}条记录",
			procmsg : "正在获取数据，请稍候...",
			checkbox:true
		});
		function action(com, grid){
			if(com=="添加"){
				window.open("shareInfo.jsp?operate=add");
				return;
			}else if(com=="编辑"){
				if ($(".trSelected", grid).length == 1) {
					var str = $(".trSelected", grid)[0].id.substr(3);
					window.open("shareInfo.jsp?operate=edit&id="+str);
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}else if(com=="删除"){
				if ($(".trSelected", grid).length > 0) {
					var str="";
					$(".trSelected td:nth-child(1) div", $("#shareinfoment")).each(function(i){
						str+=this.innerHTML+"  ";
					});
					$("#contentp").text("是否删除这条数据?");
					$("#delModal").modal({
						keyboard:true,
						show:true,
					});
					$("#btnok").click(function(){
						var str = "";
						$(".trSelected", grid).each(function() {
							str += this.id.substr(3)+",";
						});
						$.post("delShareInfoById.action", {
							"id" : str
						}, function(data) {
							if (data.sucflag) {
								$("#delModal").modal("hide");
								$("#alerterror").modal("hide");
								$("#shareinfoment").flexReload();
								forminfo("#alertinfo", "删除该条数据成功");
							}
						});
					});
					$("#btnclose").click(function(){
						$("#delModal").modal("hide");
					});
					return;
				} else {
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			}
		}	
	
	};	
	/*==================================================================================*/
	//根据id查
	selectShareInfoById = function (){
		var id=$.query.get("id");
		if(id===""){
			return false;
		}
		$.post("selectShareInfoById.action",{"id":id},function(data){
			if(data.sucflag){
				$("#type").attr("value",data.shareInfo.type);
				$("#content").attr("value",data.shareInfo.content);
				
				if(data.shareInfo.imgUrl!=""){
					 var htm = "<img id='image' src='" +data.shareInfo.imgUrl + "'/>";
			         var checkpc = "<input id='image' name='pcpathstatic' type='checkbox' value='" + data.shareInfo.imgUrl+ "' checked='true' />";
			         $("#triggers").html(htm).append(checkpc);
				}
						
				$("#submit").hide();
				$("#update").show();
			}	
		});
	};
	/*====================================================================*/
	//修改
	updateShareInfoById = function (){
		var id=$.query.get("id");
		//类型
		var type = $("#type").val();
		if(type==""){
			formwarning("#alerterror", "必须选择类型");
			return false;
		}
		//内容
		var content = $("#content").val();
		if(content==""){
			formwarning("#alerterror", "必须选择内容");
			return false;
		}
		//图片
		var imgUrl = "";
		$(":checkbox[name='pcpathstatic']").each(function() {
			if($(this).attr("checked")){
				imgUrl=this.value;
			}
		});	
		
		
		
		$("#update").attr("disabled", true);
		var id=$.query.get("id");
		$.post("updateShareInfoById.action",{
			"id":id,
			"type":type,
			"content":content,
			"imgUrl":imgUrl
		},function (data){
			if(data.sucflag){
				var from = $.query.get("from");
				if (from === "findAllChild"){
					window.location.href="shareInfoMent.jsp?operate=find";
				}else {
					window.location.href="shareInfoMent.jsp?operate=find";
				}
				return;
			}else{
				if(data.message!=""){
					formwarning("#alerterror",data.message);
					$("#update").attr("disabled", false);
					return false;
				}else{
					formwarning("#alerterror", "编辑失败");
					return false;
				}
			}
		});
	}
	/*========================================================================*/
	//添加
	/*========================================================================*/
	insertShareInfo = function () {
		//类型
		var type = $("#type").val();
		if(type==""){
			formwarning("#alerterror", "必须选择类型");
			return false;
		}
		//内容
		var content = $("#content").val();
		if(content==""){
			formwarning("#alerterror", "必须选择内容");
			return false;
		}
		//图片
		var imgUrl = "";
		$(":checkbox[name='pcpathstatic']").each(function() {
			if($(this).attr("checked")){
				imgUrl=this.value;
			}
		});
		$.post("insertShareInfo.action",{
			"type":type,
			"content":content,
			"imgUrl":imgUrl
		},function(data){
			if(data.sucflag){
				window.location.href="shareInfoMent.jsp?operate=find&colourId="+data.colourId;
				return;
			}else{
				formwarning("#alerterror", "添加失败(类型是否重复)");
				return;
			}
		});	
	};
	/*==================================================================*/
	$("#submit").click(function(){
		insertShareInfo();
	});
	/*==================================================================*/
	$("#update").click(function(){
		updateShareInfoById();
	});
	/*=================================================================*/
	var operate = $.query.get("operate");
	if(operate=="find"){//查询所有套装
		findAllShareInfo();
	}else if(operate=="edit"){
		selectShareInfoById();
	}
});