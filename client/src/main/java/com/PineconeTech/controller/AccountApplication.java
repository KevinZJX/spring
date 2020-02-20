package com.PineconeTech.controller;

import com.PineconeTech.entity.Admin;
import com.PineconeTech.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountApplication {
    @Autowired
    private AccountFeign accountFeign;
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("type") String type){
        Object object = accountFeign.login(username, password, type);
        System.out.println(object);
        return "index";
    }
    @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public List<Admin> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return accountFeign.findAll(index, limit);
    }
}
