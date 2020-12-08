package com.copious.training.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Utkarsh Awasthi
 **/

@Configuration
public class SwaggerApi {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.copious.training.controller"))
                .paths(regex("/employee"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {

        return new ApiInfoBuilder()
                .title("Copious Training")
                .description(" Training Project")
                .build();
    }
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "CRUD operation on users",
                "All the employees will be united under one portal",
                "1.007.0",
                "noUrl.copious",
                new Contact("Utkarsh Awasthi", "", "utkarsh@copious.cloud"),
                "",
                "");
    }
}



