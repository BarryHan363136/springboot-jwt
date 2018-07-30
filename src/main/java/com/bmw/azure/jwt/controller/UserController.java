package com.bmw.azure.jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/api/protected")
    public @ResponseBody Object hellWorld() {
        return "Hello World! This is a protected api";
    }


}
