package com.bjpowernode.springcloud.service;


import com.bjpowernode.entities.Payment;
import org.apache.ibatis.annotations.Param;



public interface PaymentService {


   int create(Payment payment);

   Payment getPaymentById(@Param("id") long id);
}
