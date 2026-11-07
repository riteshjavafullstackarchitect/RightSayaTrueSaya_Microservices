package com.rightsaya.microservices.catalogue.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;

@SpringBootApplication(exclude = {GatewayAutoConfiguration.class})
public class RightSayaProductCatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(RightSayaProductCatalogueApplication.class, args);
    }

}
