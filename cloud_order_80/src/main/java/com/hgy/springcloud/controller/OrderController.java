package com.hgy.springcloud.controller;

import com.hgy.springcloud.entities.CommonResult;
import com.hgy.springcloud.entities.Payment;
import com.hgy.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/10 11:50
 */
@RestController
public class OrderController {
    public static final String PAY_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/order")
    public CommonResult<Payment> createPayment(Payment payment) {
        return restTemplate.postForObject(PAY_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/order/{id}")
    public CommonResult<Payment> queryPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAY_URL + "/payment/query/" + id, CommonResult.class);
    }

    @GetMapping("/order/getPayment/{id}")
    public CommonResult getPayment2(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAY_URL + "/payment/query/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/order/payment/lb/{id}")
    public CommonResult getPaymentLB(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/query/" + id, CommonResult.class);

    }
}