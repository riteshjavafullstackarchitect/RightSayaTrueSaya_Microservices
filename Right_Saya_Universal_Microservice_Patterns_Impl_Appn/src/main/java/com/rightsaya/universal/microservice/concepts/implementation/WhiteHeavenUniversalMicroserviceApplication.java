package com.rightsaya.universal.microservice.concepts.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;

@SpringBootApplication(exclude = {GatewayAutoConfiguration.class})
public class RightSayaUniversalMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RightSayaUniversalMicroserviceApplication.class, args);
    }

}
