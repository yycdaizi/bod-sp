/* Simple JavaScript Inheritance
 * By John Resig http://ejohn.org/
 * MIT Licensed.
 */
// Inspired by base2 and Prototype
(function(){
  var initializing = false, fnTest = /xyz/.test(function(){xyz;}) ? /\b_super\b/ : /.*/;
 
  // The base Class implementation (does nothing)
  this.Class = function(){};
 
  // Create a new Class that inherits from this class
  Class.extend = function(prop, statics) {
    var _super = this.prototype;
   
    // Instantiate a base class (but only create the instance,
    // don't run the init constructor)
    initializing = true;
    var prototype = new this();
    initializing = false;
   
    // Copy the properties over onto the new prototype
    for (var name in prop) {
      // Check if we're overwriting an existing function
      prototype[name] = typeof prop[name] == "function" &&
        typeof _super[name] == "function" && fnTest.test(prop[name]) ?
        (function(name, fn){
          return function() {
            var tmp = this._super;
           
            // Add a new ._super() method that is the same method
            // but on the super-class
            this._super = _super[name];
           
            // The method only need to be bound temporarily, so we
            // remove it when we're done executing
            var ret = fn.apply(this, arguments);        
            this._super = tmp;
           
            return ret;
          };
        })(name, prop[name]) :
        prop[name];
    }
   
    // The dummy class constructor
    function Class() {
      // All construction is actually done in the init method
      if ( !initializing && this.init )
        this.init.apply(this, arguments);
    }
   
    // Populate our constructed prototype object
    Class.prototype = prototype;
   
    // Enforce the constructor to be what we expect
    Class.prototype.constructor = Class;
 
    // And make this class extendable
    //Class.extend = arguments.callee; //this.extend;
   
    //我的扩展，继承静态属性
    for(var key in this){
    	if(this.hasOwnProperty(key)){
    		Class[key] = this[key];
    	}
    }
    for(var key in statics){
    	if(statics.hasOwnProperty(key)){
    		Class[key] = statics[key];
    	}
    }
    return Class;
  };
})();

/**
 * 数组深度复制
 * @returns
 */
Array.prototype.clone = function() {
	return $.extend(true, new Array(), this);
};

/**
 * 修改autocomplete的默认配置
 */
(function($) {
	if($&&$.Autocompleter){
	    $.Autocompleter.defaults = {
	        inputClass: "ac_input",
	        resultsClass: "ac_results",
	        loadingClass: "ac_loading",
	        minChars: 1,
	        delay: 400,
	        matchCase: false,
	        matchSubset: true,
	        matchContains: false,
	        cacheLength: 30,
	        max: 30,
	        mustMatch: false,
	        extraParams: {},
	        selectFirst: true,
	        formatItem: function(row) { return row[0]; },
	        formatMatch: null,
	        autoFill: false,
	        width: 0,
	        multiple: false,
	        multipleSeparator: ",",
	        highlight: function(value, term) {
	            return value.replace(new RegExp("(?![^&;]+;)(?!<[^<>]*)(" + term.replace(/([\^\$\(\)\[\]\{\}\*\.\+\?\|\\])/gi, "\\$1") + ")(?![^<>]*>)(?![^&;]+;)", "gi"), "<strong style='color:#FF6100'>$1</strong>");
	        },
	        scroll: true,
	        scrollHeight: 180
	    };
	}
})(jQuery);

var app = app || {};

app.showMsg = function(title, msg, options){
	options = options||{};
	options.title = title;
	options.msg = msg;
	top.jQuery.messager.show(options);
};

app.showInfo = function(msg, options){
	app.showMsg('提示', msg, options);
};

app.showError = function(msg, options){
	app.showMsg('错误', msg, options);
};

app.alert = function(title, msg, icon, fn){
	top.jQuery.messager.alert(title, msg, icon, fn);
};

app.alertInfo = function(msg, fn){
	app.alert('提示', msg, 'info', fn);
};

app.alertError = function(msg, fn){
	app.alert('错误', msg, 'error', fn);
};

app.confirm = function(title, msg, fn){
	top.jQuery.messager.confirm(title, msg, fn);
};

app.prompt = function(title, msg, fn){
	top.jQuery.messager.prompt(title, msg, fn);
};

app.showProgress = function(options){
	jQuery.messager.progress(options);
};

app.hideProgress = function(){
	jQuery.messager.progress('close');
};

/**
 * 创建一个模式化的dialog
 * 
 * @requires jQuery,EasyUI
 * 
 */
app.modalDialog = function(options) {
	var opts = $.extend({
		title : '&nbsp;',
		width : 640,
		height : 480,
		modal : true,
		onClose : function() {
			$(this).dialog('destroy');
		}
	}, options);
	opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
	if (options.url) {
		opts.content = '<iframe id="" src="' + options.url + '" allowTransparency="true" scrolling="auto" width="100%" height="99.5%" frameBorder="0" name="" style="overflow:hidden"></iframe>';
	}
	return $('<div/>').dialog(opts);
};

app.hideParentWindow = function(){
	parent.$('iframe').each(function(i){
		if(this.contentWindow === self){
			parent.$(this).closest('.window-body').window('close');
			return false;
		}
	});
};

app.postJSON = function(url, data, success, async){
	if ( jQuery.isFunction( data ) ) {
		async = success;
		success = data;
		data = undefined;
	}
	if(typeof async === 'undefined'){
		async = true;
	}

	return jQuery.ajax({
		type: 'POST',
		async: async,
		url: url,
		data: data,
		success: function(data){
			if(data.exception){
				jQuery.messager.alert('系统错误',data.exception.message,'error');
				jQuery.messager.progress('close');
				app.hideProgress();
			}else{
				if(success){
					success(data);
				}
			}
		},
		dataType: 'json'
	});
};

/**
 * 格式化字符串
 * 使用方法：formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量',...);
 * @returns 格式化后的字符串
 */
app.formatString = function(str){
	for ( var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

/**
 * 表格行中的操作按钮和分隔符
 */
app.operateButton = function(iconCls,text,clickFn){
	var template='<span class="operate-btn" onclick="{2}"><span class="operate-icon {0}">{1}</span></span>';
	//var template = '&nbsp;<img src="{0}" onclick="{1}" style="cursor: pointer;"/>&nbsp;';
	return app.formatString(template,iconCls,text,clickFn);
};
app.operateSplit = '<span class="operate-btn-separator"></span>';

/**
 * 计算年龄
 * @param birth 生日
 * @param dudate 计算日期
 * @returns
 */
app.getAge = function(birth, dudate) {
	var returnAge = -1;
	var duYear = dudate.getFullYear();
	var duMonth = dudate.getMonth() + 1;
	var duDay = dudate.getDate();
	if (!birth) {
		return returnAge;
	}
	birthYear = birth.getFullYear();
	birthMonth = birth.getMonth() + 1;
	birthDay = birth.getDate();

	if (duYear == birthYear) {
		returnAge = 0;
		if (duMonth < birthMonth) {
			returnAge = -1;//同年 则为0岁
		}
		if (duMonth == birthMonth && duDay < birthDay) {
			returnAge = -1;
		}
	} else {
		var ageDiff = duYear - birthYear; //年之差
		if (ageDiff > 0) {
			if (duMonth == birthMonth) {
				var dayDiff = duDay - birthDay;//日之差
				if (dayDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			} else {
				var monthDiff = duMonth - birthMonth;//月之差
				if (monthDiff < 0) {
					returnAge = ageDiff - 1;
				} else {
					returnAge = ageDiff;
				}
			}
		} else {
			returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
		}
	}

	return returnAge; //返回周岁年龄
};