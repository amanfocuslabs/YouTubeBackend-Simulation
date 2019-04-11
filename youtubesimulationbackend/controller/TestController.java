package com.mpp.youtubesimulationbackend.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/test")
    public String home() {
        return "Spring boot is working!";
    }
}