package com.grateful.demo.content.controller;

import com.grateful.demo.content.entity.User;
import com.grateful.demo.content.service.UserService;
import com.grateful.demo.frameWork.common.GridData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 分页查询
     * @return
     */
    @RequestMapping("listByPage")
    @ResponseBody
    public GridData listByPage(HttpServletRequest request){
        GridData<User> gridData = new GridData<User>();
        gridData.setTotal(1);
        List<User> roles = new ArrayList<>();
        roles.add(userService.findOne("EED2B89F-D466-11E8-A372-00FF043D0BB0"));
        gridData.setRows(roles);
        return gridData;
    }
}
