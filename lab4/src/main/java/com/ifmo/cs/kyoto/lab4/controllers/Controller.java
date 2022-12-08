package com.ifmo.cs.kyoto.lab4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Controller {


    @GetMapping
    public String list(){
        return "hello";
    }



}
