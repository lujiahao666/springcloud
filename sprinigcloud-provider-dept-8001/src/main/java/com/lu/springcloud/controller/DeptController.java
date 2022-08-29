package com.lu.springcloud.controller;

import com.lu.springcloud.pojo.Dept;
import com.lu.springcloud.service.DeptService;
import com.lu.springcloud.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    DiscoveryClient client;
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/queryByDeptno/{deptno}")
    public Dept queryByDeptno(@PathVariable("deptno") Long deptno){
        return deptService.queryByDeptno(deptno);
    }

    @GetMapping("/dept/queryAll")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
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
