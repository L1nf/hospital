package com.soft_engin.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @author Linf
 * @date 10/4/2022 9:29 PM
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("JWT").build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder().securityReferences(Collections.singletonList(SecurityReference.builder().scopes(new AuthorizationScope[0]).reference("JWT").build())).operationSelector(o -> o.requestMappingPattern().matches("/.*")).build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soft_engin.hospital.controller"))
                .build();
    }
}