package com.hgy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/18 12:14
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderMain8801.class, args);
    }
}
