package com.omju.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
public class TestController {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastName;

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> functionResponse() {
        return new ResponseEntity<>("Hi! Im a response from the controller... and my creator is " + this.name + " " + this.lastName + " 😎🤓", HttpStatus.OK);
    }
}