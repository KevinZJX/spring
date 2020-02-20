package com.PineconeTech.feign;

import com.PineconeTech.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("account")
public interface AccountFeign {
    @PostMapping("/admin/login")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);
    @GetMapping("/admin/findAll/{index}/{limit}")
    public List<Admin> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
}
