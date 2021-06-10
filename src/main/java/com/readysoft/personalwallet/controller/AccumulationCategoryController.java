package com.readysoft.personalwallet.controller;

import com.readysoft.personalwallet.model.AccumulationCategory;
import com.readysoft.personalwallet.model.PaymentCategory;
import com.readysoft.personalwallet.service.AccumulationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class AccumulationCategoryController {

    @Autowired
    private AccumulationCategoryService accumulationCategoryService;

    @GetMapping("accumulation-category")
    public String listAccumulationCategory(Model model){
        model.addAttribute("listAccumulationCategory", accumulationCategoryService.listAccumulationCategory());
        return "accumulation-category/index";
    }

    @GetMapping("/accumulation-category/add-accumulation-category")
    public String addFormAccumulationCategory(Model model){
        model.addAttribute("accumulationCategory",new PaymentCategory());
        return "/accumulation-category/add-accumulation-category";
    }

    @PostMapping("/accumulation-category/addaccumulationcategory")
    public String addAccumulationCategory(AccumulationCategory accumulationCategory){
        accumulationCategoryService.addAccumulationCategoy(accumulationCategory);
        return "redirect:/accumulation-category/";
    }
}
