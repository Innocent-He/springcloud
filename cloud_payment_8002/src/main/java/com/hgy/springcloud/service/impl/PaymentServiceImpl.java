package com.hgy.springcloud.service.impl;

import com.hgy.springcloud.dao.PaymentDao;
import com.hgy.springcloud.entities.Payment;
import com.hgy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 10:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }
}
