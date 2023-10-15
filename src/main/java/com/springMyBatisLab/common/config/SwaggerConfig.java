package com.springMyBatisLab.common.config;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userAPI(){
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/user/**")
                .build();
    }

    @Bean
    public OpenAPI SpringMyBatisLabAPI(){
        Info info = new Info()
                .title("SpringMyBatisLab API 명세서")
                .version("v1.0.0")
                .description("MyBatis 사용하는 스프링 공부 프로젝트입니다.");
        return new OpenAPI().info(info);
    }
}
