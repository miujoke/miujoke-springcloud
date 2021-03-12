package com.miujoke.dao;

import com.miujoke.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:46
 */
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
