package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.*;
import com.readysoft.personalwallet.service.AccumulationCategoryService;
import com.readysoft.personalwallet.service.AccumulationService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccumulationController {
    @Autowired
    private AccumulationService accumulationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccumulationCategoryService accumulationCategoryService;

    @GetMapping("/accumulation")
    public String listAccumulation(@AuthenticationPrincipal CustomUserDetail user , Model model){
        User currenUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listAccumulations" , accumulationService.getAllAccumulationFromId(currenUser.getId()));
        return "/accumulation/index";
    }

    @GetMapping("/accumulation/add-accumulation")
    public String addShowAccumulation(@AuthenticationPrincipal CustomUserDetail user,Model model){
        model.addAttribute("accumulation",  new Accumulation());
        model.addAttribute("accumulationCategeries", accumulationCategoryService.listAccumulationCategory());
        return "/accumulation/add-accumulation";
    }

    @PostMapping("/accumulation/addAccumulation")
    public String addAccumulation(@AuthenticationPrincipal CustomUserDetail user , Accumulation accumulation){
        accumulation.setUser(user.getUser());
        accumulationService.saveAccumulation(accumulation);
        return "redirect:/accumulation";
    }

    @GetMapping("/accumulation/edit/{id}")
    public String updateAccumulation(@AuthenticationPrincipal CustomUserDetail user, @PathVariable("id") Integer id, Model model){
        Accumulation existAccumulation = accumulationService.findById(id).get();
        model.addAttribute("accumulation", existAccumulation);
        model.addAttribute("accumulationCategories", accumulationCategoryService.listAccumulationCategory());
        return "/accumulation/add-accumulation";
    }

    @GetMapping("/accumulation/delete/{id}")
    public String deleteAccumulation(@PathVariable("id") Integer id){
        accumulationService.deleteById(id);
        return "redirect:/accumulation";
    }
}
