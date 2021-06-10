package com.readysoft.personalwallet.controller;


import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.service.BudgetService;
import com.readysoft.personalwallet.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {


    private BudgetService budgetService;
    private PaymentService paymentService;

    @Autowired
    public HomeController(BudgetService budgetService, PaymentService paymentService) {
        this.budgetService = budgetService;
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal CustomUserDetail user,Model model){
        List<Budget> budgetList = budgetService.getAllBudgetFromId(user.getUser().getId());
        int totalAmountOfPayment = paymentService.totalAmount(user.getUser().getId());
        int remainingBudget = budgetList.get(0).getAmount() - totalAmountOfPayment;

        List<Payment> lastTenPayment =
                getLastTenPayment(paymentService.getAllPaymentDescendingOrderWithUserId(user.getUser().getId()));

        model.addAttribute("budgetList", budgetList);
        model.addAttribute("totalPayment", totalAmountOfPayment);
        model.addAttribute("remainingBudget", remainingBudget);
        model.addAttribute("lastTenPayment", lastTenPayment);
        return "index";
    }

    private List<Payment> getLastTenPayment(List<Payment> paymentList){
        if(paymentList.size()> 0) {
            List<Payment> lastTenPayment = new ArrayList<>();
            for (int i = 0; i < paymentList.size(); i++) {
                lastTenPayment.add(paymentList.get(i));
                if (i == 10) {
                    break;
                }
            }
            return lastTenPayment;
        }
        return paymentList;
    }
    
}
