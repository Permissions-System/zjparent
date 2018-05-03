<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.zjgt.util.PropertiesUtils"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="webCtx" value='<%=PropertiesUtils.getEmail("email") %>'/>
<link rel="shortcut icon" href="${ctx}/static/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/pub/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/js/pub/jquery-easyui/themes/icon.css">
<link href="${ctx}/static/styles/reset.css" rel="stylesheet" type="text/css">
<%-- <link href="${ctx}/static/styles/global.css" rel="stylesheet" type="text/css"> --%>
<%-- <link href="${ctx}/static/styles/common.css" rel="stylesheet" type="text/css"> --%>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery-easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
  var ctx = '${ctx}';
  var webCtx = '${webCtx}';
  // 设置默认ajax请求失败处理方法
  $.ajaxSetup({
	  error: function(data, status, exception){
			var errorMsg = '';
			if(data && data.responseText){
				errorMsg = (eval('('+data.responseText+')')).string;
				$.messager.alert('错误信息', errorMsg, 'error');
			}
	  }
  });
  
  function getJsonErrorMsg(data){
		var errorMsg = '';
		if(data && data.responseText){
			errorMsg = (eval('('+data.responseText+')')).string;
		}
		return errorMsg;
	}
	

  var dateFormat = function() {
		var token = /d{1,4}|m{1,4}|yy(?:yy)?|([HhMsTt])\1?|[LloSZ]|"[^"]*"|'[^']*'/g, timezone = /\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g, timezoneClip = /[^-+\dA-Z]/g, pad = function(
				val, len) {
			val = String(val);
			len = len || 2;
			while (val.length < len)
				val = "0" + val;
			return val;
		};

		// Regexes and supporting functions are cached through closure
		return function(date, mask, utc) {
			var dF = dateFormat;

			// You can't provide utc if you skip other args (use the "UTC:" mask prefix)
			if (arguments.length == 1
					&& (typeof date == "string" || date instanceof String)
					&& !/\d/.test(date)) {
				mask = date;
				date = undefined;
			}

			// Passing date through Date applies Date.parse, if necessary
			date = date ? new Date(date) : new Date();
			if (isNaN(date))
				throw new SyntaxError("invalid date");

			mask = String(dF.masks[mask] || mask || dF.masks["default"]);

			// Allow setting the utc argument via the mask
			if (mask.slice(0, 4) == "UTC:") {
				mask = mask.slice(4);
				utc = true;
			}

			var _ = utc ? "getUTC" : "get", d = date[_ + "Date"](), D = date[_
					+ "Day"](), m = date[_ + "Month"](), y = date[_
					+ "FullYear"](), H = date[_ + "Hours"](), M = date[_
					+ "Minutes"](), s = date[_ + "Seconds"](), L = date[_
					+ "Milliseconds"](), o = utc ? 0 : date
					.getTimezoneOffset(), flags = {
				d : d,
				dd : pad(d),
				ddd : dF.i18n.dayNames[D],
				dddd : dF.i18n.dayNames[D + 7],
				m : m + 1,
				mm : pad(m + 1),
				mmm : dF.i18n.monthNames[m],
				mmmm : dF.i18n.monthNames[m + 12],
				yy : String(y).slice(2),
				yyyy : y,
				h : H % 12 || 12,
				hh : pad(H % 12 || 12),
				H : H,
				HH : pad(H),
				M : M,
				MM : pad(M),
				s : s,
				ss : pad(s),
				l : pad(L, 3),
				L : pad(L > 99 ? Math.round(L / 10) : L),
				t : H < 12 ? "a" : "p",
				tt : H < 12 ? "am" : "pm",
				T : H < 12 ? "A" : "P",
				TT : H < 12 ? "AM" : "PM",
				Z : utc ? "UTC" : (String(date).match(timezone) || [ "" ])
						.pop().replace(timezoneClip, ""),
				o : (o > 0 ? "-" : "+")
						+ pad(Math.floor(Math.abs(o) / 60) * 100
								+ Math.abs(o) % 60, 4),
				S : [ "th", "st", "nd", "rd" ][d % 10 > 3 ? 0 : (d % 100
						- d % 10 != 10)
						* d % 10]
			};

			return mask.replace(token,
					function($0) {
						return $0 in flags ? flags[$0] : $0.slice(1,
								$0.length - 1);
					});
		};
	}();

	// Some common format strings
	dateFormat.masks = {
		"default" : "ddd mmm dd yyyy HH:MM:ss",
		shortDate : "m/d/yy",
		mediumDate : "mmm d, yyyy",
		longDate : "mmmm d, yyyy",
		fullDate : "dddd, mmmm d, yyyy",
		shortTime : "h:MM TT",
		mediumTime : "h:MM:ss TT",
		longTime : "h:MM:ss TT Z",
		isoDate : "yyyy-mm-dd",
		isoTime : "HH:MM:ss",
		isoDateTime : "yyyy-mm-dd'T'HH:MM:ss",
		isoUtcDateTime : "UTC:yyyy-mm-dd'T'HH:MM:ss'Z'"
	};

	// Internationalization strings
	dateFormat.i18n = {
		dayNames : [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
				"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday" ],
		monthNames : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec", "January", "February",
				"March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" ]
	};
	// For convenience… 
	Date.prototype.format = function(mask, utc) {
		return dateFormat(this, mask, utc);
	};
	
	//jQuery有方法$.fn.serialize，可将表单序列化成字符串；有方法$.fn.serializeArray，可将表单序列化成数组。
	//如果需要其序列化为JSON对象，那么可以基于serializeArray编写方法serializeObject轻松实现：
	$.fn.serializeObject = function()    
	{    
	   var o = {};    
	   var a = this.serializeArray();    
	   $.each(a, function() {    
	       if (o[this.name]) {    
	           if (!o[this.name].push) {    
	               o[this.name] = [o[this.name]];    
	           }    
	           o[this.name].push(this.value || '');    
	       } else {    
	           o[this.name] = this.value || '';    
	       }    
	   });    
	   return JSON.stringify(o);    
	};  
	
	$.fn.easyuiTitle =function(){
		var opts = this.datagrid('getColumnFields'); //这是获取到所有的FIELD
		var colTitle=[];
		for(i=0;i<opts.length;i++)
		{
		var col = this.datagrid( "getColumnOption" , opts[i] );
		colTitle.push(col.title);//把TITLEPUSH到数组里去
		}
		return colTitle;
	}
	
	$.fn.easyuiField =function(){
		var opts = this.datagrid('getColumnFields'); //这是获取到所有的FIELD
		var colField=[];
		for(i=0;i<opts.length;i++)
		{
		var col = this.datagrid( "getColumnOption" , opts[i] );
		colField.push(col.field);
		}
		return colField;
	}
	
	function butDisabled(but){
    	but.attr({"disabled":"disabled"});
		but.css("background-color","#C0C0C0");
		but.css("border-color","#C0C0C0");
		but.html("<i class='am-icon-spinner am-icon-spin'></i>处理中");
    }
    
    function butEnabled(but , butHtml){
    	but.removeAttr("disabled");
    	but.css("background-color","#36A2D8");
    	but.css("border-color","#36A2D8");
    	but.html(butHtml);
    }
</script>
<script type="text/javascript" src="${ctx}/static/js/pub/common.js"></script>