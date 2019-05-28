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
	findAllAoneMemberInfoList=function(){
		$("#aoneMemberInfo").flexigrid( {
			url : "findAllAoneMemberInfoList.action",
			dataType : "json",
			cache : false,
			colModel : [ { 
				display:"昵称",
				name:"nickname",
				width:150,
				sortable:true,
				align:"center"
			},{ 
				display:"头像",
				name:"headImgUrl",
				width:50,
				sortable:true,
				align:"center"
			},{ 
				display:"性别",
				name:"sex",
				width:150,
				sortable:true,
				align:"center"
			},{ 
				display:"创建时间",
				name:"createdDate",
				width:150,
				sortable:true,
				align:"center"
			}],
			buttons : [ {
				name : "添加",
				bclass : "add",
				onpress : action
			},{
				name:"删除",
				bclass:"del",
				onpress:action
			}/*,{
				name:"水军发布的图片",
				bclass:"edit",
				onpress:action
			}*/,{
				separator : true
			}],

			searchitems : [{
				display:"请选择搜索条件",
				name:"sc",
				isdefault : true
			}],
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
				window.open("aoneMemberInfo.jsp?operate=add");
				return;
			}else if(com=="删除"){
				if ($(".trSelected", grid).length > 0) {
					var str="";
					$(".trSelected td:nth-child(1) div", $("#aoneMemberInfo")).each(function(i){
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
						$.post("delAoneMemberInfobyId.action", {
							"id" : str
						}, function(data) {
							if (data.sucflag==true) {
								$("#delModal").modal("hide");
								$("#alerterror").modal("hide");
								$("#aoneMemberInfo").flexReload();
								forminfo("#alertinfo", "删除该条数据成功");
							}else if(data.sucflag==false){
								$("#delModal").modal("hide");
								$("#alerterror").modal("hide");
								$("#aoneMemberInfo").flexReload();
								forminfo("#alertinfo", "删除失败！请检查");
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
			}/*else if (com=="水军发布的图片") {
				if ($(".trSelected", grid).length == 1) {
					var str = $(".trSelected", grid)[0].id.substr(3);
					window.open("../../jsp/photo/aoneMemberInfo.jsp?operate=find&memberId="+str);
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			}   */
		}	
	};
	/*========================================================================*/
	//添加
	insertaoneMemberInfo = function () {
	
		var nickname = $("#nickname").val();
		if(nickname==""){
			formwarning("#alerterror", "必须选择昵称");
			return false;
		}
		
		var headImgUrl = "";
		$(":checkbox[name='pcpathstatic']").each(function() {
			if($(this).attr("checked")){
				headImgUrl=this.value;
			}
		});
												
		$.post("insertAoneMemberInfo.action",{
			"nickname":nickname,
			"headImgUrl":headImgUrl
		},function(data){
			if(data.sucflag){
				window.location.href="aoneMemberInfoment.jsp?operate=find";
				return;
			}else{
				formwarning("#alerterror", "添加失败");
				return;
			}
		});	
	};
	/*==================================================================*/
	$("#submit").click(function(){
		insertaoneMemberInfo();
	});
	/*==================================================================*/
	var operate = $.query.get("operate");
	if(operate=="find"){
		findAllAoneMemberInfoList();
	}
});