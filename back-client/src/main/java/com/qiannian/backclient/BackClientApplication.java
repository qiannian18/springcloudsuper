package com.qiannian.backclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //客户端身份
public class BackClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackClientApplication.class, args);
    }

}
