package com.PineconeTech.controller;

import com.PineconeTech.entity.User;
import com.PineconeTech.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return userFeign.findAll(index,limit);
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userFeign.findById(id);
    }
    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }
    @PostMapping("/save")
    public void save(User user){
        userFeign.save(user);
    }
    @PutMapping("/update")
    public void update(User user){
        userFeign.update(user);
    }
    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
    }
}
