package com.bjpowernode.springcloud.controller;


import com.bjpowernode.entities.CommonResult;
import com.bjpowernode.entities.Payment;
import com.bjpowernode.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int i = paymentService.create(payment);

        log.info("****插入结果是："+i);

        if (i>0) {

            return new CommonResult(200,"插入成功serverPort: "+serverPort,i);

        } else {
            return new CommonResult(444,"插入失败0",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getpaymentById(@PathVariable("id") long id){

        Payment payment = paymentService.getPaymentById(id);

        log.info("****查询结果是："+payment);

        if (payment!=null) {

            return new CommonResult(200,"查询成功serverPort: "+serverPort,payment);

        } else {

            return new CommonResult(444,"查询失败"+id,null);

        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services=discoveryClient.getServices();

        for (String element : services) {
            log.info("*******element:"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
      return discoveryClient;
    }
}
