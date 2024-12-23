package org.example.spzx.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Knife4jConfig {
    public Knife4jConfig() {
        log.info("Knife4jConfig init");
    }

    @Bean
    public GroupedOpenApi adminApi() {      // 后台管理系统接口分组
        return GroupedOpenApi.builder()
                .group("admin-api")         // 分组名称
                .pathsToMatch("/admin/**")  // 接口请求路径规则
                .build();
    }

    @Bean
    public GroupedOpenApi webApi() {      // 前台系统接口分组
        return GroupedOpenApi.builder()
                .group("web-api")         // 分组名称
                .pathsToMatch("/**")  // 接口请求路径规则
                .build();
    }

    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                 .info(new Info()
                 .title("尚品甑选API接口文档")
                 .version("1.0")
                 .description("尚品甑选API接口文档")
                 .contact(new Contact().name("atguigu"))); // 设定作者
    }

}