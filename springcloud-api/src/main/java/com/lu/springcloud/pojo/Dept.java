package com.lu.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    //序列化必须要实现，在分布式网络通信中
    private Long deptno;
    private String dname;
    //这些数据存在哪个数据库当中，在微服务当中一个服务对应一个数据库，同一个信息可能存在不同的数据库当中
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
