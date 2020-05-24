package com.hgy.springcloud.controller;

import com.hgy.springcloud.entities.CommonResult;
import com.hgy.springcloud.entities.Payment;
import com.hgy.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 10:34
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) return new CommonResult(200, "插入成功");
        else return new CommonResult(500, "插入失败");
    }

    @GetMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        if (payment != null) return new CommonResult(200, "查询成功" + "当前端口是" + port, payment);
        else return new CommonResult(500, "插入失败");
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("element======" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
