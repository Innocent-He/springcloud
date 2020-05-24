package com.hgy.springcloud.dao;

import com.hgy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 10:30
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
