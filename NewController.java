package com.gmail.chitakov2606nikita.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {
    @GetMapping("/ajax")
    public String ajax() {

        return "Hello, Vladimir Gennadevich";
    }
}