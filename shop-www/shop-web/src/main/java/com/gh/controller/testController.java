package com.gh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class testController {

    @RequestMapping("index")
    public String index(Model model,String name){
        model.addAttribute("hello","Hello test");
        model.addAttribute("name",name);
        return "test";
    }

    @RequestMapping("find/{id}")
    public Integer findById(@PathVariable Integer id){
        return id;
    }

}
