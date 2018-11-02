if ($.fn.pagination) {
    $.fn.pagination.defaults.beforePageText = '第';
    $.fn.pagination.defaults.afterPageText = '共{pages}页';
    $.fn.pagination.defaults.displayMsg = '显示{from}到{to},共{total}记录';
}
if ($.fn.datagrid) {
    $.fn.datagrid.defaults.loadMsg = '正在处理，请稍待。。。';
}

if ($.fn.treegrid && $.fn.datagrid) {
    $.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}

if ($.messager) {
    $.messager.defaults.ok = '确定';
    $.messager.defaults.cancel = '取消';
}
if ($.fn.validatebox) {
    $.fn.validatebox.defaults.missingMessage = '该输入项为必输项';
    $.fn.validatebox.defaults.rules.email.message = '请输入有效的电子邮件地址';
    $.fn.validatebox.defaults.rules.url.message = '请输入有效的URL地址';
    $.fn.validatebox.defaults.rules.length.message = '输入内容长度必须介于{0}和{1}之间';
    $.fn.validatebox.defaults.rules.remote.message = '请修正该字段';
}
if ($.fn.numberbox) {
    $.fn.numberbox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combobox) {
    $.fn.combobox.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combotree) {
    $.fn.combotree.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.combogrid) {
    $.fn.combogrid.defaults.missingMessage = '该输入项为必输项';
}
if ($.fn.calendar) {
    $.fn.calendar.defaults.weeks = ['日', '一', '二', '三', '四', '五', '六'];
    $.fn.calendar.defaults.months = ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'];
}
if ($.fn.datebox) {
    $.fn.datebox.defaults.currentText = '今天';
    $.fn.datebox.defaults.closeText = '关闭';
    $.fn.datebox.defaults.okText = '确定';
    $.fn.datebox.defaults.missingMessage = '该输入项为必输项';
    $.fn.datebox.defaults.formatter = function (date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
    };
    $.fn.datebox.defaults.parser = function (s) {
        if (!s) return new Date();
        var ss = s.split('-');
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    };
}
if ($.fn.datetimebox && $.fn.datebox) {
    $.extend($.fn.datetimebox.defaults, {
        currentText: $.fn.datebox.defaults.currentText,
        closeText: $.fn.datebox.defaults.closeText,
        okText: $.fn.datebox.defaults.okText,
        missingMessage: $.fn.datebox.defaults.missingMessage
    });
}




var mapTypeI18n = [
    {id:0,text:"百度地图"}/*,
    {id:1,text:"Google地图"},
    {id:2,text:"高德地图"}*/
]

