package com.lu.springcloud.controller;

import com.lu.springcloud.pojo.Dept;
import com.lu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
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
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
