jQuery.validator.addMethod("chcharacter", function(value, element) {
	
	var tel =/^[\u4E00-\u9FFF]+$/;
	return this.optional(element) || (tel.test(value));
}, "请输入汉字");

jQuery.validator.addMethod("compareDate",function(value,element,param){
	var startDate=$("#vipCreateTime2").val();
    startDate = new Date(parseInt(Date.parse(startDate),10));
    value = new Date(parseInt(Date.parse(value),10));

    if(startDate>value){
        return false;
    }else{
        return true;
    }
},"截止日期必须大于创建日期</font>");

jQuery.validator.addMethod("isFloatGtZero", function(value, element) {
	alert("hehe");
	var v=$("#goodsPrice").val();
	alert("v");
    v=parseFloat(v);
    
    return this.optional(element) || v>0;       
}, "浮点数必须大于0"); 
