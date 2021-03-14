package com.miujoke.service;

import com.miujoke.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:58
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
