package com.PineconeTech.repository;

import com.PineconeTech.entity.Admin;

import java.util.List;

public interface AdminRepository {
    public Admin login(String username,String password,String type);
    public List<Admin> findAll(int index, int limit);
    public int count();
    public Admin findById(long id);
    public void save(Admin user);
    public void update(Admin user);
    public void deleteById(long id);
}
