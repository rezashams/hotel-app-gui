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
    public String login(Model model,HttpSession session,  @ModelAttribute User user) {

        if(!userService.isRegistered(user)) {
            model.addAttribute("error","You have not an account. please register");
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



    @GetMapping ("/deleteuser")
    public String deleteUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.deleteUser(user);
        session.removeAttribute("user");
        return "redirect:/";
    }

}