var globleI18n = new Object();
globleI18n.switchTheme = '切换主题风格';
globleI18n.ToConfirmTheOk = '您确定要进行该操作?';
globleI18n.homeTitle = '主页';
globleI18n.fullScreenError = '当前浏览器不支持全屏 API，请更换至最新的 Chrome/Firefox/Safari 浏览器或通过 F11 快捷键进行操作。';
globleI18n.info = '提示';
globleI18n.loading = '正在加载..';
globleI18n.setThemeInfo = '您设置的主题为';
globleI18n.setThemeInfo2 = '您设置了新的系统主题皮肤为';
globleI18n.createTab = '新建选项卡';
globleI18n.systemManager = '系统管理';
globleI18n.resourceManager = '资源管理';
globleI18n.reportManager = '报表管理';
globleI18n.isChoose = '--请选择--';
globleI18n.characterSetTitle = '个性设置';
globleI18n.vehicle = '车辆' ;
globleI18n.close = '关闭' ;
globleI18n.vehicleInfo = '车辆信息' ;
globleI18n.vehicleOwnerInfo = '车主信息' ;
globleI18n.individualWest_trackPlayback = '轨迹回放';
globleI18n.serviceExpires = '您有{0}辆车到期或即将到期';
globleI18n.individualWest_validateMobile = '输入的内容必须是移动电话号码(中国)格式.';
globleI18n.individualWest_notOnlineMonitoring =  ',不在线,不能作为重点监控对象.';
globleI18n.individualWest_notExpiredDateStateMonitoring =  ',服务已到期或未开通,不能作为重点监控对象.';
globleI18n.individualWest_notSelectVehicle = '请选择车辆进行查看.';
globleI18n.individualWest_parameterSetting = '参数设置';
globleI18n.individualWest_emphasisMonitoring = '重点监控';
globleI18n.dw = '定位';
globleI18n.cf = '撤防';
globleI18n.sf = '设防';
globleI18n.individualWest_serviceExpireSf =  ',服务已到期或未开通,不能下发设防指令.';
globleI18n.individualWest_serviceExpireCf =  ',服务已到期或未开通,不能下发撤防指令.';
globleI18n.individualWest_serviceExpiredw = ',服务已到期或未开通,不能下发定位指令.';
globleI18n.individualWest_serviceExpireElectronicFence = ' ,服务已到期或未开通,不能添加电子围栏.';
globleI18n.individualWest_serviceExpireSetting = ',服务已到期或未开通,不能作为控制对象.';
globleI18n.individualWest_notOnlineSf = ',不在线,不能下发设防指令.';
globleI18n.individualWest_notOnlineCf =  ',不在线,不能下发撤防指令.';
globleI18n.individualWest_notOnlinedw = ' ,不在线,不能下发定位指令.';
globleI18n.individualWest_notOnlineElectronicFence = ' ,不在线,不能添加电子围栏.';
globleI18n.individualWest_notOnlineSetting = ' ,不在线,不能作为控制对象.';
globleI18n.individualWest_restSetting = '其他设置';
globleI18n.individualWest_addElectronicFence = '添加电子围栏';
globleI18n.individualWest_selectVehicle = '请选择车辆进行操作.';
globleI18n.online_1 = '在线';
globleI18n.individualWest_dingweiMessage = "定期指令{0}已下发,请等待终端回复."
globleI18n.individualWest_digweiInfo = "定位消息";
globleI18n.individualWest_locationMessage = "车辆位置已更新.";
globleI18n.initBaidu_clear='清空';
globleI18n.initBaidu_reset='复位';
globleI18n.initBaidu_allContury='全国';
globleI18n.initBaidu_distince='测距';
globleI18n.initBaidu_big='放大';
globleI18n.initBaidu_small='缩小';
globleI18n.initBaidu_myView='我的视图';
globleI18n.initBaidu_China='中国';
globleI18n.initBaidu_confirmDialog='确认对话框';
globleI18n.initBaidu_isSaveMapStyle='您确认保存该地图设置吗？';
globleI18n.initBaidu_vehicleDetail='车辆信息：';
globleI18n.initBaidu_vehiclePlate='车牌号：';
globleI18n.initBaidu_SIM='卡号：';
globleI18n.initBaidu_LNG='经度：';
globleI18n.initBaidu_LAT='纬度：';
globleI18n.initBaidu_speed='速度：';
globleI18n.initBaidu_localTime='定位时间：';
globleI18n.initBaidu_address='地址：';
globleI18n.initBaidu_finshDraw='完成绘制';
globleI18n.initBaidu_cancelDraw='取消绘制';
globleI18n.initBaidu_drectionError='方向参数错误-';
globleI18n.initBaidu_smallNotice='按照对角拉框或直接单击，缩小地图,ESC取消操作';
globleI18n.initBaidu_bigNotice='按照对角拉框或直接单击，放大地图,ESC取消操作';
globleI18n.playBack_stratPoint='起点';
globleI18n.playBack_endPoint='终点';
globleI18n.playBack_T21_0='进区域告警';
globleI18n.playBack_T21_1='出区域告警';
globleI18n.playBack_T11='非法震动告警';
globleI18n.playBack_T12='断电告警';
globleI18n.playBack_T13='电池电量不足告警';
globleI18n.playBack_T14='越界告警';
globleI18n.playBack_T15='超速告警';
globleI18n.playBack_noAlarm='无';
globleI18n.playBack_alarmType='告警类型:';
globleI18n.isTestFlagError='该用户只是体验用户,不具备操作权限,如有需要联系客服.';
globleI18n.selectData='请先选择一行数据';
globleI18n.selectParameter='请传入有效的参数 id(菜单标识号)';
//add by hechuan----start----
 globleI18n.oldPasswordTips='请输入英文字母或数字组成的6-12位密码';
