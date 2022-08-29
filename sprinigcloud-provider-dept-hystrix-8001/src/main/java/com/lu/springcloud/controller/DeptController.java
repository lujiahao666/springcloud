package com.lu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {
    @Autowired
    DiscoveryClient client;


    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "hystrixHello")
    public String hello(){
        int i = 5/0;
        if (true){
            System.out.println(i);
            throw new ArithmeticException("错误");
        }
        return "hello3";
    }

    public String hystrixHello(){
        return "hystrix---hello";
    }
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的信息
        List<String> services = client.getServices();
        System.out.println(services);
        //得到一个具体微服务信息,通过spring-application-name名字取
        List<ServiceInstance> instances = client.getInstances("sprinigcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+","+instance.getPort()+","+instance.getUri());
        }
        return client;
    }
}
