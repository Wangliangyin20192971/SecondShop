package com.yin.config;

import com.yin.interceptor.ResourcesInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Classname SpringMvcConfig
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/16 9:49
 * @Version 1.0
 **/
@Configuration
@PropertySource("classpath:ignoreUrl.properties")
@ComponentScan("com.yin.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Value("#{'${ignoreUrl}'.split(',')}")
    private List<String> ignoreUrl;

    @Bean
    public ResourcesInterceptor resourcesInterceptor(){
        return new ResourcesInterceptor(ignoreUrl);
    }

    //视图解析
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/admin/",".jsp");
    }
    //开启静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resourcesInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/img/**");
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置文件已生效");
        // 映射图片保存地址
        registry.addResourceHandler("/img/**")
                .addResourceLocations("D:\\OurProject\\src\\main\\webapp\\img");
    }*/
}
