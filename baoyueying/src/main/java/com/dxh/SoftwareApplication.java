package com.dxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dxh.mapper")

@SpringBootApplication
public class SoftwareApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoftwareApplication.class,args);
    }
}
