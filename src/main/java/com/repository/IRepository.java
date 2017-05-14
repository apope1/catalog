package com.repository;

import java.util.List;

/**
 * Created by Andu on 12.05.2017.
 */
public interface IRepository<T> {
    
    void add(T entity);
    
    List<T> getAll();
    
    T getOne(int id);
    
    void update(int id, T newEntity);
    
    void delete(T entity);
    
}
