package com.udemy.spring.boot.Spring.boot.learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private static final Contact DEFAULT_CONTACT = new Contact("Sachin Kumar",
            "https://test.com","sachin@gmai.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Books store"
            ,"Book store API documentation", "1.0", "urn:tos",
            "Sachin Kumar", "Apache 2.0", "http://www.apache.org");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
}
