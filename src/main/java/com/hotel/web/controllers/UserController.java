package com.hotel.web.controllers;

import com.hotel.web.model.User;
import com.hotel.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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

    @RequestMapping({"/logout"})
    public String logout(HttpSession session,Model model){
        session.setAttribute("username",null);
        return "index";
    }

    @PostMapping("/login")
    public String login(HttpSession session, @ModelAttribute User user) {
        if (userService.isAuthenticated(user.getUsername(),user.getPassword())) {
            session.setAttribute("username",user.getUsername());
            return "redirect:/";
        }

        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(HttpSession session, @ModelAttribute User user) {
        userService.addUser(user);
        session.setAttribute("username",user.getUsername());
        return "redirect:/";
    }

}
