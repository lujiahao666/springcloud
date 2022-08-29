package com.lu.springcloud;

import com.lu.springcloud.pojo.Dept;
import com.lu.springcloud.service.DeptService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Component
public class test {
    @Autowired
    DeptService deptService;
    @Autowired
    DataSource dataSource;
    @Test
    public void test(){
        System.out.println(dataSource.getClass());
       /*List<Dept> depts = deptService.queryAll();
        for (Dept dept : depts) {
            System.out.println(dept);
        }*/
    }
}
