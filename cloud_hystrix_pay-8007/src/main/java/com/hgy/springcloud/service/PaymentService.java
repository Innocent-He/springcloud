package com.hgy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/13 12:31
 */
@Service
public class PaymentService {
    public String paymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Ok,id" + id + "\tO(∩_∩)O哈哈~";
    }

    //当此方法需要发生服务降级时调用paymentInfo_TimeoutHandler方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            //这里表示调用此方法的线程最多等待3秒钟，如果3秒钟没有响应则进行降级处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id" + id + "\to(╥﹏╥)o";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "系统繁忙或者报错，请稍候再试,id" + id + "\to(╥﹏╥)o";
    }

    @HystrixCommand(fallbackMethod = "PaymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//并发请求次数超过当前次数才开启断路器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//请求失败率达到百分之60进行降级
    })
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号：" + serialNumber;
    }

    public String PaymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请重新输入";
    }
}
