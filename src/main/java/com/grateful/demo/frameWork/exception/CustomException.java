package com.grateful.demo.frameWork.exception;

/**
 * DESC: 自定义异常
 * USER: C.HE
 * DATE: 2018/10/9 10:23
 * VERSION: 0.0.1
 */
public class CustomException extends RuntimeException {

    /**
     * 异常信息中指定id
     */
    private String id;

    /**
     * 自定义异常构造方法
     * @param message
     */
    public CustomException(String message) {
        super(message);
        this.id = "123124";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
