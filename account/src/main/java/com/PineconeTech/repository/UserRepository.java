package com.PineconeTech.repository;

import com.PineconeTech.entity.User;

import java.util.List;

public interface UserRepository {
    public Object login(String username, String password, String type);
    public List<User> findAll(int index, int limit);
    public int count();
    public User findById(long id);
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
