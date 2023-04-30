package com.example.kord.service;

import java.util.List;

import com.example.kord.models.Users;
import com.example.kord.repository.CRUD;

public class UserImpliment implements CRUD<Users> {
    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public Users getById(int id) {
        return null;
    }

    @Override
    public boolean add(Users variable) {
        return false;
    }

    @Override
    public boolean update(Users variable) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
