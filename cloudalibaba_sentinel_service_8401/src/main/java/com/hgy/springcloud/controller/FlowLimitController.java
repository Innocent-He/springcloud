package com.hgy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/21 9:58
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testa")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testb")
    public String testB() {
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "HotKey", blockHandler = "deal_HotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return p1 + p2;
    }

    public String deal_HotKey(String p1, String p2, BlockException block) {
        return "兜底方法启用";
    }
}
