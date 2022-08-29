package com.lu.springcloud.controller;

import com.lu.springcloud.pojo.Dept;
import com.lu.springcloud.service.DeptClientService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    DeptClientService deptClientService;

    @RequestMapping("/getdept")
    public List<Dept> getAllDept(){
        return this.deptClientService.getAllDept();
    }


    @RequestMapping("/sayhello")
    public String sayHello(){
        return deptClientService.sayHello();
    }

}
