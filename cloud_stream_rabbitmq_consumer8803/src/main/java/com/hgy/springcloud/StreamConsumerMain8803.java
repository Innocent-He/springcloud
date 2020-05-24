package com.hgy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/18 15:45
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8803.class, args);
    }
}
