package com.arasu.bar.bar.application.docs;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Document;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
// @ComponentScan("com.arasu.bar.bar.application.controller")
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                        .name("Authorization")
                        .description("Authorization for bar api")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(true)
                        .build())
                )
                .groupName("bar-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());

    }
    private ApiInfo apiInfo() {
        String description = "REST BAR";
        return new ApiInfoBuilder()
                .title("Bar Documentation")
                .description(description)
                .termsOfServiceUrl("www.kyrostechnologies.com")
                .license("Kyrostechnologies")
                .version("1.0")
                .contact(new Contact("Kyros","http://www.kyrostechnologies.com","info@kyrostechnologies.com"))
                .build();
    }
}
