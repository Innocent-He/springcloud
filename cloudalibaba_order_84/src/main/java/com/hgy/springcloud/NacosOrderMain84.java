package com.hgy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/22 16:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class, args);
    }
}
