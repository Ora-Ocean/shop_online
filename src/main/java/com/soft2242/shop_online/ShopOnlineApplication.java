package com.soft2242.shop_online;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.soft2242.shop_online.mapper")
@EnableAsync
public class ShopOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopOnlineApplication.class, args);
    }
}
