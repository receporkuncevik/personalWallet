package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.CreditCategory;
import com.readysoft.personalwallet.model.PaymentCategory;
import com.readysoft.personalwallet.service.CreditCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditCategoyController {
    @Autowired
    private CreditCategoryService creditCategoryService;

    @GetMapping("/credit-category")
    public String listCreditCategory(Model model){
        model.addAttribute("listCreditCategory", creditCategoryService.listCreditCategories());
        return "/credit-category/index";
    }

    @GetMapping("/credit-category/add-credit-category")
    public String addFormCreditCategory(Model model){
        model.addAttribute("creditCategory",new CreditCategory());
        return "/credit-category/add-credit-category";
    }

    @PostMapping("/credit-category/addcreditcategory")
    public String addCreditCategory(CreditCategory creditCategory){
        creditCategoryService.addCreditCategory(creditCategory);
        return "redirect:/credit-category/";
    }

}
