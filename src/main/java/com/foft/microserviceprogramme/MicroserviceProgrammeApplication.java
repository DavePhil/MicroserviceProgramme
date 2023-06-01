package com.foft.microserviceprogramme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.foft.microserviceprogramme")
@EnableDiscoveryClient
@RefreshScope
public class MicroserviceProgrammeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProgrammeApplication.class, args);
    }

}
