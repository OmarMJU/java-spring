package com.omju.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
public class TestController {
    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> functionResponse() {
        return new ResponseEntity<>("Hi! Im a response from the controller", HttpStatus.OK);
    }
}