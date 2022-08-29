package com.lu.springcloud.service;

import com.lu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Component
@FeignClient(value = "sprinigcloud-provider-dept",fallbackFactory = DeptCilentServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/getdept")
    List<Dept> getAllDept();

    @GetMapping("/hello")
    String sayHello();
}
