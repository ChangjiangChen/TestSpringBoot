package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class ThymeleafTestController {
    @RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
    public String getThymeleafHtml() {
        return "test/thymeleaf";
    }

}
