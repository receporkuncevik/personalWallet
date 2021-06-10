package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.BankAccount;
import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.BankAccountService;
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
public class BankAccountController {

    private UserService userService;
    private BankAccountService bankAccountService;
    private BankService bankService;

    @Autowired
    public BankAccountController(UserService userService, BankAccountService bankAccountService, BankService bankService) {
        this.userService = userService;
        this.bankAccountService = bankAccountService;
        this.bankService = bankService;
    }

    @GetMapping("/bank-account")
    public String showBank(@AuthenticationPrincipal CustomUserDetail user, Model model){
        User currentUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listBankAccounts", bankAccountService.getAllBankAccountWithUserId(currentUser.getId()));
        return "/bank-account/index";
    }

    @GetMapping("/bank-account/add-bank-account")
    public String addBank(@AuthenticationPrincipal CustomUserDetail user,Model model){
        model.addAttribute("bankAccount",new BankAccount());
        model.addAttribute("listBanks",bankService.getAllBankWithUserId(user.getUser().getId()));
        return "/bank-account/add-bank-account";
    }

    @PostMapping("/bank-account/addBankAccount")
    public String saveBank(@AuthenticationPrincipal CustomUserDetail user,BankAccount bankAccount){
        bankAccount.setUser(user.getUser());
        bankAccountService.save(bankAccount);
        return "redirect:/bank-account";
    }

    @GetMapping("/bank-account/edit/{id}")
    public String updateBank(@AuthenticationPrincipal CustomUserDetail user, @PathVariable("id") Integer id, Model model){
        BankAccount existBankAccount = bankAccountService.findById(id).get();
        model.addAttribute("bankAccount", existBankAccount);
        model.addAttribute("listBanks",bankService.getAllBankWithUserId(user.getUser().getId()));
        return "/bank-account/add-bank-account";
    }

    @GetMapping("/bank-account/delete/{id}")
    public String deleteBank(@PathVariable("id") Integer id){
        bankAccountService.deleteById(id);
        return "redirect:/bank-account";
    }

}
