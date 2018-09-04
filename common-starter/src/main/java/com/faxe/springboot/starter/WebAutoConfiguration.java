package com.faxe.springboot.starter;

import com.faxe.springboot.starter.convert.FastJsonGenericHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author Xiang Zhou
 * @create 2018-09-04 17:17
 **/
@Configuration
@ComponentScan("com.faxe")
public class WebAutoConfiguration {

    @Bean
    public FastJsonGenericHttpMessageConverter fastJsonHttpMessageConverter() {
        return new FastJsonGenericHttpMessageConverter();
    }
}