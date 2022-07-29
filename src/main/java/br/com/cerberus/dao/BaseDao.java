package br.com.cerberus.dao;

import java.util.List;

public interface BaseDao<T> {

    public void add(T obj);

    public T get(Integer k);
    
    public List<T> getAll();

    public void remove(Integer k);
    
    public void show();
    
    public void showListaChaveValor();
}
