package com.hgy.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther He
 * @create 2020-05-23 16:57
 */
@Configuration
@MapperScan({"com.hgy.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
