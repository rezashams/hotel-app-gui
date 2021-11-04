package com.hotel.web.controllers;

import com.hotel.web.model.User;
import com.hotel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @ModelAttribute User user) {
        if (userService.isRegistered(user)) {
            session.setAttribute("user",user);
            return "redirect:/";
        }

        return "login";
    }

    @RequestMapping({"/logout"})
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "index";
    }



    @GetMapping("/registration")
    public String registration(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user==null?new User():user);

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(HttpSession session, @Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if(userService.isRegistered(user)) {
            session.setAttribute("message","You have an account with this email");
            return "registration";
        }
        userService.registerUser(user);
        session.setAttribute("user",user);

        return "redirect:/";
    }


    @PostMapping("/deleteUser")
    public String deleteUser(HttpSession session) {
        String userEmail = session.getAttribute("userEmail").toString();
        session.removeAttribute("userEmail");
        return "redirect:/";
    }

}
