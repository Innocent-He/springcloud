package com.hgy.springcloud.controller;

import com.hgy.springcloud.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/18 12:23
 */
@RestController
public class SendMessageController {
    @Resource
    private ProviderService providerService;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return providerService.send();
    }
}
