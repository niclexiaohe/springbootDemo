package com.grateful.demo.content.controller;

import com.grateful.demo.content.entity.Authority;
import com.grateful.demo.content.entity.Menu;
import com.grateful.demo.content.entity.Role;
import com.grateful.demo.content.entity.User;
import com.grateful.demo.content.service.AuthorityService;
import com.grateful.demo.content.service.ModuleService;
import com.grateful.demo.content.service.RoleService;
import com.grateful.demo.content.service.UserService;
import com.grateful.demo.frameWork.annotations.IgnoreAuthCheck;
import com.grateful.demo.frameWork.common.OperateResultWithData;
import com.grateful.demo.content.enums.StatusEnum;
import com.grateful.demo.frameWork.utils.IdGenerator;
import com.grateful.demo.frameWork.utils.JwtTokenUtil;
import com.grateful.demo.frameWork.utils.MD5Encrypt;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * DESC: 登陆控制器
 * USER: C.HE
 * DATE: 2018/10/9 13:14
 * VERSION: 0.0.1
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 登陆账号
     * @param accountName 输入的账号
     * @param password 输入的密码
     * @param request
     * @param response
     * @return
     */
    @PostMapping("doLogin")
    @IgnoreAuthCheck
    @ResponseBody
    public OperateResultWithData doLogin(String accountName, String password, HttpServletRequest request, HttpServletResponse response){
        //根据accountName到数据库中查找有没有记录
        OperateResultWithData resultWithData = new OperateResultWithData();
        User user = userService.findByAccountName(accountName);
        System.out.println(user);

        if(Objects.isNull(user)){
            resultWithData.setStatus(StatusEnum.Fail);
            resultWithData.setMessage("账号错误！");
            return resultWithData;
        }
        if(!MD5Encrypt.getMD5(password).equals(user.getPassword())){
            resultWithData.setStatus(StatusEnum.Fail);
            resultWithData.setMessage("密码错误！");
            return resultWithData;
        }
        resultWithData.setStatus(StatusEnum.Success);
        resultWithData.setMessage("登陆成功！");
        resultWithData.setData(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put("appId", "appId");
        claims.put("tenant", "tenant");
        claims.put("account", "account");
        claims.put("userId", "userId");
        claims.put("userName", "userName");
        claims.put("userType", "userType");
        claims.put("email", "email");
        claims.put("authorityPolicy", "authorityPolicy");
        claims.put("ip", "ip");

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.generateToken(user.getAccountName(), IdGenerator.uuid(), claims);
        System.out.println("Token: " + token);

        //将token保存到cookie中，并将cookie添加到response中
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        return resultWithData;

//        Map<String, Object> claims = new HashMap<>();
//        claims.put("appId", "appId");
//        claims.put("tenant", "tenant");
//        claims.put("account", "account");
//        claims.put("userId", "userId");
//        claims.put("userName", "userName");
//        claims.put("userType", "userType");
//        claims.put("email", "email");
//        claims.put("authorityPolicy", "authorityPolicy");
//        claims.put("ip", "ip");
//
//        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
//        String token = jwtTokenUtil.generateToken(user.getUserName(), IdGenerator.uuid(), claims);
//        System.out.println("Token: " + token);
//
//        //将token保存到cookie中，并将cookie添加到response中
//        Cookie cookie = new Cookie("token", token);
//        cookie.setMaxAge(3600);
//        cookie.setDomain("localhost");
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        modelMap.addAttribute("message","传值到页面123abc");
//        return "mainView";
    }

    /**
     * 跳转到main主页
     * ajax请求是不能实现mvc的controller跳转到页面的，只有普通的http请求才能实现跳转。因此这里使用普通的http请求，
     * 用户信息我们从该请求的cookie中的token中获取。这里有问题，会暴露登陆信息！！
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @GetMapping("toMain")
    public String toMain(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String accountName = "";
        //获取用户凭证token
        String token = null;
        Cookie[] cookies = request.getCookies();
        try{
            if(cookies.length != 0){
                for (int i = 0 ; i < cookies.length; i++){
                    String cookieName = cookies[i].getName();
                    if (cookieName.equals("token")){
                        token = cookies[i].getValue();
                    }
                }
                if(Objects.isNull(token)){
                    //跳转至登录页面
                    toLogin(request,response);
                }
                //解密token
                JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
                Claims claims = jwtTokenUtil.getClaimFromToken(token);
                if(claims == null || jwtTokenUtil.isTokenExpired(token)){
                    //跳转至登录页面
                    toLogin(request,response);
                }
                accountName = jwtTokenUtil.getSubjectFromToken(token);
            }else{
                //跳转至登录页面
                toLogin(request,response);
            }
        }catch(Exception e){
            //跳转至登录页面
            toLogin(request,response);
        }
        HttpSession session = request.getSession();
        User currentUser = userService.findByAccountName(accountName);
        session.setAttribute("currentUser", currentUser);
        //获取登陆用户的访问权限（roleType）,组装成菜单返回给页面
        Role role = roleService.findByRoleType(currentUser.getRoleType());
        if(Objects.isNull(role)){
            //未找到当前用户的角色信息
        }else{
            //创建一级菜单对象列表
            List<Menu> menus = new ArrayList<Menu>();
            //根据roleType获取当前用户所有有权限的功能项信息
            List<Authority> authorities = authorityService.listByRoleType(currentUser.getRoleType());
            if(0 != authorities.size()){
                List<Authority> parentAuthorities = new ArrayList<Authority>();//父功能项
                //拿到功能项中所有父功能项
                for (Authority authority : authorities){
                    if("MAIN".equals(authority.getModuleParentCode())){
                        parentAuthorities.add(authority);
                    }
                }
                //根据moduleParentRank属性对父功能项排序，升序排序
                Collections.sort(parentAuthorities, new Comparator<Authority>() {
                    @Override
                    public int compare(Authority o1, Authority o2) {
                        return o1.getModuleParentRank() - o2.getModuleParentRank();
                    }
                });
                //循环创建每个一级菜单
                for (Authority parentAuthority : parentAuthorities){
                    Menu menu = new Menu();
                    menu.setParentAuthority(parentAuthority);
                    List<Authority> childAuthorities = new ArrayList<Authority>();//子功能项
                    //拿到功能项中当前父功能下的所有子功能项
                    for (Authority authority : authorities){
                        if(authority.getModuleParentCode().equals(parentAuthority.getModuleCode())){
                            childAuthorities.add(authority);
                        }
                    }
                    //根据moduleChildRank属性对子功能项排序，升序排序
                    Collections.sort(childAuthorities, new Comparator<Authority>() {
                        @Override
                        public int compare(Authority o1, Authority o2) {
                            return o1.getModuleChildRank() - o2.getModuleChildRank();
                        }
                    });
                    //将子功能项放入菜单对象中
                    menu.setChildAuthorities(childAuthorities);
                    //将当前菜单放入菜单列表中
                    menus.add(menu);
                }
                System.out.println("当前用户的菜单列表为：" + menus);
                //将当前用户的菜单列表返回给前端显示
                modelMap.addAttribute("menus",menus);
            }else{
                //当前用户无菜单权限
            }
        }
        modelMap.addAttribute("accountName",accountName);
        return "mainView";
    }

    /**
     * 判断是否是ajax请求，如果不是；则跳转到登陆页面；否则返回999错误状态码
     * @param request
     * @param response
     * @throws Exception
     */
    private void toLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取项目路径
        String ctxPath = request.getContextPath();
        //通过x-requested-with头信息来区分ajax请求还是普通请求
        String isAjax = request.getHeader("x-requested-with");//如果是ajax请求，则isAjax=“XMLHttpRequest”；否则，isAjax=null
        System.out.println("是否是ajax请求：" + isAjax);
        if (StringUtils.isEmpty(isAjax)) {
            response.getWriter().write(
                    "<script type=\"text/javascript\">"+
                            "alert(\"Please login again,token invalid!\");"+
                            "parent.location.href='" +ctxPath+ "';</script>");
            response.getWriter().flush();
            response.getWriter().close();
        } else {
            response.sendError(999);
        }
    }

}
