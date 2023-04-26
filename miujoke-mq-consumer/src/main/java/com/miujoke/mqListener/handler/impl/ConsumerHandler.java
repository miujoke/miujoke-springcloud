package com.miujoke.mqListener.handler.impl;

import com.miujoke.mqListener.handler.MessageHandler;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

/**
 * @Author: duxin
 * @DateTime: 2023/3/10 10:43
 */
@Service
public class ConsumerHandler implements MessageHandler {
    @Override
    public void handle(Message message, Channel channel) throws Exception {
        // 得到业务信息
        String body = new String(message.getBody());
        // 处理业务逻辑
    }
}
