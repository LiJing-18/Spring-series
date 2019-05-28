function GetLocation(objName, Value) {

	total = document.getElementById(objName).length;
	for (var pp = 0; pp < total; pp++)
		//if (document.form1.elements[objName].options[pp].text == "---"+Value+"---")
		if (document.getElementById(objName).options[pp].value > Value) {
			return (pp);
			break;
		}
	return (total);
}

function InsertItem(objName, Location) {
	len = document.getElementById(objName).length;
	for (var counter = len; counter > Location; counter--) {
		Value = document.getElementById(objName).options[counter - 1].value;
		Text2Insert = document.getElementById(objName).options[counter - 1].text;
		document.getElementById(objName).options[counter] = new Option(
				Text2Insert, Value);
	}
}

//以下方法是是否用户只选择了一项(true: 表示选择的是一项；false：是选择不是一项)
function isSingleSelected(objName) {
	selectedItem = 0;
	for (var i = document.getElementById(objName).length - 1; i >= 0; i--) {
		if (document.getElementById(objName).options[i] != null
				&& document.getElementById(objName).options[i].selected == true) {
			selectedItem++;
			if (selectedItem > 1)
				return false;
		}
	}
	if (selectedItem != 1)
		return false;
	else
		return true;
}

//判断select控件中是否是空的(true: 表示是空的；false：表示不是空)
function isEmptyList(objName) {
	if (document.getElementById(objName).length == 0) {
		return true;
	} else {
		return false;
	}
}

function SwitchItem(objName, DesName, isSingle, isCheckEmpty) {
	/* 
	if(isSingle==true && isCheckEmpty == true && isSingleSelected(objName)==false){
	   alert("只可选择一项！");
	   return;
	}
	if(isSingle==true && isCheckEmpty == true && isEmptyList(DesName)==false){
	   return;
	}
	 */

	listLen = document.getElementById(objName).options.length;

	for (var i = 0; i <= listLen - 1; i++) {
		if (document.getElementById(objName).options[i] != null
				&& document.getElementById(objName).options[i].selected) {
			Code = document.getElementById(objName).options[i].value;
			Text = document.getElementById(objName).options[i].text;
			j = document.getElementById(DesName).options.length;
			HasSelected = false;
			for (var k = 0; k < j; k++) {
				if (document.getElementById(DesName).options[k].value == Code) {
					HasSelected = true;
					break;
				}
			}
			if (HasSelected == false) {

				Location = GetLocation(DesName, Code);

				if (Location == j) {
					document.getElementById(DesName).options[j] = new Option(Text, Code);
				} else {
					InsertItem(DesName, Location);
					document.getElementById(DesName).options[Location] = new Option(Text, Code);
				}
			} else {
				//alert("不能选择重复的");
			}

		}

	}

	for (i = document.getElementById(objName).length - 1; i >= 0; i--) {
		if (document.getElementById(objName).options[i] != null
				&& document.getElementById(objName).options[i].selected == true) {
			document.getElementById(objName).options[i] = null;
		}
	}
}

//选择给定的select标签中的所有元素
function selectAll(objName) {
	for (var i = document.getElementById(objName).length - 1; i >= 0; i--) {
		document.getElementById(objName).options[i].selected = true;
	}
}

//把select1中的所有元素移到select2中
function select1ToSelect2(select1, select2) {
	selectAll(select1);
	SwitchItem(select1, select2, true, true);
}
function test1() {
	alert("leftToRight.js");
}

//移动
function copySelected(fromObject, toObject) {
	var count = 0;
	for (var i = 0, len = fromObject.options.length; i < len; i++) {
		if (fromObject.options[i].selected) {
			count++;
			if (count == 1)
				toObject.selectedIndex = -1;
			addOption(toObject, fromObject.options[i].text, fromObject.options[i].value, true);
		}
	}
	if (count == 1)
		toObject.selectedIndex = toObject.options.length - 1;

}
function addOption(object, text, value, select) {
	var defaultSelected = false;
	var selected = select;
	var optionName = new Option(text, value, defaultSelected, selected);
	object.options[object.length] = optionName;
}
function deleteOption(object, index) {
	object.options[index] = null;
}

function removeSelected(fromObject) {
	for (var i = fromObject.options.length - 1; i > -1; i--) {
		if (fromObject.options[i].selected) {
			deleteOption(fromObject, i);
		}
	}
	fromObject.selectedIndex = 0;
}
function moveSelected(fromObject, toObject) {
	copySelected(fromObject, toObject);
	removeSelected(fromObject);
	fromObject.selectedIndex = -1;
}
function moveAll(fromObject, toObject) {
	for (var i = fromObject.options.length - 1; i > -1; i--) {
		fromObject.selectedIndex = i;
		copySelected(fromObject, toObject);
		removeSelected(fromObject);
	}
	fromObject.selectedIndex = -1;
}
