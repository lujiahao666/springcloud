package com.lu.springcloud;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class test {
    @Autowired
    DataSource dataSource;
    @Test
    void test(){

    }
}
