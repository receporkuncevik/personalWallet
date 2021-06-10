package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.Credit;
import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.BankService;
import com.readysoft.personalwallet.service.CreditCategoryService;
import com.readysoft.personalwallet.service.CreditService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CreditController {
    private CreditCategoryService creditCategoryService;
    private UserService userService;
    private CreditService creditService;
    private BankService bankService;

    @Autowired
    public CreditController(CreditCategoryService creditCategoryService, UserService userService, CreditService creditService, BankService bankService) {
        this.creditCategoryService = creditCategoryService;
        this.userService = userService;
        this.creditService = creditService;
        this.bankService = bankService;
    }

    @GetMapping("/credit")
    public String listCredit(@AuthenticationPrincipal CustomUserDetail user , Model model){
        User currentUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listCredits" , creditService.getAllCreditFromId(currentUser.getId()));
        return "/credit/index";
    }

    @GetMapping("/credit/add-credit")
    public String addShowCredit(@AuthenticationPrincipal CustomUserDetail user,Model model){
        model.addAttribute("credit",  new Credit());
        model.addAttribute("creditCategories", creditCategoryService.listCreditCategories());
        model.addAttribute("allBanks", bankService.getAllBankWithUserId(user.getUser().getId()));
        return "/credit/add-credit";
    }

    @PostMapping("/credit/addCredit")
    public String addCredit(@AuthenticationPrincipal CustomUserDetail user,Credit credit){
        credit.setUser(user.getUser());
        creditService.saveCredit(credit);
        return "redirect:/credit";
    }

    @GetMapping("/credit/edit/{id}")
    public String updateCredit(@AuthenticationPrincipal CustomUserDetail user, @PathVariable("id") Integer id, Model model){
        Credit existCredit = creditService.findById(id).get();
        model.addAttribute("credit", existCredit);
        model.addAttribute("paymentCategories", creditCategoryService.listCreditCategories());
        return "/credit/add-credit";
    }

    @GetMapping("/credit/delete/{id}")
    public String deleteCredit(@PathVariable("id") Integer id){
        creditService.deleteById(id);
        return "redirect:/credit";
    }


}
