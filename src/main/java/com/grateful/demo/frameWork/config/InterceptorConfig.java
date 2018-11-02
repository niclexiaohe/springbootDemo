package com.grateful.demo.frameWork.config;

import com.grateful.demo.frameWork.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * DESC: tonken访问权限拦截配置类
 * USER: C.HE
 * DATE: 2018/10/9 11:13
 * VERSION: 0.0.1
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 重写添加拦截器方法来添加token权限认证拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())//添加拦截器
                .addPathPatterns("/**");// 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }


    /**
     * 注册拦截器对象
     * @return
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
