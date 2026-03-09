package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalcController {
    @GetMapping("/add")
    public int add(){
        return 13+17;
    }
}
