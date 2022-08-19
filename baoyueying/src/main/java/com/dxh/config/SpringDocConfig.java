package com.dxh.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI userOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(externalDocumentation());
    }

    private License license() {
        return new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");
    }

    private Info info() {
        return new Info()
                .title("Users Open API")
                .description("测试spring doc openapi")
                .version("v0.0.1")
                .license(license());
    }

    private ExternalDocumentation externalDocumentation() {
        return new ExternalDocumentation()
                .description("唐九夏还想在躺一下")
                .url("https://github.com/baoyueying/tangjiuxia");
    }

}