//add by hechuan----end----




var globleMapI18n = {};
globleMapI18n['addSuccess'] = '添加成功';
globleMapI18n['addError'] = '添加失败';
globleMapI18n['editSuccess'] = '编辑成功';
globleMapI18n['editError'] = '编辑失败';
globleMapI18n['deleteSuccess'] = '删除成功';
globleMapI18n['deleteError'] = '删除失败';
globleMapI18n['uploadSuccess'] = '上传成功';
globleMapI18n['uploadError'] = '上传失败';
globleMapI18n['importSuccess'] = '导入成功';
globleMapI18n['importError'] = '导入失败';
globleMapI18n['mapSetSuccess'] = '地图设置成功';
globleMapI18n['mapSetError'] = '地图设置失败';
globleMapI18n['mapSetSuccess'] = '地图设置成功';
globleMapI18n['updatePasswordSuccess'] = '密码更改成功';
globleMapI18n['updatePasswordFailed'] = '密码更改失败';
//add by hechuan at 20170512   ---start---
globleMapI18n['companyReferenced'] = '该公司被部门引用，不允许删除';
//add by hechuan at 20170512   ---end---

// 参数查询国际化
var downcommandQuery = new Object();
downcommandQuery['PSW'] = "终端密码";
downcommandQuery['PHONE'] = "终端SIM卡号";
downcommandQuery['USER'] = "车主手机号";
downcommandQuery['SPEED'] = "超速上限";
downcommandQuery['FREQ'] = "上报频率";
downcommandQuery['RADIUS'] = "车辆被移动的半径";
downcommandQuery['VIBS'] = "是否震动短信提醒";
downcommandQuery['VIBCALL'] = "震动呼叫提醒";
downcommandQuery['VIBL'] = "震动灵敏度";
downcommandQuery['VIBGPS'] = "是否开启GPS过滤";
downcommandQuery['POF'] = "断电和低电告警";
downcommandQuery['SOFTVERSION'] = "软件版本";
downcommandQuery['GSM'] = "GSM信号强度";
downcommandQuery['GPS'] = "卫星编号和强度";
downcommandQuery['VBAT'] = "电池电压";
downcommandQuery['SLEEP'] = "开启\\关闭休眠";
downcommandQuery['VIB'] = "是否震动告警短信提醒";
downcommandQuery['RADIUS'] = "越界告警半径";
downcommandQuery['POFR'] = "断电告警短信提醒";
downcommandQuery['POFL'] = "低电告警短信提醒";

