package com.hgy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/13 13:40
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallBackService fall back-paymentInfo_ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallBackService fall back-paymentInfo_timeout,o(╥﹏╥)o";
    }
}
