package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.Bank;
import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.BankService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankController {

    private UserService userService;
    private BankService bankService;

    @Autowired
    public BankController(UserService userService, BankService bankService) {
        this.userService = userService;
        this.bankService = bankService;
    }

    @GetMapping("/bank")
    public String showBank(@AuthenticationPrincipal CustomUserDetail user,Model model){
        User currentUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listBanks", bankService.getAllBankWithUserId(currentUser.getId()));
        return "/bank/index";
    }

    @GetMapping("/bank/add-bank")
    public String addBank(@AuthenticationPrincipal CustomUserDetail user,Model model){
        model.addAttribute("user",user);
        model.addAttribute("bank", new Bank());
        return "bank/add-bank";
    }

    @PostMapping("/bank/addBank")
    public String saveBank(@AuthenticationPrincipal CustomUserDetail user,Bank bank){
        bank.setUser(user.getUser());
        bankService.save(bank);
        return "redirect:/bank";
    }

    @GetMapping("/bank/edit/{id}")
    public String updateBank(@AuthenticationPrincipal CustomUserDetail user, @PathVariable("id") Integer id,Model model){
        Bank existBank = bankService.getById(id);
        model.addAttribute("bank",existBank);
        return "/bank/add-bank";
    }

    @GetMapping("/bank/delete/{id}")
    public String deleteBank(@PathVariable("id") Integer id){
        bankService.delete(id);
        return "redirect:/bank";
    }



}
