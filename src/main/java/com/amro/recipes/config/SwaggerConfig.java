package com.amro.recipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData());
    }

    /**
     * Config meta data swagger
     * @return metaData info
     */
    private ApiInfo metaData() {
        return new ApiInfo(
                "Recipes Rest API",
                "Recipe Rest API for ABN Company",
                "1.0",
                "Recipes",
                new Contact("Abbas Payami", "", "payami2013@gmail.com"),
                "",
                "");
    }

}