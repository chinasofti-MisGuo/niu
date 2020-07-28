package com.cristina.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

/**
 * @description mybatis相关配置
 * @author: Yu.Guo
 * @create: 2020-07-27 19:15
 **/

@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Description("开启驼峰命名法映射规则——(把数据库与实体属性对应的字段名称一一映射)")
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
