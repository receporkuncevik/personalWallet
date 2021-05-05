package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.PaymentCategoryService;
import com.readysoft.personalwallet.service.PaymentService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @GetMapping("/payment")
    public String listPayment(Model model){
        model.addAttribute("listPayments", paymentService.listPayment());
        return "/payment/index";
    }

    @GetMapping("/payment/add-payment")
    public String addShowPayment(Model model){
        model.addAttribute("payment",  new Payment());
        model.addAttribute("paymentCategories", paymentCategoryService.listPaymentCategories());
        return "/payment/add-payment";
    }

    @PostMapping("/payment/addPayment")
    public String addPayment(Payment payment){
        paymentService.addPayment(payment);
        return "redirect:/payment";
    }

}
