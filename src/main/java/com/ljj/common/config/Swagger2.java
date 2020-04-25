package com.ljj.common.config;

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
 * <p>
 * Swagger2 在线接口文档
 * </p>
 *
 * @author LeeJack
 * @date Created in 2020/4/26 1:47
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付后台API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljj.modules.web"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket alipayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付宝API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljj.modules.alipay"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket weixinpayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("微信API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljj.modules.weixinpay"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket unionpayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("银联API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljj.modules.unionpay"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("支付系统")
                .description("微信、支付宝、银联支付服务")
                .termsOfServiceUrl("localhost:8080")
                .contact(new Contact("LeeJack", "https://www.baidu.com", "545430154@qq.com"))
                .version("1.0").build();
    }
}
