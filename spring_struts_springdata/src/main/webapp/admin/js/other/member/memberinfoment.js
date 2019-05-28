$(function(){	
	findAllMemberInfo=function(){
		$("#memberinfoment").flexigrid( {
			url : "findAllMemberInfo.action",
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
				width:50,
				sortable:true,
				align:"center"
			},{ 
				display:"地区",
				name:"area",
				width:120,
				sortable:true,
				align:"center"
			},{ 
				display:"积分",
				name:"jifen",
				width:120,
				sortable:true,
				align:"center"
			},{ 
				display:"创建时间",
				name:"createdDate",
				width:150,
				sortable:true,
				align:"center"
			}],

			searchitems : [{
				display:"请选择搜索条件",
				name:"sc",
				isdefault : true
			}, {
				display : "昵称",
				name : "nickname"
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
		}	
	};

	var operate = $.query.get("operate");
	if(operate=="find"){
		findAllMemberInfo();
	}
});