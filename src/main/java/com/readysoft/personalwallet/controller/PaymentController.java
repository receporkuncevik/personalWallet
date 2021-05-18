package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.PaymentCategoryService;
import com.readysoft.personalwallet.service.PaymentService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listPayment(@AuthenticationPrincipal CustomUserDetail user, Model model){
        User currentUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listPayments", paymentService.getAllPaymentWithUserId(currentUser.getId()));
        return "/payment/index";
    }

    @GetMapping("/payment/add-payment")
    public String addShowPayment(@AuthenticationPrincipal CustomUserDetail user,Model model){
        model.addAttribute("payment",  new Payment());
        model.addAttribute("paymentCategories", paymentCategoryService.listPaymentCategories());
        return "/payment/add-payment";
    }

    @PostMapping("/payment/addPayment")
    public String addPayment(@AuthenticationPrincipal CustomUserDetail user,Payment payment){
        payment.setUser(user.getUser());
        paymentService.addPayment(payment);
        return "redirect:/payment";
    }

    @GetMapping("/payment/edit/{id}")
    public String updatePayment(@AuthenticationPrincipal CustomUserDetail user, @PathVariable("id") Integer id, Model model){
        Payment existPayment = paymentService.findById(id).get();
        model.addAttribute("payment", existPayment);
        model.addAttribute("paymentCategories", paymentCategoryService.listPaymentCategories());
        return "/payment/add-payment";
    }

    @GetMapping("/payment/delete/{id}")
    public String deletePayment(@PathVariable("id") Integer id){
        paymentService.deleteById(id);
        return "redirect:/payment";
    }

}
