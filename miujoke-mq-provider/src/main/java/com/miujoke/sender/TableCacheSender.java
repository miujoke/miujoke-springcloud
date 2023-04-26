package com.miujoke.sender;

import java.util.List;

/**
 * @Author: duxin
 * @DateTime: 2023/3/10 10:05
 * mq发送消息接口
 */
public interface TableCacheSender {

    /***
     * desc:
     *
     *  * @param list
     * @param routingKey
     * @return void
     */
    <T> void sendResetMsg(List<T> list, String routingKey);


    /***
     * desc: 发送MQ业务队列消息
     * 
     * @param registerMsgName 注册到MQ队列的消息名称
     * @param list 业务数据 
     * @param routingKey 消息队列 routingKey
     * @return void
     */
    <T> void sendResetMsg(String registerMsgName, List<T> list, String routingKey);


    /***
     * desc: 发送延时消息队列
     * 
     * @param registerMsgName 注册到MQ队列的消息名称
     * @param list 业务数据
     * @param routingKey 消息队列 routingKey
     * @param delayTimes 延时时长
     * @return void
     */
    <T> void sendDelayMsg(String registerMsgName, List<T> list, String routingKey, Long delayTimes);
}
