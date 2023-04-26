package com.miujoke.customrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/26 23:30
 */
public interface LoadBanlancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
