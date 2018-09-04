package com.faxe.springboot.starter.convert;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;

import java.lang.reflect.Type;

/**
 * fastjson 消息转换器
 *
 * spring 默认使用 faskson 进行json 与java bean 之间的互相转换
 * 个人认为较优的策略是：
 * (1)采用 fastjson 进行 json => java bean，优点是速度快
 * (2)采用 jackson 进行 java bean => json，保证转换结果正确
 *
 * @author Xiang Zhou
 * @create 2018-09-04 16:44
 **/
public class FastJsonGenericHttpMessageConverter extends FastJsonHttpMessageConverter implements Ordered {

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
        return false;
    }
}