package com.hgy.springcloud.controller;

import com.hgy.springcloud.entities.CommonResult;
import com.hgy.springcloud.entities.Payment;
import com.hgy.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/11 17:53
 */
@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/order/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
