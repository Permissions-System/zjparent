//检查是否为空
function isNull(str) {
	str = $.trim(str);
	if (NaN == str || str == undefined || str == "undefined" || str == null || str.length == 0 || str == "null" || "--" == str) {
		return true;
	} else {
		var ft = /^\s*$/; // 半角正则

		if (ft.test(str)) {
			return true;
		}
		var st = /[\u3000]/g; // 全角正则

		if (st.test(str)) {
			return true;
		}

		return false;
	}
}

// 判断非空
function isNotNull(str) {
	return !isNull(str);
}
/**
 * 处理字符串 ，为空时使用默认值
 */
function cgNull(str, ds) {
	if (isNull(str)) {
		return ds;
	} else {
		return str;
	}
};
// 是否是整数
function isInt(str) {
	var regex = /^\d*$/;
	if (regex.test(str)) {
		return true;
	} else {
		return false;
	}
}

// 是否不是整数
function isNotInt(str) {
	return !isInt(str);
}

/**
 * 验证是否是形如 12:00 08:00的 标准时分 字符串
 * 
 * @param str
 * @author lutao
 */
function isShortTime(str) {
	var regex = /^([0-1]{1}[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}$/;
	if (regex.test(str)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 字符串 str 中 替换 字符 val1 为 val2
 * 
 * @param strExps
 *            需要处理的字符串
 * @param val1
 *            待替换的字符
 * @param val2
 *            替换后的字符
 * @author lutao
 */
function cgReplaceAll(strExps, val1, val2) {
	strExps = strExps + "";
	if (isNotNull(strExps)) {
		strExps = strExps.replace(eval("/" + val1 + "/g"), val2);
	} else {
		strExps = "";
	}
	return strExps;
}

/**
 * 文本框的限制输入处理 输入半角字符(包括英文,数字\符号等,不包括中文)并转化为大写 jObject input类型的 jquery访问对象
 * 增加限制条件，只能输入 英文字符，数字 下划线
 * 
 * @author lutao
 */
function toUpperCase_onKeyUp(jObject) {
	var val = jObject.val();
	// 代码类型 只能输入 英文字符，数字 下划线
	// 去除双字节字符(包括汉字在内)
	val = val.replace(/[\u4E00-\u9FA5]/g, '');

	val = val.replace(/[^a-zA-Z0-9_]/g, '');

	// 替换空格
	val = cgReplaceAll(val, ' ', '');
	// 新增特殊字符的校验
	val = val.toUpperCase();// 小写字母转大写
	jObject.val(val);
}

// 名称类别的文字输入按照菜单定义的规则进行正则替换
function inputNameValue_onKeyUp(jObject) {
	var val = jObject.val();
	val = val.replace(/[^a-zA-Z0-9_\-\u4E00-\u9FA5\(\)\（\）]/g, '');
	val = cgReplaceAll(val, ' ', '');
	jObject.val(val);
}

/**
 * 查询类输入文本限制字符输入 主要涉及Oracle的 “_” 的规避处理
 */
function inputNameQueryValue_onKeyUp(jObject) {
	var val = jObject.val();
	val = val.replace(/[^a-zA-Z0-9\-\u4E00-\u9FA5]/g, '');
	val = cgReplaceAll(val, ' ', '');
	jObject.val(val);
}

/**
 * 查询类输入文本限制字符输入 主要涉及Oracle的 “_” 的规避处理
 */
function inputCodeQueryValue_onKeyUp(jObject) {
	var val = jObject.val();
	val = val.replace(/[^a-zA-Z0-9\-]/g, '');
	val = cgReplaceAll(val, ' ', '');
	jObject.val(val);
}

/** ***数字处理方法--开始************ */
/*
 * 保留小数点后N位数 直接截取 value 数字 num 位数
 */
function formatnumberSub(value, num) {
	var a, b, c, i;
	a = value.toString();
	b = a.indexOf('.');
	c = a.length;
	if (num == 0) {
		if (b != -1)
			a = a.substring(0, b);
	} else {
		if (b == -1) {
			a = a + ".";
			for (i = 1; i <= num; i++)
				a = a + "0";
		} else {
			a = a.substring(0, b + num + 1);
			for (i = c; i <= b + num; i++)
				a = a + "0";
		}
	}
	return a;
};
/*
 * 保留小数点后N位数 四舍五入 value 数字 num 位数
 */
function formatnumberAdv(value, num) {
	var a_str = formatnumberSub(value, num);
	var a_int = parseFloat(a_str);
	if (value.toString().length > a_str.length) {
		var b_str = value.toString().substring(a_str.length, a_str.length + 1);
		var b_int = parseFloat(b_str);
		if (b_int < 5) {
			return a_str;
		} else {
			var bonus_str, bonus_int;
			if (num == 0) {
				bonus_int = 1;
			} else {
				bonus_str = "0.";
				for ( var i = 1; i < num; i++) {
					bonus_str += "0";
				}
				bonus_str += "1";
				bonus_int = parseFloat(bonus_str);
			}
			a_str = formatnumberSub(a_int + bonus_int, num);
		}
	}
	return a_str;
}

/**
 * 数字转化十进制格式
 * 
 * @sample numberToDecimal("12002");
 * @result 12,002
 */

function numberToDecimal(num) {
	if (/^.*\..*$/.test(num)) {
		var pointIndex = num.lastIndexOf(".");
		var intPart = num.substring(0, pointIndex);
		var pointPart = num.substring(pointIndex + 1, num.length);
		intPart = intPart + "";
		var re = /(-?\d+)(\d{3})/;
		while (re.test(intPart)) {
			intPart = intPart.replace(re, "$1,$2");
		}
		num = intPart + "." + pointPart;
	} else {
		num = num + "";
		var re = /(-?\d+)(\d{3})/;
		while (re.test(num)) {
			num = num.replace(re, "$1,$2");
		}
	}
	return num;
}

function formatNumber(obj) {
	if (obj.value != "") {
		// add 0 pre .
		if (obj.value.indexOf(".") == 0) {
			obj.value = "0" + obj.value;
		}
		// remove 0 after .
		if (obj.value.match(/\.[0-9]*[0]+/)) {

			obj.value = obj.value.replace(/[0]+$/, "");
			if (obj.value.lastIndexOf(".") == obj.value.length - 1) {
				obj.value = obj.value.replace(/\.$/, "");
			}
		}
		// remove 0 pre when interger
		if (obj.value.indexOf(".") < 0 && obj.value.match(/^[0]+/)) {
			obj.value = obj.value.replace(/^[0]+/, "");
			if (obj.value == "") {
				obj.value = 0;
			}
		}
		// remove last .
		if (obj.value.lastIndexOf(".") == obj.value.length - 1) {
			obj.value = obj.value.replace(/\.$/, "");
		}
		// remove chinese
		obj.value = obj.value.replace(/[\u4e00-\u9fa5]/g, "");
		obj.value = obj.value.replace(/[\u3002\uff1b\uff0c\uff1a\u201c\u201d\uff08\uff09\u3001\uff1f\u300a\u300b]/g, "");
		// remove char
		obj.value = obj.value.replace(/[a-zA-Z]*/g, "");

		// clean ,
		obj.value = obj.value.replace(/,/g, "");
		if (obj.value == ".") {
			obj.value = "";
		}
		// format xx,xxx,xxx
		obj.value = numberToDecimal(obj.value);

	}

}

/**
 * 浮点数(小数点后两位)
 * 
 * @param str
 * @returns {Boolean}
 */
function isFloat(str) {
	var regex = /^(-|\+)?\d+(\.\d+)?$/;
	if (regex.test(str)) {
		return true;
	} else {
		return false;
	}
}
function isNotFloat(str) {
	return !isFloat(str);
}

function floatFormat(s) {
	if (isNull(s)) {
		return "";
	}

	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(2) + "";

	var lt = s.split(".")[0].split("").reverse();
	var lk = s.split(".")[1];
	var tk = "";
	for ( var i = 0; i < lt.length; i++) {
		tk += lt[i] + ((i + 1) % 3 == 0 && (i + 1) != lt.length ? "," : "");
	}
	tk = tk.split("").reverse().join("") + "." + lk;

	tk = strReplaceAll(tk + "", ",", "");

	return tk;
}

/**
 * 判断是否中文
 */
function isChinese(str) {
	var fg = true;
	for ( var i = 0; i < str.length; i++) {
		fg = fg && (str.charCodeAt(i) >= 10000);
	}
	return fg;
}

/** ***json 操作系列方法----结束********** */

/** ****日期 操作系列方法----开始******** */
/**
 * 输入两个日期串（YYYY-MM-DD）,返回两个日期相差几天 @ sample
 * fetchDateSegMent("2013-04-28","2014-04-30"); @ result 367
 */
function fetchDateSegMent(a, b) {

	if (a == "" || b == "") {
		return 0;
	} else {
		var a1 = a.substring(0, 4);
		var a2 = a.substring(5, 7);
		var a3 = a.substring(8, 10);
		var b1 = b.substring(0, 4);
		var b2 = b.substring(5, 7);
		var b3 = b.substring(8, 10);
		/* 把日期格式更新为：MM/DD/YYYY 即月/日/年 */
		var dt1 = a2 + "/" + a3 + "/" + a1;
		var dt2 = b2 + "/" + b3 + "/" + b1;

		var dateObj1 = new Date(dt1);
		var dateObj2 = new Date(dt2);
		return (dateObj2 - dateObj1) / (24 * 3600 * 1000);
	}
}

/**
 * 短时间，形如 (13:04:06)
 */
function isTime(str) {
	var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
	if (a == null) {
		return false;
	}
	if (a[1] > 24 || a[3] > 60 || a[4] > 60) {
		return false;
	}
	return true;
}
function isNotTime(str) {
	return !isTime(str);
}
/**
 * 短日期，形如 (2003-12-05)
 * 
 * @param str
 * @returns {Boolean}
 */
function isDate(str) {
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
	if (r == null) {
		return false;
	}
	var d = new Date(r[1], r[3] - 1, r[4]);
	return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4]);
};
function isNotDate(str) {
	return !isDate(str);
}
/**
 * 长时间，形如 (2003-12-05 13:04:06)
 * 
 * @param str
 * @returns {Boolean}
 */
function isDateTime(str) {
	var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	var r = str.match(reg);
	if (r == null) {
		return false;
	}
	var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
	return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4] && d.getHours() == r[5] && d.getMinutes() == r[6] && d.getSeconds() == r[7]);
}
function isNotDateTime(str) {
	return !isDateTime(str);
}

