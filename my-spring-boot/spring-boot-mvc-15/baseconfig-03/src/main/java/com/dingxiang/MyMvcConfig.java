package com.dingxiang;

import com.dingxiang.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc  /*开启对SpringMVC的支持，若无此句，重写WebMvcConfigurerAdapter无效*/
@ComponentScan("com.dingxiang")
public class MyMvcConfig extends WebMvcConfigurerAdapter {/*重写其方法可对springmvc进行配置*/

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /*
    *配置静态资源路径
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*addResourceLocations：文件放置的目录；addResourceHandler：对外暴露的访问路径*/
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    /*
    *配置拦截器bean初始化
    * */
    @Bean
    // 1
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /*实现对每一个请求处理前后进行相关业务处理*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 2
        registry.addInterceptor(demoInterceptor());
    }

    /*
    * 页面无逻辑直接跳转
    * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
    }

    /*
    * 地址中有点的链接设置不过滤
    * */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
