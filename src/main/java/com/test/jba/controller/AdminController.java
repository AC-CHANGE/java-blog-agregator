package com.test.jba.controller;

import com.test.jba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String users(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/{id}")
    public String detail(Model model, @PathVariable int id){
        model.addAttribute("user", userService.findAOneWithBlogs(id));
        return  "user-detail";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable int id){
        userService.delete(id);
        return "redirect:/users.html";
    }
}
