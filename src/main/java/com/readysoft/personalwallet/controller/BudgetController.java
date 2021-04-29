package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.BudgetService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @GetMapping("/budget/")
    public String listBudget(Model model) {
        model.addAttribute("listBudgets", budgetService.getAllBudget());
        return "/budget/index";
    }

    @GetMapping("/budget/add-budget")
    public String addBudget(Model model) {
        User user = userService.getUser(1);
        model.addAttribute("budget", new Budget());
        model.addAttribute("user", user);
        return "/budget/add-budget";
    }

    @PostMapping("budget/addBudget")
    public String saveBudget(Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/budget/";
    }

}
