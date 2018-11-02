
//选择开始日期
function choiceStartDate(start, end) {
    start = $(start);
    end = $(end);
    if (start[0] && start.val() != "") {
        if (end[0] && end.val() != "") {
            var startTime = start.val();
            if (startTime.length === 7) {
                startTime += "-01";
            }
            var endTime = end.val();
            if (endTime.length === 7) {
                endTime += "-01";
            }
            if (Date.parse(startTime.replace("-", "/")) > Date.parse(endTime.replace("-", "/"))) {
                end.val(start.val());
            }
        }
    }
}

//选择开始时间
function choiceStartTime(start, end) {
    start = $(start);
    end = $(end);
    if (start[0] && start.val() != "") {
        if (end[0] && end.val() != "") {
            var startTime = start.val();
            var endTime = end.val();
            if (Date.parse(startTime) > Date.parse(endTime)) {
                end.val(start.val());
            }
        }
    }
}

//选择结束日期
function choiceEndDate(start, end) {
    start = $(start);
    end = $(end);
    if (end[0] && end.val() != "") {
        if(start[0] && start.val() != "") {
            var startTime = start.val();
            if (startTime.length === 7) {
                startTime += "-01";
            }
            var endTime = end.val();
            if (endTime.length === 7) {
                endTime += "-01";
            }
            if (Date.parse(startTime.replace("-", "/")) > Date.parse(endTime.replace("-", "/"))) {
                start.val(end.val());
            }
        }
    }
}

//选择结束时间
function choiceEndTime(start, end) {
    start = $(start);
    end = $(end);
    if (end[0] && end.val() != "") {
        if(start[0] && start.val() != "") {
            var startTime = start.val();
            var endTime = end.val();
            if (Date.parse(startTime) > Date.parse(endTime)) {
                start.val(end.val());
            }
        }
    }
}

/**
 * 获取国际化消息
 * 首先从全局国际化获取,如为空再从自定义国际化获取
 * @param key
 * @returns {*}
 */
function getI18nMsg(key){
    var msg = globleMapI18n[key];
    if($.string.isNullOrWhiteSpace(msg)){
        msg = $("#"+key).html();
    }
    return msg
}

function tenantComboSearch(tenantObj,accountTenantId){
    tenantObj.combobox({
        url: contextPath+"/tenantAction.do?method=getTenantComboList&tenantId="+accountTenantId,
        valueField : "tenantId",
        textField : "tenantName",
        autoShowPanel : false,
        panelHeight : 200,
        editable : false,
        onSelect : function(data){
            if($("#vehicleGroupId")[0]){
                vehicleGroupComboSearch($("#vehicleGroupId"),data.tenantId);
            }
        }
    });
}


function operationComboSearch(){
    $("#operationType").combobox({
        url: contextPath+"/logAction.do?method=getOperationTypeCombo",
        valueField : "operId",
        textField : "operName",
        autoShowPanel : false,
        panelHeight : 200,
        editable : false
    });
}


function vehicleGroupComboSearch(vahicleGroupObj,option){
    vahicleGroupObj.combotree({
        animate: true,
        lines: true,
        toggleOnClick: true,
        selectOnContextMenu: true,
        showOption: true,
        dataPlain: true,
        required : option.required,
        value : option.value,
        disabled : option.disabled,
        url: contextPath+"/vehicleGroupAction.do?method=getVehicleGroupTreeByTenanId&tenantId="+option.tenantId
    });
}

//终端厂商查询
function terminalManufactureIdComboSearch(terminalManufactureIdObj){
    terminalManufactureIdObj.combobox({
        url: contextPath+"/terminalAction.do?method=getTerminalManufactureNameComboList",
        valueField : "terminalManufactureId",
        textField : "terminalManufactureName",
        autoShowPanel : false,
        panelHeight : 150,
        editable : false,
        onSelect : function(data){
            if($("#terminalTypeId")[0]){
                terminalTypeNameComboSearch($("#terminalTypeId"),{terminalManufactureId:data.terminalManufactureId});
            }
        }
    });
}
//终端型号查询
function terminalTypeNameComboSearch(terminalTypeGroupObj,option){
    terminalTypeGroupObj.combobox({
        url: contextPath+"/terminalAction.do?method=getTerminalTypeNameComboList&terminalManufactureId="+option.terminalManufactureId,
        valueField : "terminalTypeId",
        textField : "terminalTypeName",
        autoShowPanel : false,
        panelHeight : 150,
        editable : false
    });
}

function departmentComboSearch(departmentObj,option){
    departmentObj.combobox({
        //从远程加载列表数据的 URL
        url: contextPath+"/departmentAction.do?method=getDepartmentComboByCondition",

        /*上面的url请求的数据中有：valueField属性的"departmentId"字段和textField属性的"departmentName"字段
          其中“departmentId”字段就绑定到下面这个valueField上，“departmentName”字段就绑定到下面这个textField上
          也即,对于<select>下拉框来说，valueField就相当于其<option>中的value；textField就相当于其<option>中的纯文本！！！
          <option value="1（这里是value）">这里是纯文本内容</option>
        */
        //绑定到该组合框（ComboBox）的 value 上的基础数据的名称
        valueField : "departmentId",
        //绑定到该组合框（ComboBox）的 text 上的基础数据的名称，显示在文本框中的文本字段
        textField : "departmentName",
        autoShowPanel : false,
        //下拉面板的高度
        panelHeight : 'auto',
        //定义用户是否可以往文本域中直接输入文字
        editable : false,
        //定义是否字段应被输入
        required : option.required,
        //字段的默认值，当程序运行后该下拉框中的内容就显示下面option.value这个默认值，当选择下拉框中的其他项时，这个默认值就被新读取的值覆盖，不再显示了！！
        value : option.value
    });
}

