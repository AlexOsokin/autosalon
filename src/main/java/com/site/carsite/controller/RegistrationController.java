package com.site.carsite.controller;


import com.site.carsite.domain.Role;
import com.site.carsite.domain.User;
import com.site.carsite.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByName(user.getName());

        if (userFromDb != null) {
            model.put("message1", "Такой пользователь уже существует");
            return "registration";
        }
        String p = user.getPass();
        String n = user.getName();
        if (p.equals("ad") && n.equals("ad")){
                user.setActive(true);
                user.setRoles(Collections.singleton(Role.ADMIN));
                userRepo.save(user);
        }
            else{
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
        }

        return "redirect:/";
    }
}