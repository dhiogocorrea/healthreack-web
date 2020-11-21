package com.grupo30.dao;

import java.util.List;

public interface Dao<T> {
    
    T get(int id);
    
    List<T> getAll();
    
    List<T> getByUser(int codUsuario);
    
    int insert(T t);
    
    boolean update(int id, T t);
    
    boolean delete(int id);
}