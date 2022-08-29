package com.lu.springcloud.controller;

import com.lu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者层，没有service层
    //需要从RestTemplate调用方法.
    //String url, Class<T> responseType, Object... uriVariables
    //这个url就是要调用的provider方法请求的url地址，urlvariables就是我们方法传递的参数，response就是我们方法的类型.class
    //响应类型就是结果类型
    @Autowired
    private RestTemplate restTemplate;//提供多种远程便捷访问http服务的方法,简单的restful服务模板
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //通过ribbon,寻找在eureka注册中心的application服务名称SPRINIGCLOUD-PROVIDER-DEPT	来寻找eureka
    private static final String REST_URL_PREFIX = "http://sprinigcloud-provider-dept";
    
    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno") Long deptno){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryByDeptno/"+deptno,Dept.class);
    }

    @RequestMapping("/consumer/dept/query")
    public List<Dept> query(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryAll",List.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/hello")
    public String hello(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/hello",String.class);
    }

}
