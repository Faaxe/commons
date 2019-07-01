package com.faxe.springboot.starter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

/**
 * 集群环境下，redis session 共享
 *
 * @author Xiang Zhou
 * @create 2019-07-01 18:09
 **/
@Configuration
@ConditionalOnClass({RedisHttpSessionConfiguration.class, RedisTemplate.class})
@EnableRedisHttpSession
public class RedisSessionConfig {
}