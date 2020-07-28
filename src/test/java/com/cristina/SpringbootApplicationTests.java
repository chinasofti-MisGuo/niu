package com.cristina;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {

//    @Autowired
//    DataSource dataSource;

    @Test
    void contextLoads() {
//        System.out.println("数据源:"+dataSource.getClass());
//        Connection connection = dataSource.getConnection();
//        System.out.println("连接方式:"+connection);
//        connection.close();
    }

}
