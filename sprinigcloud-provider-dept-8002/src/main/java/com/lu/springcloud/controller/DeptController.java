package com.lu.springcloud.controller;
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
    public String hello(){
        return "hello2";
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
