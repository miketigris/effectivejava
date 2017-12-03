package com.stardust.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuguirong on 2016/10/13.
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${paymentCoreUrl}")
    private String paymentCoreUrl;

    /**
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stardust.gateway.payment.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("拍拍贷支付网关接口文档")
                .description("网关核心接口文档")
                .contact(new Contact("许贵荣",paymentCoreUrl+"/swagger-ui.html","xuguirong@stardust.com"))
                .version("1.0")
                .build();
    }

}