/**
 * 获取当前年月日，格式例如：2013-11-26
 */
function getCurrentDate() {
	var dateObj = new Date();

	var nt = dateObj.getFullYear();// 年
	var mt = dateObj.getMonth() + 1;// 月
	var xt = dateObj.getDate();// 日

	return nt + "-" + (mt < 10 ? "0" : "") + mt + "-" + (xt < 10 ? "0" : "") + xt;
}
/**
 * 获取当前年月，格式例如：2013-11
 */
function getDateExt() {
	var dateObj = new Date();

	var nt = dateObj.getFullYear();// 年
	var mt = dateObj.getMonth() + 1;// 月

	return nt + "-" + (mt < 10 ? "0" : "") + mt;
}
/**
 * 获取当前年，格式例如：2013
 */
function getYearExt() {
	return (new Date()).getFullYear();// 年
}

/** ****日期 操作系列方法----结束******** */
/**
 * 刷新tab
 */
function reloadTab(title) {
	var tab = $("#tabs", $(self.parent.document));
	$(".tabs-title", $(tab)).each(function(i, s) {
		if (title == $(s).text()) {
			$(s).unbind("click").bind("click", function() {
				var panel = $(".tabs-panels", $(tab));
				$(".panel", $(panel)).each(function(k, e) {
					if (i == k) {
						$(s).unbind("click");
						
						$("iframe", $(e)).attr("src", $("iframe", $(e)).attr("src"));
					}
				});
			});
		}
	});
}

