function onSelectChange(obj,toSelId){
	setSelect(obj.value,toSelId);
}


function setSelect(fromSelVal,toSelId){
	//alert(document.getElementById("province").selectedIndex);
	document.getElementById(toSelId).innerHTML="";
	jQuery.ajax({
	  url: "<%=path%>/getDropdownDataServlet",
	  cache: false,
	  data:"parentId="+fromSelVal,
	  success: function(data){
	    createSelectObj(data,toSelId);
	  }
	});
}

function createSelectObj(data,toSelId){
	var arr = jsonParse(data);
	if(arr != null && arr.length>0){
		var obj = document.getElementById(toSelId);
		obj.innerHTML="";
		var nullOp = document.createElement("option");
		nullOp.setAttribute("value","");
		nullOp.appendChild(document.createTextNode("请选择"));
		obj.appendChild(nullOp);
		for(var o in arr){
			var op = document.createElement("option");
			op.setAttribute("value",arr[o].id);
			//op.text=arr[o].name;//这一句在ie下不起作用，用下面这一句或者innerHTML
			op.appendChild(document.createTextNode(arr[o].name));
			obj.appendChild(op);
		}
		
	}
}

setSelect('1','province');
