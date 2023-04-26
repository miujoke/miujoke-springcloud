package com.miujoke.customrule.impl;

import com.miujoke.customrule.LoadBanlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/26 23:23
 * 手写轮询算法
 */
@Component
@Slf4j
public class CustomRoundRobinRule implements LoadBanlancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 得到要访问服务器的下标
    public final int getAndIncrement(){
        int current;
        int next;
        for (;;){
            current = this.atomicInteger.get();
            next = current >= (1 << 31) - 1 ? 0 : current + 1;
            // 通过CAS得到当前值还未变更就返回
            if (this.atomicInteger.compareAndSet(current, next)){
                log.info("***********第{}次访问服务****", next);
                return next;
            }
        }
    }
    // 得到访问实例
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
