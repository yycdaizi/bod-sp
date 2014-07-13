/**
 * easy ui 扩展
 * @author ying
 */

/**
 * 扩展验证类型
 */
(function($) {
	$.extend($.fn.validatebox.defaults.rules, {
		minLength : { // 判断最小长度
			validator : function(value, param) {
				return value.length >= param[0];
			},
			message : '最少输入{0}个字符。'
		},
		maxLength : {
			validator : function(value, param) {
				return value.length <= param[0];
			},
			message : '最多输入{0}个字符'
		},
		length:{validator:function(value,param){
			var len=$.trim(value).length;
				return len>=param[0]&&len<=param[1];
			},
				message:"内容长度介于{0}和{1}之间."
		},
		phone : {// 验证电话号码
			validator : function(value) {
				return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
			},
			message : '格式不正确,请使用下面格式:020-88888888'
		},
		mobile : {// 验证手机号码
			validator : function(value) {
				return /^(13|15|18)\d{9}$/i.test(value);
			},
			message : '手机号码格式不正确(正确格式如：13450774432)'
		},
		phoneOrMobile:{//验证手机或电话
			validator : function(value) {
				return /^(13|15|18)\d{9}$/i.test(value) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
			},
			message:'请填入手机或电话号码,如13688888888或020-8888888'
		},
		idcard : {// 验证身份证
			validator : function(value) {
				return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
			},
			message : '身份证号码格式不正确'
		},
		floatOrInt : {// 验证是否为小数或整数
			validator : function(value) {
				return /^(\d{1,3}(,\d\d\d)*(\.\d{1,3}(,\d\d\d)*)?|\d+(\.\d+))?$/i.test(value);
			},
			message : '请输入数字，并保证格式正确'
		},
		currency : {// 验证货币
			validator : function(value) {
				return /^d{0,}(\.\d+)?$/i.test(value);
			},
			message : '货币格式不正确'
		},
		integer : {// 验证整数
			validator : function(value) {
				return /^[+]?[1-9]+\d*$/i.test(value);
			},
			message : '请输入整数'
		},
		unnormal : {// 验证是否包含空格和非法字符
			validator : function(value) {
				return /.+/i.test(value);
			},
			message : '输入值不能为空和包含其他非法字符'
		},
		username : {// 验证用户名
			validator : function(value) {
				return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
			},
			message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
		},
		postalCode : {// 验证邮政编码
			validator : function(value) {
				return /^[1-9]\d{5}$/i.test(value);
			},
			message : '邮政编码格式不正确'
		},
		name : {// 验证姓名，可以是中文或英文
				validator : function(value) {
					return /^[\u0391-\uFFE5]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value);
				},
				message : '请输入姓名'
		},
		same:{
			validator : function(value, param){
				if($("#"+param[0]).val() != "" && value != ""){
					return $("#"+param[0]).val() == value; 
				}else{
					return true;
				}
			},
			message : '两次输入的密码不一致！'	
		}, 
		datebefore : {
			validator : function(value, param) {
				var max = $(param[0]).val();
				if (max && value) {
					return value < max;
				}
				return true;
			},
			message : '输入的时间必须在[{1}]之前'
		}, 
		dateafter : {
			validator : function(value, param) {
				var min = $(param[0]).val();
				if (min && value) {
					return value > min;
				}
				return true;
			},
			message : '输入的时间必须在[{1}]之后'
		}, 
		comboboxfixed : {
			validator : function(value, param) {
				//如果value为空，则验证通过
				if (!value) {
					return true;
				}
				var $target = $("#" + param[0]);
				var data = $target.combobox("getData");
				var options = $target.combobox("options");
				if (!options.multiple) {
					//单选
					for ( var i = 0; i < data.length; i++) {
						if (data[i][options.textField] == value) {
							return true;
						}
					}
				} else {
					//多选
					var valArray = value.split(options.separator);
					for ( var k = 0; k < valArray.length; k++) {
						var flag = false;
						for ( var i = 0; i < data.length; i++) {
							if (data[i][options.textField] == valArray[k]) {
								flag = true;
								break;
							}
						}
						if (!flag) {
							return false;
						}
					}
					return true;
				}
				return false;
			},
			message : '输入值必须在下拉选项中'
		}, 
		fixedin : {
			validator : function(value, param) {
				var dic = param[0];
				var validField = param[1];
				if (!(value && dic && validField)) {
					return true;
				}
				for ( var i = 0; i < dic.length; i++) {
					if (dic[i][validField] == value) {
						return true;
					}
				}
				return false;
			},
			message : '输入值必须在下拉选项中'
		}
	});
	
	/**
	 * 获得焦点和单击时自动出现下拉框
	 */
	$.extend($.fn.combobox.defaults.box, {
		onclick : function() {
			$(this).combobox('showPanel');
		}//,
	//onfocus:function(){
	//	$(this).combobox('showPanel');
	//}
	});
	
	/**
	 * 设置下拉框默认的过滤方法
	 */
	$.fn.combobox.defaults.filter = function(q, row) {
		var options = $(this).combobox("options");
		return row[options.textField].indexOf(q) >= 0;
	};
	/**
	 * 扩展表格编辑框
	 */
	$.extend($.fn.datagrid.defaults.editors, {
		my97 : {
			init : function(container, options) {
				var input = $('<input type="text"/>').appendTo(container);
				input.my97(options);
				return input;
			},
			destroy : function(target) {
				$(target).my97("destroy");
			},
			getValue : function(target) {
				return $(target).my97('getValue');
			},
			setValue : function(target, value) {
				$(target).my97('setValue', value);
			},
			resize : function(target, width) {
				$(target).my97('resize', width);
			}
		},
		autocompletebox : {
			init : function(container, options) {
				options = options || {};
				var input = $(
						'<input type="text" class="datagrid-editable-input" />')
						.appendTo(container);
				input.validatebox(options);
				var source = options["source"];
				input.autocomplete(source, options);
				var resultHandler = options["resultHandler"];
				if (resultHandler) {
					input.result(resultHandler);
				}
				return input;
			},
			destroy : function(target) {
				$(target).validatebox("destroy");
			},
			getValue : function(target) {
				return $(target).val();
			},
			setValue : function(target, value) {
				$(target).val(value);
			},
			resize : function(target, width) {
				var input = $(target);
				if ($.boxModel == true) {
					input.width(width - (input.outerWidth() - input.width()));
				} else {
					input.width(width);
				}
			}
		}
	});
	/**
	 * 扩展combobox方法
	 */
	$.extend($.fn.combobox.methods, {
		//验证表格中的所有行
		mappingText : function(jq, value) {
			var data = jq.combobox("getData");
			var options = jq.combobox("options");
			
			for ( var i = 0,len = data.length; i < len; i++) {
				if (data[i][options.valueField] == value) {
					return data[i][options.textField];
				}
			}
			return value;
		}
	});
	/**
	 * 扩展表格方法
	 */
	$.extend($.fn.datagrid.methods, {
		//验证表格中的所有行
		validateData : function(jq) {
			var $grid = $(jq[0]);
			var valid = true;
			for(var i=0;i<$grid.datagrid('getRows').length;i++){
				$grid.datagrid('beginEdit', i);
				if(!$grid.datagrid('validateRow', i)){
					valid = false;
				}else{
					$grid.datagrid('endEdit', i);
				}
			}
			return valid;
		}
	});
	
	/**
	 * 扩展Tabs方法
	 */
	$.extend($.fn.tabs.methods,{
		//更新tab页标题图片
		updateIcon : function(jq, param) {
			return jq.each(function() {
				var pp = $(this).tabs('getTab',param.title);
				var tab = pp.panel("options").tab;
				tab.find("span.tabs-icon").attr("class", "tabs-icon");
				if (param.iconCls) {
					tab.find("span.tabs-title").addClass("tabs-with-icon");
					tab.find("span.tabs-icon").addClass(param.iconCls);
				} else {
					tab.find("span.tabs-title").removeClass("tabs-with-icon");
				}
			});
		}
	});
	/**
	 * 更改easyui加载时的提示文字
	 * 
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 */
	$.extend($.fn.panel.defaults, {
		loadingMessage : '加载中....'
	});
	$.extend($.fn.datagrid.defaults, {
		loadMsg : '数据加载中....'
	});
	
	/**
	 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
	 * 
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 * 
	 */
	$.extend($.fn.panel.defaults, {
		onBeforeDestroy : function() {
			var frame = $('iframe', this);
			try {
				if (frame.length > 0) {
					for (var i = 0; i < frame.length; i++) {
						frame[i].src = '';
						frame[i].contentWindow.document.write('');
						frame[i].contentWindow.close();
					}
					frame.remove();
					if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
						try {
							CollectGarbage();
						} catch (e) {
						}
					}
				}
			} catch (e) {
			}
		}
	});
	/**
	 * 
	 * 通用错误提示
	 * 
	 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
	 * 
	 * @author 孙宇
	 * 
	 * @requires jQuery,EasyUI
	 */
	var onLoadErrorOption = {
		onLoadError : function(XMLHttpRequest) {
			if (parent.$ && parent.$.messager) {
				parent.$.messager.progress('close');
				parent.$.messager.alert('错误', XMLHttpRequest.responseText);
			} else {
				$.messager.progress('close');
				$.messager.alert('错误', XMLHttpRequest.responseText);
			}
		}
	};
	$.extend($.fn.datagrid.defaults, onLoadErrorOption);
	$.extend($.fn.treegrid.defaults, onLoadErrorOption);
	$.extend($.fn.tree.defaults, onLoadErrorOption);
	$.extend($.fn.combogrid.defaults, onLoadErrorOption);
	$.extend($.fn.combobox.defaults, onLoadErrorOption);
	$.extend($.fn.form.defaults, onLoadErrorOption);
	
	/**
	 * 等同于原form的load方法，但是这个方法支持{data:{name:''}}形式的对象赋值
	 */
	$.extend($.fn.form.methods, {
		loadData : function(jq, data) {
			return jq.each(function() {
				load(this, data);
			});
	
			function load(target, data) {
				if (!$.data(target, 'form')) {
					$.data(target, 'form', {
						options : $.extend({}, $.fn.form.defaults)
					});
				}
				var opts = $.data(target, 'form').options;
	
				if (typeof data == 'string') {
					var param = {};
					if (opts.onBeforeLoad.call(target, param) == false)
						return;
	
					$.ajax({
						url : data,
						data : param,
						dataType : 'json',
						success : function(data) {
							_load(data);
						},
						error : function() {
							opts.onLoadError.apply(target, arguments);
						}
					});
				} else {
					_load(data);
				}
				function _load(data) {
					var form = $(target);
					var formFields = form.find("input[name],select[name],textarea[name]");
					formFields.each(function() {
						var name = this.name;
						var value = jQuery.proxy(function() {
							try {
								return eval('this.' + name);
							} catch (e) {
								return "";
							}
						}, data)();
						var rr = _checkField(name, value);
						if (!rr.length) {
							var f = form.find("input[numberboxName=\"" + name + "\"]");
							if (f.length) {
								f.numberbox("setValue", value);
							} else {
								$("input[name=\"" + name + "\"]", form).val(value);
								$("textarea[name=\"" + name + "\"]", form).val(value);
								$("select[name=\"" + name + "\"]", form).val(value);
							}
						}
						_loadCombo(name, value);
					});
					opts.onLoadSuccess.call(target, data);
					$(target).form("validate");
				}
	
				function _checkField(name, val) {
					var rr = $(target).find('input[name="' + name + '"][type=radio], input[name="' + name + '"][type=checkbox]');
					rr._propAttr('checked', false);
					rr.each(function() {
						var f = $(this);
						if (f.val() == String(val) || $.inArray(f.val(), val) >= 0) {
							f._propAttr('checked', true);
						}
					});
					return rr;
				}
	
				function _loadCombo(name, val) {
					var form = $(target);
					var cc = [ 'combobox', 'combotree', 'combogrid', 'datetimebox', 'datebox', 'combo' ];
					var c = form.find('[comboName="' + name + '"]');
					if (c.length) {
						for (var i = 0; i < cc.length; i++) {
							var type = cc[i];
							if (c.hasClass(type + '-f')) {
								if (c[type]('options').multiple) {
									c[type]('setValues', val);
								} else {
									c[type]('setValue', val);
								}
								return;
							}
						}
					}
				}
			}
		}
	});
	
	/**
	 * 扩展jQuery实例方法-输入控件统一取值
	 */
	jQuery.fn.getValue = function(id) {
		var el = this;
		if (el.hasClass("easyui-combobox")) {
			if (el.combobox("options").multiple) {
				return el.combobox("getValues").join(",");
			} else {
				return el.combobox("getValue");
			}
		}
		return el.val();
	};
})(jQuery);