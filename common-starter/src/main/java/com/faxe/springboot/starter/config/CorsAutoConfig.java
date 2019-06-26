package com.faxe.springboot.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域设置
 *
 * @author Xiang Zhou
 * @create 2018-09-04 17:09
 */
@Configuration
@ConditionalOnProperty(prefix = "commons.cors", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(CorsProperties.class)
public class CorsAutoConfig {

    @Autowired
    private CorsProperties corsProperties;

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(corsProperties.getAllowedHeaders());
        corsConfiguration.setAllowedMethods(corsProperties.getAllowedMethods());
        corsConfiguration.setAllowedOrigins(corsProperties.getAllowedOrigins());
        corsConfiguration.setAllowCredentials(corsProperties.getAllowCredentials());
        corsConfiguration.setMaxAge(Long.valueOf(corsProperties.getMaxAge()));
        corsConfiguration.setExposedHeaders(corsProperties.getExposedHeaders());
        return corsConfiguration;
    }

    @Bean
    @ConditionalOnBean(CorsConfiguration.class)
    public CorsFilter corsFilter(CorsConfiguration corsConfiguration) {
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }
}
