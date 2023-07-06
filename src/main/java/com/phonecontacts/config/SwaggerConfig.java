package com.phonecontacts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String CONTACT_MAIL = "samirvaliyev@gmail.com";
    private static final String DEV_IT_TEAM = "AZERBAIJAN";
    private static final String SWAGGER_URL = "http://localhost:5788/swagger-ui/index.html";
    private static final String TITLE = "CONTACT-PHONES";
    private static final String DESCRIPTION = "CONTACT-PHONES";
    private static final String VERSION = "1.0";


    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        .contact(new Contact()
                                .email(CONTACT_MAIL)
                                .name(DEV_IT_TEAM)
                                .url(SWAGGER_URL)
                        )
                        .version(VERSION));
    }
    /*    spring:
            mvc:
               throwExceptionIfNoHandlerFound: true*/

}
