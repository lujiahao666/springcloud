package com.lu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//ribbon和eureka整合以后客户端可以直接调用方法，不用关心ip地址和端口号
@EnableFeignClients(basePackages = {"com.lu.springcloud"})
public class FeginDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeginDeptConsumer_80.class,args);
    }
}
