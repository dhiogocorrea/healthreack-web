package com.grupo30.dao;

import java.util.List;

public interface Dao<T> {
    
    T get(long id);
    
    List<T> getAll();
    
    int insert(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
}