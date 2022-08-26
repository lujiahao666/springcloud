package com.lu.springcloud.dao;

import com.lu.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DeptMapper {
    boolean addDept(Dept dept);
    Dept queryByDeptno(Long deptno);
    List<Dept> queryAll();
}
