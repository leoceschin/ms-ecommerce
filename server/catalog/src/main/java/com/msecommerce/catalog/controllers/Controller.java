package com.msecommerce.catalog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/")
    public void ping(){
        System.out.println("primeiro microserviço em docker");
    }
}
