package com.foft.microserviceprogramme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.foft.microserviceprogramme")
public class MicroserviceProgrammeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProgrammeApplication.class, args);
    }

}
