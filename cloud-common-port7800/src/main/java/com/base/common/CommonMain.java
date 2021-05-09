package com.base.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PPmaster
 * @since 2021/5/9 22:03
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.base.common.dao")
public class CommonMain {
    public static void main(String[] args) {
        SpringApplication.run(CommonMain.class,args);
    }
}
