package com.hgy.springcloud.service;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author He
 * @version 1.0
 * @date 2020/5/18 12:16
 */
@EnableBinding(Source.class)//表示当前类是source，负责生产消息，发送给channel
public class ProviderServiceImpl implements ProviderService {
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//build方法会返回一个message类
        System.out.println("serial" + serial);
        return null;
    }
}
