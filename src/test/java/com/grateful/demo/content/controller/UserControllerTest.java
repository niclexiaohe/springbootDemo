package com.grateful.demo.content.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.grateful.demo.BaseJunit;
import com.grateful.demo.content.entity.User;
import com.grateful.demo.content.enums.SexEnum;
import com.grateful.demo.content.service.UserService;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.frameWork.utils.IdGenerator;
import com.grateful.demo.frameWork.utils.MD5Encrypt;
import com.grateful.demo.frameWork.utils.json.JacksonUtil;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

public class UserControllerTest extends BaseJunit {

    @Autowired
    private UserService userService;

    /**
     * 获取一条数据
     */
    @Test
    public void findOne() {
        User user = userService.findOne("E993D1DC-D734-11E8-BC14-00FF043D0BB0");
//        User user = new User();
//        user.setId("1111");
//        user.setAccountName("何川");
//        user.setSex(SexEnum.Female);
        String json = JacksonUtil.obj2json(user);
        System.out.println("11=" + json);
    }

    /**
     * 根据账户名获取一个用户
     */
    @Test
    public void findByAccountName(){
        User user = userService.findByAccountName("hechuan");
        System.out.println("user=" + user);
    }

    @Test
    public void insert(){
        User user = new User();
//        user.setId("EED2B89F-D466-11E8-A372-00FF043D0BB0");
        user.setAccountName("hechuan88");
        user.setUserName("何川22");
        user.setPassword(MD5Encrypt.getMD5("123456"));
        user.setSex(SexEnum.UnKnown);
        OperateResultWithData resultWithData = userService.save(user);
        System.out.println("保持结果为：" + resultWithData);
    }
}