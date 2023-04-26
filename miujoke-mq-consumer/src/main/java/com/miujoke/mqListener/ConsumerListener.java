package com.miujoke.mqListener;

import com.miujoke.mqListener.handler.MessageHandler;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.nio.channels.Channel;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: duxin
 * @DateTime: 2023/3/9 15:12
 */
public class ConsumerListener {

    private ConcurrentHashMap<String, MessageHandler> handlers= new ConcurrentHashMap<>();

    public void registerMsgHandler(String messageKey, MessageHandler messageHandler){
        handlers.put(messageKey, messageHandler);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue.consumer", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "direct.exchange", type = "direct", durable = "true"),
            key = "routingKey"
    ))
    public void pushMsg(Message message, Channel channel){

    }
}
