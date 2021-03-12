package com.miujoke.service.impl;

import com.miujoke.dao.PaymentDao;
import com.miujoke.entities.Payment;
import com.miujoke.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
