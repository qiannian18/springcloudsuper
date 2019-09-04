package com.qiannian.backclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //客户端身份
@EnableFeignClients
public class BackClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackClientApplication.class, args);
    }

}
