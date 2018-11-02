package com.grateful.demo.content.controller;

import com.grateful.demo.content.entity.Module;
import com.grateful.demo.content.entity.User;
import com.grateful.demo.content.service.ModuleService;
import com.grateful.demo.content.service.UserService;
import com.grateful.demo.frameWork.common.GridData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能项Controller
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;
}
