package com.lu.springcloud.service;

import com.lu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptCilentServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public List<Dept> getAllDept() {
                return null;
            }

            @Override
            public String sayHello() {
                return "hellohello 服务降级了";
            }
        };
    }
}
