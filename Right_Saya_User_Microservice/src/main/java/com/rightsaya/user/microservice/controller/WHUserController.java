package com.rightsaya.user.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class WHUserController {

    @Value("${instance.name}")
    private String instanceName;

    @GetMapping("/info")
    public String info() {
        return "Response from " + instanceName;
    }

}
