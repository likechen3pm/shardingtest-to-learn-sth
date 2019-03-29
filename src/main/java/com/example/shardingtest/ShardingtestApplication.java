package com.example.shardingtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.shardingtest.dao")
public class ShardingtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingtestApplication.class, args);
    }

}
