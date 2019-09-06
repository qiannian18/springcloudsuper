package com.qiannian.backserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BackServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackServerApplication.class, args);
    }

}
