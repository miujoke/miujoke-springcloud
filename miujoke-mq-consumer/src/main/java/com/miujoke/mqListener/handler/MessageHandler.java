package com.miujoke.mqListener.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * @Author: duxin
 * @DateTime: 2023/3/10 10:39
 */
@FunctionalInterface
public interface MessageHandler {
    /***
     * desc: 接收消息的接口方法
     *
     * @param message
     * @param channel
     * @return void
     */
    void handle(Message message, Channel channel) throws Exception;
}
