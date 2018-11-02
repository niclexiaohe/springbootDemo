package com.grateful.demo.frameWork.annotations;

import java.lang.annotation.*;
/**
 * DESC: 用于枚举属性的备注数据
 * USER: C.HE
 * DATE: 2018/10/23 15:06
 * VERSION: 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE })
public @interface Remark {
    /**
     * @return 简要注解说明
     */
    String value();
    /**
     * @return 排序
     */
    int rank() default 0;
    /**
     * @return 注释说明：用于描述代码内部用法说明，一般不用于业务
     */
    String comments() default "";
}

