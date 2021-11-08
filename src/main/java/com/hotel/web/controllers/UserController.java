/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */

package com.hotel.web.controllers;

import com.hotel.web.model.User;
import com.hotel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model,HttpSession session,  @ModelAttribute User user) {

        if(!userService.isRegistered(user)) {
            model.addAttribute("errMessage","You have not an account. Please register");
            return "login";
        }
        user = userService.signIn(user);
            session.setAttribute("user",user);
            return "redirect:/";
    }

    @RequestMapping({"/logout"})
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "index";
    }



    @GetMapping("/registration")
    public String registration(Model model, HttpSession session) {
        model.addAttribute("user",new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, HttpSession session, @Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errMessage","The email is not valid");
            return "registration";
        }
        if(userService.isRegistered(user) ) {
            model.addAttribute("message","You have an account with this email");
            return "registration";
        }
        session.setAttribute("user",userService.registerUser(user));
        return "redirect:/";
    }

    @GetMapping("/profile/edit")
    public String ditProfileForm(HttpSession session, Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        return "edit_profile";
    }
    @PostMapping("/user_mgn")
    public String updateUser(HttpSession session,
                             @ModelAttribute("user") User user) {
        System.out.println(user.getIsManager());
        userService.updateUser(user);
        session.setAttribute("user",user);
        return "redirect:/profile";
    }

    @GetMapping ("/profile/delete")
    public String deleteUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        userService.deleteUser(user);
        session.removeAttribute("user");
        model.addAttribute("successMessage","You were removed successfully");
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile() {
        return "user_mgn";
    }

}
