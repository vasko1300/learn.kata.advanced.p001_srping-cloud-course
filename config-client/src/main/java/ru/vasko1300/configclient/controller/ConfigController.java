package ru.vasko1300.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${eureka.client.service-url.defaultZone:unknown}")
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }
}
