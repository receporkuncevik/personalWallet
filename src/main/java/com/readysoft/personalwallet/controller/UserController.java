package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public String getUser(Model model){
        model.addAttribute("user", userService.getUser(1));
        return "/user/index";
    }

    @GetMapping("/user/edit")
    public String showEdit(Model model){
        model.addAttribute("user", userService.getUser(1));
        return "/user/edit";
    }

    @PostMapping("/user/saveuser")
    public String editUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user";

    }
}
