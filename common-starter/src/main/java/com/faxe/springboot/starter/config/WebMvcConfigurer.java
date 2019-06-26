package com.faxe.springboot.starter.config;

import com.faxe.springboot.starter.convert.FastJsonGenericHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 *  WebMvcConfigurerAdapter
 *
 * @author Xiang Zhou
 * @create 2018-09-04 17:09
 **/
@Configuration
@AutoConfigureAfter(WebMvcConfigurer.class)
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private FastJsonGenericHttpMessageConverter fastJsonGenericHttpMessageConverter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonGenericHttpMessageConverter);
        super.configureMessageConverters(converters);
    }
}