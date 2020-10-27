package com.valley.cloundserver.common.starter.config;

import com.valley.cloundserver.common.starter.bean.MybatisConfigurationCust;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
*
* @author:valley
* @date:2020/10/27
* @description:
**/
@Configuration
public class MybatisCustAutoConfiguration {

    @Bean
    public ConfigurationCustomizer mybatisConfigurationCust(){
        return new MybatisConfigurationCust();
    }
}
