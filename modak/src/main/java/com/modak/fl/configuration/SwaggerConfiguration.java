package com.modak.fl.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(generateSecurityScheme())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.modak.fl.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private List<SecurityScheme> generateSecurityScheme() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        BasicAuth basicAuth = new BasicAuth("basicAuth");
        schemeList.add(basicAuth);
        return schemeList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API - modak")
                .description("API Backend for Frontend")
                .version("1.0.0")
                .build();
    }

}
