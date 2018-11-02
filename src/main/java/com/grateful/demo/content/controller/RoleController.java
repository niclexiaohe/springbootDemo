package com.grateful.demo.content.controller;

import com.grateful.demo.content.entity.Role;
import com.grateful.demo.content.service.RoleService;
import com.grateful.demo.frameWork.common.BaseController;
import com.grateful.demo.frameWork.common.Search;
import com.grateful.demo.frameWork.common.GridData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC: 角色controller
 * USER: C.HE
 * DATE: 2018/10/22 20:36
 * VERSION: 0.0.1
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 跳转到RoleView.html
     * @return
     */
    @RequestMapping("initList")
    public String initList(){
        return "RoleView";
    }


    /**
     * 分页查询
     * @return
     */
    @RequestMapping("listByPage")
    @ResponseBody
    public GridData listByPage(HttpServletRequest request){
        Search search = getParamsAsSearch(request);
        List<Role> roles = roleService.listByCondition(search);
        Integer total = roleService.countByCondition(search);
        GridData<Role> gridData = new GridData<Role>();
        gridData.setTotal(total);
        gridData.setRows(roles);
        return gridData;
    }
}
