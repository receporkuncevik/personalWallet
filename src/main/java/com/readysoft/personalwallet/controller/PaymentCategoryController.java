package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.PaymentCategory;
import com.readysoft.personalwallet.service.PaymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentCategoryController {

    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @GetMapping("/payment-category")
    public String listPaymentCategory(Model model){
        model.addAttribute("listPaymentCategory", paymentCategoryService.listPaymentCategories());
        return "/payment-category/index";
    }

    @GetMapping("/payment-category/add-payment-category")
    public String addFormPaymentCategory(Model model){
        model.addAttribute("paymentCategory",new PaymentCategory());
        return "/payment-category/add-payment-category";
    }

    @PostMapping("/payment-category/addpaymentcategory")
    public String addPaymentCategory(PaymentCategory paymentCategory){
        paymentCategoryService.addPaymentCategory(paymentCategory);
        return "redirect:/payment-category/";
    }


}
