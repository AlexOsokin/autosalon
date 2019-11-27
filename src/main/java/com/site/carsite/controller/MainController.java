package com.site.carsite.controller;

import com.site.carsite.domain.Tech;
import com.site.carsite.repos.TechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller//модуль который слушает запросы по адресу /greeting и возвращает данные (файл шаблон "greeting")
public class MainController {

    @Autowired
    private TechRepo techRepo;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/a1")
    public String about(Map<String, Object> model) {
            return "a1";
    }


    @GetMapping("/main")
    public String main(Principal principal, Map<String, Object> model){
        if(principal.getName().equals("ad")) {
            Iterable<Tech> message = techRepo.findAll();
            model.put("messages", message);
            return "main";
        }
        else{
            Iterable<Tech> message = techRepo.findAll();
            model.put("messages", message);
            return "main1";
        }
    }

    @PostMapping("filter")
    public String filter(Principal principal, @RequestParam String filter, Map<String, Object> model){
        List<Tech> messages1;
            messages1 = techRepo.findByType(filter);
            model.put("messages", messages1);
            if(principal.getName().equals("ad")){
                return "main";
            }
            else {
                return "main1";
            }
    }
    @PostMapping("filter1")
    public String filter1(Principal principal, @RequestParam Integer filter1, Map<String, Object> model){
        List<Tech> messages2;
        messages2 = techRepo.findByPrice(filter1);
        model.put("messages", messages2);
        if(principal.getName().equals("ad")){
            return "main";
        }
        else {
            return "main1";
        }
    }
}