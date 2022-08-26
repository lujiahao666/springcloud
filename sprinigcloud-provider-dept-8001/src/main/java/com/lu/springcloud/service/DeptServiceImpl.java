package com.lu.springcloud.service;

import com.lu.springcloud.dao.DeptMapper;
import com.lu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryByDeptno(Long deptno) {
        return deptMapper.queryByDeptno(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
