package com.atguigu.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServelt(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/css/*");
    }

    public FilterRegistrationBean<MyFilter> myFilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/images/*"));
        return filterFilterRegistrationBean;
        //return new FilterRegistrationBean(myFilter,myServelt());




    }

    public ServletListenerRegistrationBean myListener(){
        MyServletContext myServletContext = new MyServletContext();

        return new ServletListenerRegistrationBean(myServletContext);
    }
}
