package com.hgy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/19 10:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9002.class, args);
    }
}
