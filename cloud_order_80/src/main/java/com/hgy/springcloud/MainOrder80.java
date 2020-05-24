package com.hgy.springcloud;

import com.hgy.myrole.MySelfRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 11:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOrder80.class, args);
    }
}