// 参数查询提示信息国际化
var downcommandQueryMap = {};
downcommandQueryMap['PSW'] = "密码，可以修改终端密码，一般为6位数字；默认123456";
downcommandQueryMap['PHONE'] = "终端内SIM卡号码";
downcommandQueryMap['USER'] = "车主号码";
downcommandQueryMap['SPEED'] = "超速告警。当车辆车速大于设定值将上报超速告警信息,默认为60";
downcommandQueryMap['FREQ'] = "单位：秒；默认15秒；决定GPS定位信息的上报频率；";
downcommandQueryMap['RADIUS'] = "GPS围栏告警距离(米)";
downcommandQueryMap['VIBS'] = "非法移动告警短信，1表示开启，0表示关闭，默认为关闭状态";
downcommandQueryMap['VIBCALL'] = "震动呼叫功能，1表示每次振动会直接呼叫车主，0表示关闭振动拨打电话功能。前提是一定要设防。";
downcommandQueryMap['VIBL'] = "非法移动告警感应灵敏度0~15 , 0为最高灵敏度，15为最低灵敏度";
downcommandQueryMap['VIBGPS'] = "开启、关闭GPS过滤功能。如果为1，则在5分钟内未检测到振动，则进入静止状态，静止状态时过滤所有GPS漂移点,0则关闭";
downcommandQueryMap['POF'] = "断电和低电告警开关，1表示开启，0表示关闭，默认关闭";
downcommandQueryMap['SOFTVERSION'] = "终端软件版本号";
downcommandQueryMap['GSM'] = "GSM信号强度：0~100%";
downcommandQueryMap['GPS'] = "GPS接收的卫星编号和强度，例如：2300 1223 3431 。。。一共12组四位数，2300表示接收到编号23卫星信号强度为00 ，1223表示接收到编号为12的卫星信号强度为23";
downcommandQueryMap['VBAT'] = "电池电压，充电接口电压，充电电流大小VBAT=3713300：4960750：303500 表示电池电压为3713300uV，即3.71v，加到充电芯片上电压4.96V，充电电流303mA";
downcommandQueryMap['SLEEP'] = "休眠节电模式，如果为1，则防盗器在60分钟内没有发生振动，则进入休眠节电状态；一旦进入休眠模式可通过以下方式激活：（1）发生振动，（2）自动唤醒，（3）车主发送DW到终端,为0则关闭";
downcommandQueryMap['VIB'] = "异常震动告警短信提醒,1:开启，0:关闭;(默认关闭)";
downcommandQueryMap['RADIUS'] = "越界告警(设防状态下被移动)半径.";
downcommandQueryMap['POFR'] = "断电告警短信提醒，1:开启，0:关闭；(默认关闭)";
downcommandQueryMap['POFL'] = "低电告警短信提醒，1:开启，0:关闭；(默认关闭)";
downcommandQueryMap['terminalPwd'] = "1. 在左侧车辆列表树选择车辆。<br>2. 选择相应参数,进行查询。<br>3. 在操作日志面板查看相关日志。";


// 参数设置国际化
var downcommandSetting = new Object();
downcommandSetting['PSW'] = "设置终端密码";
downcommandSetting['SIM'] = "设置终端SIM卡号";
downcommandSetting['USER'] = "设置车主号码";
downcommandSetting['FREQ'] = "设置上报频率";
downcommandSetting['RADIUS'] = "设置非法移动报警判定范围";
downcommandSetting['VIBS'] = "设置是否开启震动短信报警";
downcommandSetting['VIBL'] = "设置震动灵敏度";
downcommandSetting['VIBCALL'] = "设置是否开启震动电话报警";
downcommandSetting['VIBGPS'] = "设置是否开启GPS过滤漂移功能";
downcommandSetting['POF'] = "设置是否开启断电报警功能";
downcommandSetting['SLEEP'] = "设置是否开启休眠功能";
downcommandSetting['SPEED'] = "设置超速报警限速值";
downcommandSetting['VIB'] = "设置是否震动告警短信提醒";
downcommandSetting['RADIUS'] = "设置越界告警半径";
downcommandSetting['POFR'] = "设置断电告警短信提醒";
downcommandSetting['POFL'] = "设置低电告警短信提醒";
downcommandSetting['SLEEPT'] = "自动休眠等待";
downcommandSetting['S7'] = "重启终端";
downcommandSetting['S8'] = "设防";
downcommandSetting['S9'] = "撤防";
downcommandSetting['S23'] = "恢复出厂设置";
downcommandSetting['T7'] = "重启终端";
downcommandSetting['T8'] = "设防";
downcommandSetting['T9'] = "撤防";
downcommandSetting['T23'] = "恢复出厂设置";
downcommandSetting['S4'] = "定位";


