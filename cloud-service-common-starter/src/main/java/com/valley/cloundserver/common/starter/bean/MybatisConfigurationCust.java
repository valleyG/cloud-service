package com.valley.cloundserver.common.starter.bean;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
/**
*
* @author:valley
* @date:2020/10/27
* @description:
**/
public class MybatisConfigurationCust implements ConfigurationCustomizer {
    @Override
    public void customize(Configuration configuration) {
        //开启驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);
        //设置日志实现
        configuration.setLogImpl(StdOutImpl.class);
    }
}
