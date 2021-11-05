/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.controllers;

import com.hotel.web.model.DateDiscount;
import com.hotel.web.model.StudentDiscount;
import com.hotel.web.service.DiscountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiscountController {

    private DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/disc_mgn")
    public String listDateDiscount(Model model) {
        model.addAttribute("dateDiscs", discountService.getAllDateDiscount());
        model.addAttribute("studentDisc", discountService.getStudentDiscount());
        return "disc_mgn";
    }

    @GetMapping("/disc_mgn/new")
    public String createDateDiscountForm(Model model) {

        DateDiscount dateDiscount = new DateDiscount();
        model.addAttribute("dateDiscount", dateDiscount);
        return "create_date_disc";

    }

    @PostMapping("/disc_mgn")
    public String saveDateDiscount(@ModelAttribute("dateDiscount") DateDiscount dateDiscount) {
        discountService.saveDateDiscount(dateDiscount);
        return "redirect:/disc_mgn";
    }

    @GetMapping("/disc_mgn/edit/date_disc/{id}")
    public String editDateDiscountForm(@PathVariable Long id, Model model) {
        model.addAttribute("dateDiscount", discountService.getDateDiscountId(id));
        return "edit_date_disc";
    }

    @GetMapping("/disc_mgn/edit/std_disc/{id}")
    public String editStudentDiscountForm(@PathVariable Long id, Model model) {
        model.addAttribute("stdDiscount", discountService.getStudentDiscount());
        return "edit_std_disc";
    }

    @PostMapping("/disc_mgn/date_disc/{id}")
    public String updateDateDiscount(@PathVariable Long id,
                             @ModelAttribute("dateDiscount") DateDiscount dateDiscount,
                             Model model) {

        DateDiscount existingDateDiscount = discountService.getDateDiscountId(id);
        existingDateDiscount.setId(id);
        existingDateDiscount.setDate(dateDiscount.getDate());
        existingDateDiscount.setName(dateDiscount.getName());
        existingDateDiscount.setPercent(dateDiscount.getPercent());
        discountService.updateDateDiscount(existingDateDiscount);
        return "redirect:/disc_mgn";
    }

    @PostMapping("/disc_mgn/std_disc/{id}")
    public String updateStudentDiscount(@PathVariable Long id,
                                     @ModelAttribute("studentDisc") StudentDiscount studentDiscount,
                                     Model model) {

        StudentDiscount existingStdDiscount = discountService.getStudentDiscount();
        existingStdDiscount.setId(id);
        existingStdDiscount.setPercent(studentDiscount.getPercent());
        discountService.updateStudentDiscount(existingStdDiscount);
        return "redirect:/disc_mgn";
    }


    @GetMapping("/disc_mgn/date_disc/{id}")
    public String deleteDateDiscount(@PathVariable Long id) {
        discountService.deleteDateDiscountId(id);
        return "redirect:/disc_mgn";
    }
}
