package com.bjpowernode.controller;



import com.bjpowernode.entities.CommonResult;
import com.bjpowernode.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getpaymentById(@PathVariable("id") long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
