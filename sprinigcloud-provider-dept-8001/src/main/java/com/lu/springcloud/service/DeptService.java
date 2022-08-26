package com.lu.springcloud.service;

import com.lu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);
    Dept queryByDeptno(Long deptno);
    List<Dept> queryAll();
}
