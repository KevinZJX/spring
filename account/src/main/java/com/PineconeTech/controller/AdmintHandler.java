package com.PineconeTech.controller;

import com.PineconeTech.entity.Admin;
import com.PineconeTech.entity.User;
import com.PineconeTech.repository.AdminRepository;
import com.PineconeTech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdmintHandler {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Object object=null;
        switch (type){
            case "user":
                object=userRepository.login(username,password,type);
                break;
            case "admin":
                object=adminRepository.login(username, password, type);
                break;
        }
        return object;
    }
    @GetMapping("/findAll/{index}/{limit}")
    public List<Admin> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return adminRepository.findAll(index, limit);
    }
    @GetMapping("/findById/{id}")
    public Admin findById(@PathVariable("id") long id){
        return adminRepository.findById(id);
    }
    @GetMapping("/count")
    public int count(){
        return adminRepository.count();
    }
    @PostMapping("/save")
    public void save(@RequestBody Admin admin){
        adminRepository.save(admin);
    }
    @PutMapping("/update")
    public void update(@RequestBody Admin admin){
        adminRepository.update(admin);
    }
    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        adminRepository.deleteById(id);
    }
}
