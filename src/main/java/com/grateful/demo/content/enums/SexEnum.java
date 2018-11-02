package com.grateful.demo.content.enums;

import com.grateful.demo.frameWork.annotations.Remark;

/**
 * DESC: 性别枚举
 * USER: C.HE
 * DATE: 2018/10/15 21:55
 * VERSION: 0.0.1
 */
public enum SexEnum{

    @Remark("男")
    Male,

    @Remark("女")
    Female,

    @Remark("未知")
    UnKnown;
}
