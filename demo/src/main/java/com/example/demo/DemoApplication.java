package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启组建扫描和自动配置
@SpringBootApplication(scanBasePackages = "com.example.demo.*", exclude = ErrorMvcAutoConfiguration.class)
@MapperScan(basePackages = "com.example.demo.dao")
@EnableTransactionManagement
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

