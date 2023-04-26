package com.miujoke.config;

/**
 * @Author: duxin
 * @DateTime: 2023/3/9 14:30
 */
public interface MessagerHandler {

    public void handler();

    public void register(MessagerHandler messagerHandler, String type);
}
