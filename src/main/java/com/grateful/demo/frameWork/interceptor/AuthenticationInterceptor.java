package com.grateful.demo.frameWork.interceptor;

import com.grateful.demo.frameWork.annotations.IgnoreAuthCheck;
import com.grateful.demo.frameWork.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.message.AuthException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * DESC:  token权限拦截器
 * USER: C.HE
 * DATE: 2018/10/9 11:07
 * VERSION: 0.0.1
 */

/**
 * 实现一个拦截器就需要实现HandlerInterceptor接口
 *
 * HandlerInterceptor接口主要定义了三个方法
 * 1.boolean preHandle ()：
 * 预处理回调方法,实现处理器的预处理，第三个参数为响应的处理器,自定义Controller,返回值为true表示继续流程（如调用下一个拦截器或处理器）或者接着执行postHandle()和afterCompletion()；false表示流程中断，不会继续调用其他的拦截器或处理器，中断执行。
 *
 * 2.void postHandle()：
 * 后处理回调方法，实现处理器的后处理（DispatcherServlet进行视图返回渲染之前进行调用），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
 *
 * 3.void afterCompletion():
 * 整个请求处理完毕回调方法,该方法也是需要当前对应的Interceptor的preHandle()的返回值为true时才会执行，也就是在DispatcherServlet渲染了对应的视图之后执行。用于进行资源清理。整个请求处理完毕回调方法。如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 返回true,则继续进行url请求；返回false则中断继续请求
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截前操作");

        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        //检查是否有@IgnoreAuthCheck注释，如果有，则判断是否要求权限检查；如果没有，则默认需要进行token认证
        if (method.isAnnotationPresent(IgnoreAuthCheck.class)) {
            IgnoreAuthCheck ignoreAuthCheck = method.getAnnotation(IgnoreAuthCheck.class);
            if (ignoreAuthCheck.required()) {//如果ignoreAuthCheck.required()==true,则表示不进行token权限检查；反之，进行token权限检查
                return true;
            }
        }
        /****************进行到这里，表示需要进行token认证************************/
        //获取用户凭证token
//        String token = request.getHeader("Authorization");// 从 http 请求头中取出 token
//        System.out.println("token====" + token);


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
//                    throw new AuthException("无token信息，请重新登录");
                }

                //解密token
                JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
                Claims claims = jwtTokenUtil.getClaimFromToken(token);
                if(claims == null || jwtTokenUtil.isTokenExpired(token)){
                    //跳转至登录页面
                    toLogin(request,response);
//                    throw new AuthException("token失效，请重新登录");
                }
                System.out.println(jwtTokenUtil.getSubjectFromToken(token));
            }else{
                //跳转至登录页面
                toLogin(request,response);
//                throw new AuthException("无token信息，请重新登录");
            }
        }catch(Exception e){
            //跳转至登录页面
            toLogin(request,response);
//            throw new AuthException("无token信息，请重新登录");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

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
