package com.lihe.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg", "ControllerTest2");

        return "test";
    }
}