/**
 * 文件上传
 * 
 * @param it
 * @param allowFile
 * @param callBack
 * @returns {Boolean}
 */
function ajaxFileUpload(fileId, uploadType, fileUploadCallback, thumbnail) {
	var val = $("#jQueryFormFile" + fileId).val();
	if (isNull(val)) {
		$.messager.alert("提示", "请选择文件！", "info");
	} else {
		$.ajaxFileUpload({
			url : ctx + '/base/file/fileUpload',// 用于文件上传的服务器端请求地址
			secureuri : false,// 一般设置为false
			fileElementId : fileId,// 文件上传空间的id属性
			data : {
				uploadType : uploadType || "img",// 文件大写限制
				thumbnail : thumbnail || ""// 是否需要缩略图，为空时，默认无缩略图,不为空时，长和宽
			},
			callback : fileUploadCallback
		});
	}
}
/**
 * input、textarea、select控件readonly、disabled时禁用退格键
 * 
 * @param 按键事件对象
 * @returns
 */
function prevent(e) {
	var doPrevent;
	if (e.keyCode == 8) {
		var d = e.srcElement || e.target;
		if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA' || d.tagName.toUpperCase() == 'SELECT') {
			doPrevent = d.readOnly || d.disabled;
		} else
			doPrevent = true;
	} else
		doPrevent = false;

	if (doPrevent)
		e.preventDefault();
};

/**
 * 文件上传
 * 
 * @param width
 * @returns {IBankFileUpload}
 */
IBankFileUpload = function(width) {
	this.init(width);
};

IBankFileUpload.prototype = {
	init : function(width) {
		// 初始化所有
		$('span[type="file"]').each(function() {
			var _self = $(this);
			$(_self).html('<input type="file" id="jQueryFormFile' + $(_self).attr("id") + '" name="fileUpload" class="ui-file-select ui-clear-filedata" value="" style="width:' + width + 'px" /><img src="' + ctx + '/static/images/loading.gif" class="loading" style="position:relative;left:10px;top:5px;width:20px;height:20px;display:none;">');
		});
	}
};

/**
 * 传入 combobox的jquery对象，根据其绑定的数据个数动态设置 panelHeight 的高度
 */
function getComBoboxPanelHeight(comOjb) {
	var data = comOjb.combobox("getData");
	var height = 0;
	if (data.length == 0) {
		height = 25;
	} else if (data.length > 0 && data.length < 9) {
		height = 25 * data.length;
	} else {
		// 默认值 200
		height = 200;
	}

	return height;
}
