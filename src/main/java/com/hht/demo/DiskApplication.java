package com.hht.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.hht.demo.Mapper"})
public class DiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiskApplication.class, args);
    }
}
