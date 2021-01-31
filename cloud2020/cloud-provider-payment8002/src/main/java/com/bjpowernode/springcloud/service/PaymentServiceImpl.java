package com.bjpowernode.springcloud.service;


import com.bjpowernode.entities.Payment;
import com.bjpowernode.springcloud.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;


    public int create(Payment payment){

        return paymentDao.create(payment);


    }

    public Payment getPaymentById(long id){

        return paymentDao.getPaymentById(id);

    }
}
