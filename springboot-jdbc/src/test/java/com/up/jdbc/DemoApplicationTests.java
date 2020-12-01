package com.up.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

        Class<? extends DataSource> aClass = dataSource.getClass();
        System.out.println(aClass);
    }

}
