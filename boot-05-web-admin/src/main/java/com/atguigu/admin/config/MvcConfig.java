package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@EnableWebMvc
@Configuration(proxyBeanMethods = true)
public class MvcConfig implements WebMvcConfigurer {


    private LoginInterceptor loginInterceptor;
    @Autowired
    public void setLoginInterceptor(LoginInterceptor loginInterceptor){
        this.loginInterceptor = loginInterceptor;
    }

    /**
     * 定义静态资源行为
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/aa/**")
//        .addResourceLocations("classpath:/static/**");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql","/acct","/city","/savecity");
    }
}
