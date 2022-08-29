package com.lu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //配置负载均衡实现咱们的resttemplate
    //ribbon核心是Ribbon，
    // availbiltyfilterrule 先过滤掉崩溃的服务，对剩下的进行轮询
    // roundrobinrule 轮询
    // rondomrule随机
    //retryrule 会按照轮询获取服务，如果获取失败，会在规定的时间内进行重试


    @Bean
    @LoadBalanced//ribbon 针对客户端配置的 客户端通过rest来访问提供者
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
