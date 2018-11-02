/**
 * datagrid的默认参数设置
 
$.extend($.fn.datagrid.options, {
	fitColumns : true,  //设置为true将自动使列适应表格宽度以防止出现水平滚动。
	method : 'post',    //请求远程数据的方法类型。
	nowrap : false,
	pageNumber : 1, //当设置分页属性时，初始化分页码。
	pageSize : 10,  //当设置分页属性时，初始化每页记录数。
	pageList : [10,20,30,40,50]
	//footer的数据处理
});

*/
/**
 * combobox联想忽略大小写
 * q是你输入的值，row是数据集合
 
$.fn.combobox.defaults.filter = function(q, row){
	//alert(row.length);
	if($(this).combobox('options') != null){
		var opts = $(this).combobox('options');
		if(row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) > -1){
			return true;
		}else{
			//$(this).combobox('clear');
			return false;
 }
	    // 同一转换成小写做比较，==0匹配首位，>=0匹配所有
	}
	return row;
};

$.fn.combobox.defaults.filter = $.fn.combobox.defaults.filter;*/

/**
 * combobox失去焦点时过滤，当输入与下拉列表完全匹配，当输入不匹配则清空输入框
 */
//$.fn.combobox.defaults.onHidePanel = function(){
//	var inputV = $(this).combobox('getText');
//    var datas = $(this).combobox('getData');
//    var opts = $(this).combobox('options');
//    var size = datas.length;
//    //当下拉列表为空时，清除输入项
//    if(inputV == ""||size == 0){
//    	$(this).combobox('clear');
//        return;
//    }else{
//        for(var i = 0;i < size; i++){
//        	var value = eval('datas[i].'+opts.textField);
//            if(value.toLowerCase() == inputV.toLowerCase()){
//                return true;
//            }
//        }
//        $(this).combobox('clear');
//    }
//	return ;
//};
//$.fn.combobox.defaults.onHidePanel = $.fn.combobox.defaults.onHidePanel;



/**var clickState = 0;
var formOnSubmit = function(none){
	if(clickState == 1){
		parent.$.messager.alert('<spring:message code="error"/>', "请勿重复提交数据.", 'error', function(){
			return false;
		});
	}else{
		return true;
	}
};

var fromSuccess = function(data){
	if(data.success){
		clickState = 1;
	}
};
$.fn.form.defaults.onSubmit = formOnSubmit;
$.fn.form.defaults.success = fromSuccess;
*/

/**
 * 扩展方法,datagrid的rows为0时,提示信息
 */
var myview = $.extend({},$.fn.datagrid.defaults.view,{
	onAfterRender:function(target){
		$.fn.datagrid.defaults.view.onAfterRender.call(this,target);
		var opts = $(target).datagrid('options');
		var vc = $(target).datagrid('getPanel').children('div.datagrid-view');
		vc.children('div.datagrid-empty').remove();
		if (!$(target).datagrid('getRows').length){
			var d = $('<div class="datagrid-empty"></div>').html(opts.emptyMsg || 'no records').appendTo(vc);
			d.css({
				position:'absolute',
				left:0,
				top:50,
				width:'100%',
				textAlign:'center'
			});
		}
	}
});

/**
 * combobox默认参数设置
 */
$.extend($.fn.combobox.defaults, {
    width: 161,
    height : 25
});

/**
 * combotree默认参数设置
 */
$.extend($.fn.combotree.defaults, {
    width: 161,
    height : 25
});

/**
 *  easyui-validetebox验证扩展
 */
//$.extend($.fn.validatebox.defaults.rules, {
//    valideRepeat: {
//        validator: function(value,param){
//            //['url','moduleName','eid','errorMessage']
//            var postdata = {}
//            postdata[param[1]] = value;
//            $.string.isNullOrWhiteSpace(param[2])?"":postdata["eid"] = $("#"+param[2]).val();
//            var result = $.util.requestAjaxData(param[0],postdata);
//            if(parseInt(result) > 0){
//                $.easyui.messager.show({ icon: "warning", msg: param[3] });
//                return false;
//
//            }else{
//                return true;
//            }
//        },
//        message: ''
//    },
//    valideTerminal: {
//        validator: function(value,param){
//            //['url','moduleName','eid','errorMessage']
//            var postdata = {}
//            postdata[param[1]] = value;
//            $.string.isNullOrWhiteSpace(param[2])?"":postdata["eid"] = $("#"+param[2]).val();
//            var result = $.util.requestAjaxData(param[0],postdata);
//            if(parseInt(result) > 0){
//                $.fn.validatebox.defaults.rules.valideRepeat.message = param[3];
//                return false;
//
//            }else{
//                return true;
//            }
//        },
//        message: ''
//    },
//    vehicleValideTerminal: {
//        validator: function(value,param){
//            if(value.length == 16){
//                var serialNo = $("#serialNo").val();
//                var vehicleId = $("#vehicleId").val();
//                var oldTerminalId = $("#oldTerminalId").val();
//                var result = $.util.requestAjaxJson(contextPath+"/vehicleAction.do?method=getTerminalBySerialNo",{serialNo:serialNo});
//                if( !$.string.isNullOrWhiteSpace(result) && result != null && result != "{}" && result != "[]"){
//                    if($.util.equals(result.terminalId,oldTerminalId)){
//                        return true;
//                    }else{
//                        if($.util.equals(result.bindStatus,0)){
//                            $("#terminalId").val(result.terminalId);
//                            return true;
//                        }else{
//                            $.fn.validatebox.defaults.rules.vehicleValideTerminal.message = getI18nMsg("terminalIsBundInput");
//                            return false;
//                        }
//                    }
//                }else{
//                    $.fn.validatebox.defaults.rules.vehicleValideTerminal.message = getI18nMsg("terminalNotFund");
//                    return false;
//                }
//            }else{
//                $.fn.validatebox.defaults.rules.vehicleValideTerminal.message = getI18nMsg("terminalNumberLengthError");
//                return false;
//            }
//
//        },
//        message: ''
//    },
//    vehicleValideVehicleOwner: {
//        validator: function(value,param){
//            if($.string.isMobile(value)){
//                var mobile = $("#mobile").val();
//                var result = $.util.requestAjaxJson(contextPath+"/vehicleAction.do?method=getVehicleOwnerByMobile",{mobile:mobile});
//                if( !$.string.isNullOrWhiteSpace(result) && result != null && result != "{}" && result != "[]"){
//                    $("#vehicleOwnerId").val(result.vehicleOwnerId);
//                    return true;
//                }else{
//                    $.fn.validatebox.defaults.rules.vehicleValideVehicleOwner.message = getI18nMsg("vehicleOwnerNotFund");
//                    return false;
//                }
//            }else{
//                $.fn.validatebox.defaults.rules.vehicleValideVehicleOwner.message = getI18nMsg("mobileError");
//                return false;
//            }
//        },
//        message: ''
//    }
//
//});

function defaultShowToolTip(obj) {
    obj.tooltip({
        content: $.fn.validatebox.defaults.missingMessage,
        showDelay: 0,
        hideDelay: 0,
        position: 'bottom',
        onShow: function () {
            $(this).tooltip('tip').css({
                color: "#000", borderColor: "#CC9933", backgroundColor: "#FFFFCC"
            });
        }
    })
}
