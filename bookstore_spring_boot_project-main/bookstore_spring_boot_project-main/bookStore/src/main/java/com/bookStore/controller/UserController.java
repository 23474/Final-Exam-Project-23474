package com.bookStore.controller;

import com.bookStore.entity.User;
import com.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/new")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New Admin");
        return "signUp";

    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addAttribute("message", "Successfully");
        return "login";

    }

    @GetMapping("/user/login")
    public String showLoginForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }


    @PostMapping("/user/login/save")
    public String userLogin(Model model, User user, RedirectAttributes ra) {
        User savedUser = service.findUserByPassword(user.getPassword());

        if (savedUser != null && savedUser.getPassword().equals(user.getPassword())) {

            return "user_dash";
        } else {

            ra.addFlashAttribute("message", "Invalid Credentials");

            return "redirect:/user/login";
        }

    }

}
