package com.my.sample.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.my.sample.mybatis.mapper"})
public class AppConfig {

}
