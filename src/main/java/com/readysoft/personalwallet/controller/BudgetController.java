package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.CustomUserDetail;
import com.readysoft.personalwallet.model.User;
import com.readysoft.personalwallet.service.BudgetService;
import com.readysoft.personalwallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private UserService userService;

    @GetMapping("/budget")
    public String listBudget(@AuthenticationPrincipal CustomUserDetail user,Model model) {
        User currentUser = userService.findById(user.getUser().getId()).get();
        model.addAttribute("listBudgets", budgetService.getAllBudgetFromId(currentUser.getId()));
        return "/budget/index";
    }

    @GetMapping("/budget/add-budget")
    public String addBudget(@AuthenticationPrincipal CustomUserDetail user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("budget", new Budget());
        return "/budget/add-budget";
    }

    @PostMapping("budget/addBudget")
    public String saveBudget(@AuthenticationPrincipal CustomUserDetail user,Budget budget) {
        budget.setUser(user.getUser());
        budgetService.saveBudget(budget);
        return "redirect:/budget";
    }

    @GetMapping("budget/edit/{id}")
    public String showEditBudget(@AuthenticationPrincipal CustomUserDetail user,@PathVariable("id") Integer id,Model model){
        Budget budget = budgetService.findById(id).get();
        budget.setUser(user.getUser());
        model.addAttribute("budget", budget);

        return "/budget/add-budget";
    }

    @GetMapping("budget/delete/{id}")
    public String deleteBudget(@PathVariable("id") Integer id,Model model){
        budgetService.deleteById(id);
        return "redirect:/budget";
    }

}
