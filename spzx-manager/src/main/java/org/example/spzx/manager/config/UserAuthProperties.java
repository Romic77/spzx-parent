package org.example.spzx.manager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
@Data
@Component // 声明为Spring Bean
@ConfigurationProperties(prefix = "spzx.auth")
public class UserAuthProperties {
    private List<String> noAuthUrls;
}
