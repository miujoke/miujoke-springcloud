package com.miujoke.service.impl;

import cn.hutool.core.lang.UUID;
import com.miujoke.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * @author miujoke
 * @date 2023/5/21 22:48
 */
@EnableBinding(Source.class) // 定义消息推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider{

    @Autowired
    private MessageChannel output; // 消息发送管道
    @Override
    public String send() {
        String uuid= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("******发送消息： " + uuid);
        return "send success";
    }
}
