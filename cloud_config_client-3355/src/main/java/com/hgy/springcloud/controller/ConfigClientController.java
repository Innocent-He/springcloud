package com.hgy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/16 10:17
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.info}")
    private String serverInfo;

    @GetMapping("/serverInfo")
    public String getServerInfo() {
        return serverInfo;
    }
}
