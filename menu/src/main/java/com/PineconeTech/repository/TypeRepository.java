package com.PineconeTech.repository;

import com.PineconeTech.entity.Type;

import java.util.List;

public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
