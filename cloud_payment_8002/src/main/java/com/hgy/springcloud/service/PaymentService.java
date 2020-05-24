package com.hgy.springcloud.service;

import com.hgy.springcloud.entities.Payment;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 10:32
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment queryById(Long id);
}
