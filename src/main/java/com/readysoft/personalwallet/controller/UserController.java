package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/user/edit")
    public String showEdit(@AuthenticationPrincipal CustomUserDetail loggedUser, Model model){
        User existUser = userService.findById(loggedUser.getUser().getId()).get();
        model.addAttribute("user", existUser);
        return "/user/edit";
    }

    @PostMapping("/user/update")
    public String editUser(@AuthenticationPrincipal CustomUserDetail loggedUser,User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        loggedUser.setUserName(user.getUserName());
        loggedUser.setFirstName(user.getFirstName());
        loggedUser.setLastName(user.getLastName());
        return "redirect:/user/edit";
    }
}
