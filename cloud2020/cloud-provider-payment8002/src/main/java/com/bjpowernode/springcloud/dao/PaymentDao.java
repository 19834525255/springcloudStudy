package com.bjpowernode.springcloud.dao;


import com.bjpowernode.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

   int create(Payment payment);

   Payment getPaymentById(@Param("id") long id);

}
