package com.readysoft.personalwallet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
    
}
