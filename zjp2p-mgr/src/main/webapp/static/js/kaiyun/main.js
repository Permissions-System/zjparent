	/**
	* 判断开始字符是否是XX
	*
	* @author 孙宇
	*/
	$.startWith = function(source, str) {
	var reg = new RegExp("^" + str);
	return reg.test(source);
	};
	
	/**
	* 格式化Date
	* @param val
	* @param row
	* @param index
	* @returns
	*/
	function CEdit(val, row, index) {
	if(val!=null && val!=""){
	var d =new Date(val).format('yyyy-MM-dd hh:mm:ss');
	return d;
	}else{
	return null;
	}
	
	}
	function CEditymd(val, row, index) {
	if(val!=null && val!=""){
	var d =new Date(val).format('yyyy-MM-dd');
	return d;
	}else{
	return null;
	}
	}
	
	
	Date.prototype.format =function(format)
	{
	var o = {
	"M+" : this.getMonth()+1, //month
	"d+" : this.getDate(), //day
	"h+" : this.getHours(), //hour
	"m+" : this.getMinutes(), //minute
	"s+" : this.getSeconds(), //second
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter
	"S" : this.getMilliseconds() //millisecond
	}
	if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
	(this.getFullYear()+"").substr(4- RegExp.$1.length));
	for(var k in o)if(new RegExp("("+ k +")").test(format))
	format = format.replace(RegExp.$1,
	RegExp.$1.length==1? o[k] :
	("00"+ o[k]).substr((""+ o[k]).length));
	return format;
	}
	
	/**
	* 将数值四舍五入(保留2位小数)后格式化成金额形式
	*
	* @param num 数值(Number或者String)
	* @return 金额格式的字符串,如'1,234,567.45'
	* @type String
	*/
	function formatCurrency(num) {
		var result;
		if(num!=null && num!=''){
			num = num.toString().replace(/\$|\,/g,'');
			if(isNaN(num))
			num = "0";
			sign = (num == (num = Math.abs(num)));
			num = Math.floor(num*100+0.50000000001);
			cents = num%100;
			num = Math.floor(num/100).toString();
			if(cents<10)
			cents = "0" + cents;
			for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
			num = num.substring(0,num.length-(4*i+3))+','+
			num.substring(num.length-(4*i+3));
			 result = (((sign)?'':'-') + num + '.' + cents);
		}
		else
		{
			result = "0.00";
		}
		return result;
	
	}
	
	/**
	* 替换手机号中间几位
	*
	* @param num 数值(Number或者String)
	* @return 金额格式的字符串,如'138****7328'
	* @type String
	*/
	function formatMobile(num) {
	var str = num ;
	var reg = /1(\d{2})\d{4}(\d{4})/g;
	str = str.replace(reg,"1$1****$2");
	return str;
	/*if(num.length==11 && /^\d{11}$/.test(num))
	{
	var reg = /1(\d{2})\d{4}(\d{4})/g;
	str = str.replace(reg,"1$1****$2");
	}
	else
	{
	if(num.length>2)
	{
	//num.substring(0, 3) + "****" + $("#phone").val().substring(7, 11));
	for (int i = 2; i < num.length() - 2; i++)
	{
	num.replace(i, '*');
	}
	}
	}
	return str;*/
	
	}
	
	
	/*//为date 添加format方法
	Date.prototype.Format = function (fmt) { //author: meizz
	var o = {
	"M+": this.getMonth() + 1, //月份
	"d+": this.getDate(), //日
	"h+": this.getHours(), //小时
	"m+": this.getMinutes(), //分
	"s+": this.getSeconds(), //秒
	"q+": Math.floor((this.getMonth() + 3) / 3), //季度
	"S": this.getMilliseconds() //毫秒
	};
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
	if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
	}
	
	//根据tpi_birth的time值实例一个date对象
	var d = new Date(parseInt(tpi_birth.time));
	//将日期格式化，d_str就是你想要的值
	var d_str = new Date().Format("yyyy-MM-dd");*/
	
	
	/**
	* 格式化年月日
	*/
	function YMDData(val, row, index) {
	if(val!="" && val!=undefined && val!=null)
	{
	var time =new Date(val).format('yyyy-MM-dd');
	return time;
	}else{
	return null;
	}
	
	}
	
	/**
	* 秒数转换为时分秒
	* @param value
	* @returns {String}
	*/
	function SFMData(val, row, index)
	{
	if(val!="" && val!=undefined && val!=null)
	{
	var time =new Date(val).format('yyyy-MM-dd hh:mm:ss');
	
	return time.substring(11,time.length);
	}else{
	return null;
	}
	}
	
	/**
	* 转换千分位
	* @param val
	* @param row
	* @param index
	* @returns {string}
	*/
	function ThousandsNumber(val, row, index)
	{
	
	if(val!="" && val!=null && val!=undefined)
	{
	return formatThousandsNumber(val,2,1);
	}
	return null;
	}
	
	/**
	* 获取差异数据的颜色
	*/
	function GetColor(val, row, index)
	{
	if(val!="成功")
	{
	return "<font style='color:red'>"+val+"</font>";
	}else{
	return val;
	}
	
	}
	
	
	/**
	* 千分位钱
	* 第一个参数为要转换的钱
	* 第二个参数为要四舍五入的个数
	* 第三个参数为是否转换千分位（0是不转换，也就是保存数据库的值，1是转换千分位）
	* @param num
	* @param cent
	* @param isThousand
	* @returns {string}
	*/
	function formatThousandsNumber(num, cent, isThousand) {
	num = num.toString().replace(/\$|\,/g, '');
	if (isNaN(num))//检查传入数值为数值类型.
	num = "0";
	if (isNaN(cent))//确保传入小数位为数值型数值.
	cent = 0;
	cent = parseInt(cent);
	cent = Math.abs(cent);//求出小数位数,确保为正整数.
	if (isNaN(isThousand))//确保传入是否需要千分位为数值类型.
	isThousand = 0;
	isThousand = parseInt(isThousand);
	if (isThousand < 0)
	isThousand = 0;
	if (isThousand >= 1) //确保传入的数值只为0或1
	isThousand = 1;
	sign = (num == (num = Math.abs(num)));//获取符号(正/负数)
	//Math.floor:返回小于等于其数值参数的最大整数
	num = Math.floor(num * Math.pow(10, cent) + 0.50000000001);//把指定的小数位先转换成整数.多余的小数位四舍五入.
	cents = num % Math.pow(10, cent); //求出小数位数值.
	num = Math.floor(num / Math.pow(10, cent)).toString();//求出整数位数值.
	cents = cents.toString();//把小数位转换成字符串,以便求小数位长度.
	while (cents.length < cent) {//补足小数位到指定的位数.
	cents = "0" + cents;
	}
	if (isThousand == 0) //不需要千分位符.
	return (((sign) ? '' : '-') + num + '.' + cents);
	//对整数部分进行千分位格式化.
	for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
	num = num.substring(0, num.length - (4 * i + 3)) + ',' +
	num.substring(num.length - (4 * i + 3));
	return (((sign) ? '' : '-') + num + '.' + cents);
	}
	
	function Loading()
	{
	var win = $.messager.progress({
	title:'Please waiting',
	msg:'Loading data...'
	});
	}
	
	
	function closeLoading()
	{
	$.messager.progress('close');
	}
