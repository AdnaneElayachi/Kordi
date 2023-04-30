package com.example.kord.repository;

import java.util.List;

public interface CRUD<T> {
    List<T> getAll();


    T getById(int id);


    boolean add(T variable);


    boolean update(T variable);


    boolean delete(T variable);
}
