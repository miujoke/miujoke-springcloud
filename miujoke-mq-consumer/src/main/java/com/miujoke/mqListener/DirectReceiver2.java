package com.miujoke.mqListener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: miujoke
 * @DateTime: 2021/8/26 13:34
 */
@Component
// 监听的队列名称 TestDirectQueue
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver2 {
    @RabbitHandler
    public void process(Map message){
        System.out.println("02C-DirectReceiver消费者收到消息  : " + message.toString());
    }
}
