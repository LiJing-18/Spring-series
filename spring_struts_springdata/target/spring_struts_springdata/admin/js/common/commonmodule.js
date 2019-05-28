
//截取字符串
function spiltCategoryType(categoryType){
	var result=categoryType.split("-"); 
	var all = result[0] + "-" + result[1];
	return all;
}
//获取html文本
function removeHTMLTag(str) {
    str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
    str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
    //str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
    str=str.replace(/&nbsp;/ig,'');//去掉&nbsp;
   // str=str.replace(/\s/g,''); //将空格去掉
    return str;
}

/**  
 * 加法运算，避免数据相加小数点后产生多位数和计算精度损失。  
 *  
 * @param num1加数1 | num2加数2  
 */  
function numAdd(num1, num2) {  
    var baseNum, baseNum1, baseNum2;  
    try {  
        baseNum1 = num1.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum1 = 0;  
    }  
    try {  
        baseNum2 = num2.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum2 = 0;  
    }  
    baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));  
    return (num1 * baseNum + num2 * baseNum) / baseNum;  
};  

/**  
 * 减法运算，避免数据相减小数点后产生多位数和计算精度损失。  
 *  
 * @param num1减数1 | num2减数2  
 */  
function numSubtract(num1, num2) {  
    var baseNum, baseNum1, baseNum2;  
    try {  
        baseNum1 = num1.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum1 = 0;  
    }  
    try {  
        baseNum2 = num2.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum2 = 0;  
    }  
    baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));  
    return (num1 * baseNum - num2 * baseNum) / baseNum;  
};  

/**  
 * 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。  
 *  
 * @param num1被乘数 | num2乘数  
 */  
function numMulti(num1, num2) {  
    var baseNum = 0;  
    try {  
        baseNum += num1.toString().split(".")[1].length;  
    } catch (e) {  
    }  
    try {  
        baseNum += num2.toString().split(".")[1].length;  
    } catch (e) {  
    }  
    return Number(num1.toString().replace(".", ""))  
            * Number(num2.toString().replace(".", ""))  
            / Math.pow(10, baseNum);  
};  

/**  
 * 除法运算，避免数据相除小数点后产生多位数和计算精度损失。  
 *  
 * @param num1被除数 | num2除数  
 */  
function numDiv(num1, num2) {  
    var baseNum1 = 0, baseNum2 = 0;  
    var baseNum3, baseNum4;  
    try {  
        baseNum1 = num1.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum1 = 0;  
    }  
    try {  
        baseNum2 = num2.toString().split(".")[1].length;  
    } catch (e) {  
        baseNum2 = 0;  
    }  
    with (Math) {  
        baseNum3 = Number(num1.toString().replace(".", ""));  
        baseNum4 = Number(num2.toString().replace(".", ""));  
        return (baseNum3 / baseNum4) * pow(10, baseNum2 - baseNum1);  
    }  
};  

/**
 * 取值范围
 * @param range
 * @param range2
 * @param num
 * @returns {Boolean}
 */
function dataRange(range, range2, num) {
	if (num < range || num > range2) {
		return true;
	}
	return false;
}

function calculateOdds(amount, prob, proportion) {
	calOdds = 100/prob-proportion*(100/prob);
	/*if (amount==2) {
		var calOdds = 100/prob-0.11*(100/prob);
	}*/
	calOdds = Math.floor(calOdds * 100) / 100;
	return calOdds;
}

function sleep(milliseconds) {
    setTimeout(function(){
        var start = new Date().getTime(); 
        while ((new Date().getTime() - start) < milliseconds){
            // Do nothing
        }
    },0);
}