// 参数设置提示信息国际化
var downcommandSettingMap = {};
downcommandSettingMap['PSW'] = "<font style=\"font-weight: bold;\">示例值：123456</font><br>设置终端密码为6位数字且不能为空,如:123456";
downcommandSettingMap['SIM'] = "<font style=\"font-weight: bold;\">示例值：15601230123</font><br>设置终端内SIM卡号,不能为空,为常规手机号码.";
downcommandSettingMap['USER'] = "<font style=\"font-weight: bold;\">示例值：15601230123</font><br>设置车主手机号码,不能为空,为常规手机号码.";
downcommandSettingMap['FREQ'] = "<font style=\"font-weight: bold;\">示例值：15</font><br>单位：秒；默认15秒；决定GPS定位信息的上报频率";
downcommandSettingMap['RADIUS'] = "<font style=\"font-weight: bold;\">示例值：300</font><br>设置GPS围栏告警距离，>=300米";
downcommandSettingMap['VIBS'] = "<font style=\"font-weight: bold;\">示例值：1</font><br>设置非法移动告警短信，1表示开启，0表示关闭，默认为关闭状态";
downcommandSettingMap['VIBL'] = "<font style=\"font-weight: bold;\">示例值：15</font><br>设置非法移动告警感应灵敏度0~15 , 0为最高灵敏度，15为最低灵敏度";
downcommandSettingMap['VIBCALL'] = "<font style=\"font-weight: bold;\">示例值：0</font><br>设置震动呼叫功能，1表示每次振动会直接呼叫车主，0表示关闭振动拨打电话功能。前提是一定要设防。";
downcommandSettingMap['VIBGPS'] = "<font style=\"font-weight: bold;\">示例值：1</font><br>设置开启、关闭GPS过滤功能。如果为1，则在5分钟内未检测到振动，则进入静止状态，静止状态时过滤所有GPS漂移点,0则关闭";
downcommandSettingMap['POF'] = "<font style=\"font-weight: bold;\">示例值：1</font><br>设置断电和低电告警开关，1表示开启，0表示关闭，默认关闭";
downcommandSettingMap['SLEEP'] = "<font style=\"font-weight: bold;\">示例值：1</font><br>设置休眠节电模式，如果为1，则防盗器在60分钟内没有发生振动，则进入休眠节电状态；一旦进入休眠模式可通过以下方式激活：（1）发生振动，（2）自动唤醒，（3）车主发送DW到终端,为0则关闭";
downcommandSettingMap['SPEED'] = "<font style=\"font-weight: bold;\">示例值：60</font><br>超速告警。当车辆车速大于设定值将上报超速告警信息,默认为60";
downcommandSettingMap['VIB'] = "<font style=\"font-weight: bold;\">示例值：0</font><br>设置异常震动告警短信提醒,1:开启，0:关闭;(默认关闭)";
downcommandSettingMap['VIB'] = "<font style=\"font-weight: bold;\">示例值：60</font><br>设置越界告警(设防状态下被移动)半径,大于等于300米并且小于等于1000米；默认300米 ";
downcommandSettingMap['POFR'] = "<font style=\"font-weight: bold;\">示例值：0</font><br>设置断电告警短信提醒，1:开启，0:关闭；(默认关闭)";
downcommandSettingMap['POFL'] = "<font style=\"font-weight: bold;\">示例值：0</font><br>设置低电告警短信提醒，1:开启，0:关闭；(默认关闭)";
downcommandSettingMap['terminalPwd'] = "1. 在左侧车辆列表树选择车辆。<br>2. 选择参数名,设置对应的参数值。<br>3. 在操作日志面板查看相关日志。";
downcommandSettingMap['SLEEPT'] = "<font style=\"font-weight: bold;\">示例值：2</font><br>单位：分钟；默认2分钟；决定ACC断电后多长时间进入休眠；或休眠唤醒后工作多久重新进入休眠";

// 告警信息国际化
var warningInfoMap = {};
warningInfoMap["T11"] = "非法震动告警";
warningInfoMap["T12"] = "断电告警";
warningInfoMap["T13"] = "电池电量不足告警";
warningInfoMap["T14"] = "越界告警";
warningInfoMap["T15"] = "超速告警";
warningInfoMap["T21"] = "区域告警";
warningInfoMap["T21_0"] = "进区域告警";
warningInfoMap["T21_1"] = "出区域告警";
