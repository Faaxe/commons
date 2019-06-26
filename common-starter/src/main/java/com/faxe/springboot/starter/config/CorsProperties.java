package com.faxe.springboot.starter.config;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 跨域相关参数
 *
 * @author Xiang Zhou
 * @create 2019-06-04 17:09
 **/
@Data
@ConfigurationProperties(prefix = "commons.cors")
public class CorsProperties {

    /**
     * 域名
     */
    private List<String> allowedOrigins = Lists.newArrayList("*");

    /**
     * eg.HttpMethod.POST
     */
    private List<String> allowedMethods = Lists.newArrayList("*");

    private List<String> allowedHeaders = Lists.newArrayList("*");

    private List<String> exposedHeaders = null;

    /**
     * 是否允许发送Cookie: 默认情况下，不发生Cookie
     */
    private Boolean allowCredentials = true;

    /**
     * Configure how long, in seconds, the response from a pre-flight request
     * can be cached by clients.
     * <p>By default this is not set.
     */
    private Integer maxAge = 1800;

}