function subjectComboSearch(subjectObj,option){
    subjectObj.combobox({
        url: contextPath+"/subjectAction.do?method=getSubjectComboByCondition",
        valueField : "subjectId",
        textField : "subjectName",
        autoShowPanel : false,
        panelHeight : 'auto',
        multiple:true,
        editable : false,
        required : option.required,
        value : option.value,
        onSelect: function(rec){
            var val = $('#subjectId').combobox('getValues').join(',');
            $('#subjectIds').val(val);
        }
    });
}
function subjectSingleComboSearch(subjectSingleObj,option){
    subjectSingleObj.combobox({
        url: contextPath+"/subjectAction.do?method=getSubjectComboByCondition",
        valueField : "subjectId",
        textField : "subjectName",
        autoShowPanel : false,
        panelHeight : 'auto',
        multiple:false,
        editable : false,
        required : option.required,
        value : option.value
    });
}
function teacherComboSearch(teacherObj,option){
    teacherObj.combobox({
        url: contextPath+"/classesAction.do?method=getTeacherComboByCondition",
        valueField : "id",
        textField : "teacherName",
        autoShowPanel : false,
        panelHeight : 'auto',
        multiple:false,
        editable : false,
        required : option.required,
        value : option.value
    });
}
function assistantTeacherComboSearch(assistantTeacherObj,option){
    assistantTeacherObj.combobox({
        url: contextPath+"/classesAction.do?method=getAssistantTeacherComboByCondition",
        valueField : "id",
        textField : "teacherName",
        autoShowPanel : false,
        panelHeight : 'auto',
        multiple:false,
        editable : false,
        required : option.required,
        value : option.value
    });
}

function getSessionId() {
    var c_name = 'JSESSIONID';
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
}

function initDowncommandQuery(obj,data){
    obj.combobox({
        data: data,
        valueField : "id",
        textField : "text",
        autoShowPanel : false,
        panelHeight : 150,
        editable : false,
        onSelect: function(data){
            if($("#downcommandQueryMessage")[0]){
                $("#downcommandQueryMessage").html(downcommandQueryMap[data.id]);
            }
        }
    });
}

function initDowncommandSetting(obj,data){
    obj.combobox({
        data: data,
        valueField : "id",
        textField : "text",
        autoShowPanel : false,
        panelHeight : 150,
        editable : false,
        onSelect: function(data){
            if($("#downcommandSettingMessage")[0]){
                $("#downcommandSettingMessage").html(downcommandSettingMap[data.id]);
                $("#downcommandSettingValue").val();
            }
        }
    });
}




/**
 * 根据时间格式得到指定的当前的时间
 *
 // 日期格式化
 // 格式 YYYY/yyyy/YY/yy 表示年份
 // MM/M 月份
 // W/w 星期
 // dd/DD/d/D 日期
 // hh/HH/h/H 时间
 // mm/m 分钟
 // ss/SS/s/S 秒
 * @param formatStr
 * @returns {*}
 */
function getFormatTime(formatStr)
{
    var date = new Date();
    var str = formatStr;
    var Week = ['日','一','二','三','四','五','六'];

    str=str.replace(/yyyy|YYYY/,date.getFullYear());
    str=str.replace(/yy|YY/,(date.getYear() % 100)>9?(date.getYear() % 100).toString():'0' + (date.getYear() % 100));

    str=str.replace(/MM/,(date.getMonth()+1)>9?date.getMonth()+1:'0' + (date.getMonth()+1));
    str=str.replace(/M/g,date.getMonth()+1);

    str=str.replace(/w|W/g,Week[date.getDay()]);

    str=str.replace(/dd|DD/,date.getDate()>9?date.getDate().toString():'0' + date.getDate());
    str=str.replace(/d|D/g,date.getDate());

    str=str.replace(/hh|HH/,date.getHours()>9?date.getHours().toString():'0' + date.getHours());
    str=str.replace(/h|H/g,date.getHours());
    str=str.replace(/mm/,date.getMinutes()>9?date.getMinutes().toString():'0' + date.getMinutes());
    str=str.replace(/m/g,date.getMinutes());

    str=str.replace(/ss|SS/,date.getSeconds()>9?date.getSeconds().toString():'0' + date.getSeconds());
    str=str.replace(/s|S/g,date.getSeconds());

    return str;
}

function getFront(mainStr,searchStr){
    foundOffset=mainStr.indexOf(searchStr);
    if(foundOffset==-1){
        return null;
    }
    return mainStr.substring(0,foundOffset);
}

function getEnd(mainStr,searchStr){
    foundOffset=mainStr.indexOf(searchStr);
    if(foundOffset==-1){
        return null;
    }
    return mainStr.substring(foundOffset+searchStr.length,mainStr.length);
}

function replaceString(mainStr,searchStr,replaceStr){
    var front=getFront(mainStr,searchStr);
    var end=getEnd(mainStr,searchStr);
    if(front!=null && end!=null){
        return front+replaceStr+end;
    }
    return null;
}

function deleteString(mainStr,deleteStr){
    if(mainStr == deleteStr){
        return "";
    }
    return replaceString(mainStr,deleteStr,"");
}

