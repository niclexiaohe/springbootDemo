package com.grateful.demo.frameWork.exception;

import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.content.enums.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DESC: 统一异常处理----自定义异常捕获
 *       接口访问：这种方式捕捉的异常一般为接口方式访问时出现的500内部服务异常。
 *       浏览器访问：对于页面访问时404和500异常，直接通过别的方式转到404.html和500.html页面。
 *
 * USER: C.HE
 * DATE: 2018/10/9 10:26
 * VERSION: 0.0.1
 */

//这个注解是指这个类是处理其他controller抛出的异常
@ControllerAdvice
public class CustomExceptionHandler {

    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(value = CustomException.class)
    //将返回的值转成json格式的数据
    @ResponseBody
    //返回的状态码
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)     //服务内部错误
    public OperateResultWithData handlerCustomException(CustomException e){
        OperateResultWithData operateResultWithData = new OperateResultWithData();
        operateResultWithData.setCode(500);
        operateResultWithData.setStatus(StatusEnum.Fail);
        operateResultWithData.setMessage(e.getMessage());
        operateResultWithData.setData(null);
        return operateResultWithData;
    }
}
