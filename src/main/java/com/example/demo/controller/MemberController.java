package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MemberController {
    @GetMapping("/Profile")
    public Profile profile(){
        return new Profile("신동환",22);
    }

    record Profile(String name, int age){}
}
