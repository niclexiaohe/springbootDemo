package com.grateful.demo.frameWork.common;

import com.grateful.demo.content.enums.StatusEnum;

/**
 * DESC: response返回标准实体
 * USER: C.HE
 * DATE: 2018/10/3 11:19
 * VERSION: 0.0.1
 */
public class OperateResultWithData {

    private  Integer code;//返回结果代码
    private StatusEnum status;
    private  String message;//返回结果消息
    private  Object data;//返回结果数据


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

//    public OperateResultWithData putDataValue(String key, Object value) {
//        data.put(key, value);
//        return this;
//    }

    /**
     * 无参构造方法
     */
    public OperateResultWithData() {
    }

    /**
     * 带参构造方法
     * @param code
     * @param message
     */
    private OperateResultWithData(int code,StatusEnum status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }


    public static OperateResultWithData operationSuccess() {
        return new OperateResultWithData(200,StatusEnum.Success, "操作成功");
    }

    public static OperateResultWithData operationSuccess(String message) {
        return new OperateResultWithData(200,StatusEnum.Success, message);
    }

    public static OperateResultWithData operationFailure() {
        return new OperateResultWithData(200,StatusEnum.Fail, "操作失败");
    }

    public static OperateResultWithData operationFailure(String message) {
        return new OperateResultWithData(200,StatusEnum.Fail, message);
    }

    public static OperateResultWithData notFound() {
        return new OperateResultWithData(404,StatusEnum.Fail, "Not Found");
    }

    public static OperateResultWithData badRequest() {
        return new OperateResultWithData(400,StatusEnum.Fail, "Bad Request");
    }

    public static OperateResultWithData forbidden() {
        return new OperateResultWithData(403,StatusEnum.Fail, "Forbidden");
    }

    public static OperateResultWithData unauthorized() {
        return new OperateResultWithData(401,StatusEnum.Fail, "unauthorized");
    }

    public static OperateResultWithData serverInternalError() {
        return new OperateResultWithData(500,StatusEnum.Fail, "Server Internal Error");
    }

    public static OperateResultWithData customerError() {
        return new OperateResultWithData(1001,StatusEnum.Fail, "customer Error");
    }

    @Override
    public String toString() {
        return "OperateResultWithData{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
