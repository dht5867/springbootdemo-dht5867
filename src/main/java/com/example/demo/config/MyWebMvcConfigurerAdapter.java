package com.example.demo.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author
 * @description
 * @create 2017-11-14 下午3:53
 **/
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 自定义资源映射器
     * 配置静态资源路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addresourcehandler映射路径, addresourcelocation 映射路径的目录,可以是本文件,也可以是外部目录
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        super.addResourceHandlers(registry);
    }


    /**
     * 自定义访问的Controller ,映射路径,返回view,
     * 直接访问地址就可进入页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("toLogin").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/swagger-ui.html","/druid/*","/v2/**","/login");
    }
    /**
     * 配置fastJson转换配置
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //SerializerFeature.PrettyFormat,SerializerFeature.WriteClassName,
        //fastJsonConfig.setDateFormat("yyyy-MM-dd");
        //3、在 Convert 中添加配置信息;
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
        ValueFilter valueFilter = new ValueFilter() {
            //o 是class
            //s 是key值
            //o1 是value值
            @Override
            public Object process(Object o, String s, Object o1) {
                if (null == o1){
                    o1 = "";
                }
                return o1;
            }
        };
        fastJsonConfig.setSerializeFilters(valueFilter);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
        super.configureMessageConverters(converters);
    }
}
