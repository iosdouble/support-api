package com.zk.szgh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @Classname SwaggerConfig
 * @Description TODO
 * @Date 2020/8/21 5:22 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SwaggerConfig @see support-api
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zk.szgh.controller.v1"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("肃州工会API文档")
                .description("肃州工会 API 1.0 操作文档")

                .termsOfServiceUrl("http://www.nihui.com")
                .version("1.0")
                .contact(new Contact("智酷", "http://zhiku.com", "nihui3@gome.com.cn"))
                .build();
    }
}
